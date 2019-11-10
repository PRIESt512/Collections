package ru.hacker.collection;

import java.util.Objects;

public class Start {

  public static void main(String[] args) {
/*
    Car car2 = new Car(String.valueOf((9_999_000)), 9_999_000);

    System.out.println((car2.hashCode() &0x7fff_ffff) % 9_999_999);*/

    HashMapCustom map = new HashMapCustom();

    map.put(new Car("BMW", 1), "Всеволод");
    map.put(new Car("BMW", 2), "Иван");
    map.put(new Car("BMW", 3), "Артем Сергеевич");

    System.out.println(map.get(new Car("BMW", 3)));

    // List<Car> linkedList = new LinkedList<>();
    /*Car carTemp = null;
    for (int i = 0; i < map.M; i++) {
      Car car = new Car(String.valueOf(i), i);
      //linkedList.add(car);
      carTemp = car;
      map.put(car, null);
    }
    int M = 9_999_999;
    int count = 0;
    for (int i = 0; i < M; i++) {
      if (map.massiv[i] == null) {
        count++;
      }
    }
    System.out.println("Коллизий = " + count);
    System.out.println(String.format("Оригинал - %s", carTemp));
    long time = System.currentTimeMillis();
    System.out.println(String.format("Найденное значение - %s", map.get(carTemp)));
    System.out.println(String.format("Поиск в мс на map - %s", System.currentTimeMillis() - time));*/
/*
    System.out.println(String.format("Оригинал - %s", carTemp));
    time = System.currentTimeMillis();
    System.out.println(String.format("Найденное значение - %s", linkedList.contains(carTemp)));
    System.out.println(String.format("Поиск в мс на linkedList - %s", System.currentTimeMillis() - time));*/

  }

}

class Car {

  private final String name;

  private final int id;

  public Car(String name, int id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car)o;
    return id == car.id && name.equals(car.name);
  }

  @Override
  public int hashCode() {
    //return Objects.hash(name, id);
    return 1;
  }

  @Override
  public String toString() {
    return "Car{" + "name='" + name + '\'' + ", id=" + id + '}';
  }
}
