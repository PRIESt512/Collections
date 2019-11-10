package ru.hacker.collection;

import java.util.LinkedList;
import java.util.Objects;

public class HashMapCustom {

  //TODO: необходимо сделать динамическое расширение массива при достижении 75% его заполненности
  //т.е. у нас 16 элементов по умолчанию, как только мы заполнили его на 12 элементов, увеличиваем
  //массив в 2 раза. А потом пробегаемся по всем уже заполненным индексам и заново пересчитываем
  //индексы с учетом новой размерности.
  //Задание со звездочкой: сделать разный loadFactor - а именно указывать не только 75%, а любое другое
  // коэффициент загрузки в виде float - 0.75f; добавьте Generics.
  public static final int M = 9_999_999;

  public Object[] massiv = new Object[M];

  private class Entry {

    // Сущность, которая хранится в нашей корзине (buckets). Как было сказано, в корзине может быть несколько сущностей из-за коллизии
    public Entry(Object key, Object value) {
      this.key = key;
      this.value = value;
    }

    Object key;//это Car
    Object value;// это какое-то значение, привязанное к Car
  }


  public void put(Object key, String value) {
    int index = hash(key);

    LinkedList<Entry> entries = (LinkedList<Entry>)massiv[index];
    if (entries == null) {
      Entry entry = new Entry(key, value);
      entries = new LinkedList<>();
      entries.add(entry);
      massiv[index] =
          entries;//один элемент массива - это одна корзина, в которой может хранится несколько Entry из-за коллизий, поэтому, чтобы не потерять значения, используем связанный список, для
      //хранения всех ключей, у которых, к сожалению, совпали значения хешей (но по-хорошему, пусть хеши и совпали, но equals должен на таких ключах давать false, иначе все теряет смысл)
    } else {
      Entry entry = new Entry(key, value);
      entries.add(entry);
    }
  }

  /**
   * Поскольку нам нужен индекс массива, а не 32-битное число, мы в наших реализациях
   * объединяем вызов hashCode() с модульным хешированием, которые нам дает целые числа от 0 до М-1.
   * В идеале, пользовательская функция hashCode() должна равномерно распределять ключи на все 32-битные значения
   * результата.
   * То есть для любого объекта можно записать x.hashCode() и в принципе ожидать, что с одинаковой вероятностью  будет
   * возвращено одно из 2^32 значений.
   * РЕАЛИЗАЦИЯ в Java для типов String, Integer, Double, File, URL придерживается этого соглашения. Но для собственного
   * типа стоит делать это самостоятельно.
   *
   * @param key
   *
   * @return index массива
   */
  private int hash(Object key
  ) {//вся магия хеширования по сути здесь, получить индекс в массиве и все, счастье близко. Если бы не было коллизий полностью, было бы идеально.
    int h = Objects.hashCode(key);
    int index = (h & 0x7fff_ffff)
        % M;// это маскирование знакового бита (чтобы превратить 32-битное число в неотрицательное 31-битное), а затем как в модульном хешировании, вычисляем остаток от деления;
    //при таком подходе в качестве размера хеш-таблицы берут ПРОСТОЕ число, тогда задействуются все биты хеш-кода и мы как-то минимизируем коллизию
    if (index == 23531) {
      Car car = (Car)key;
      System.out.println(h);
      System.out.println(car);
      System.out.println("!!!");
    }
    return index;
  }

  /**
   * Получить объект по ключу
   *
   * @param key
   *
   * @return
   */
  public Object get(Object key) {
    int index = hash(key);
    LinkedList<Entry> entries = (LinkedList<Entry>)massiv[index];
    if (entries != null && entries.size()
        == 1) {//идеальная ситуация, коллизий нет, в корзине один элемент - просто берем его из связанного списка и все.
      return entries.get(0).value;
    } else if (entries != null) {//не очень хорошо, у нас коллизия, нужно что-то делать
      for (int i = 0; i < entries.size(); i++) {
        Entry entry = entries.get(i);
        if (entry.key.equals(key)) {
          return entry.value;
        }
      }
    }
    return null;
  }
}
