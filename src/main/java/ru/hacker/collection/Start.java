package ru.hacker.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Start {

  public static void main(String[] args) {
    ArrayList<Car> list = new ArrayList<>();
    //Car car = new Car("Жигули");
    HashMapCustom map = new HashMapCustom();

    List<Car> linkedList = new LinkedList<>();
    Car carTemp = null;
    for (int i = 0; i < 10_000_000; i++) {
      Car car = new Car(String.valueOf(i));
      linkedList.add(car);
      carTemp = car;
      map.put(car, null);
    }
    int count = 0;
    for (int i = 0; i < 10_000_000; i++) {
      if (map.massiv[i] == null) {
        count++;
      }
    }
    System.out.println("Коллизий = " + count);
    System.out.println(String.format("Оригинал - %s", carTemp));
    long time = System.currentTimeMillis();
    System.out.println(String.format("Найденное значение - %s", map.get(carTemp)));
    System.out.println(String.format("Поиск в мс на map - %s", System.currentTimeMillis() - time));

    System.out.println(String.format("Оригинал - %s", carTemp));
    time = System.currentTimeMillis();
    System.out.println(String.format("Найденное значение - %s", linkedList.contains(carTemp)));
    System.out.println(String.format("Поиск в мс на linkedList - %s", System.currentTimeMillis() - time));

  }

}

class Car {

  private String name;

  public Car(String name) {
    this.name = name;
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
    return Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
