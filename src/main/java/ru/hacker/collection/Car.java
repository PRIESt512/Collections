package ru.hacker.collection;

import java.util.Objects;

public class Car implements Comparable<Car> {

  private final String name;

  private final int id;

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

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
    return Objects.hash(name, id);
  }

  @Override
  public String toString() {
    return "Car{" + "name='" + name + '\'' + ", id=" + id + '}';
  }

  @Override
  public int compareTo(Car o) {
    if(o == null) throw new NullPointerException("Так нельзя!");
    return this.id - o.id;
  }
}
