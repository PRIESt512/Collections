package ru.hacker.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class TestCollection {

  public static void main(String[] args) {

    BiFunction<Integer, Integer, String> test = (a, b) -> {
      System.out.println("Test lambda");
      return String.valueOf(a + b);
    };

    testFunc(test);

   // System.out.println(test.andThen(result -> "test " + result).apply(2, 3));

   /* Map<Car, String> treeMap = new TreeMap<>((o1, o2) -> {
      System.out.println(a[0]);
      a[0]++;
      return o1.getName().compareTo(o2.getName());
    });
    treeMap.put(new Car("ZMW", 2156), "2156");
    treeMap.put(new Car("BMW", 20000), "20000");
    treeMap.put(new Car("AMW", 1_000_000), "1_000_000");

    for (Map.Entry<Car, String> item : treeMap.entrySet()) {
      System.out.println(String.format("Key %s - Value %s", item.getKey(), item.getValue()));
    }*/


   /* Map<String, String> strings = new HashMap<>();
    strings.put("BMW", "Синий");
    strings.put("Москвич", "Красный");
   *//* System.out.println(strings.put("Жигуль", "Артем Сергеевич"));
    System.out.println(strings.put("Жигуль", "Черный"));*//*

    //strings.forEach((key, value) -> System.out.println(String.format("Key %s - Value %s", key, value)));
    strings.forEach(TestCollection::each);
    *//*for (Map.Entry<String, String> item : strings.entrySet()) {
      System.out.println(String.format("Key %s - Value %s", item.getKey(), item.getValue()));
    }*//*
     */
  }

  public static void testFunc(BiFunction<Integer, Integer, String> test) {
    System.out.println(test.apply(2, 3));
  }

  public static void each(String key, String value) {
    System.out.println(String.format("Key %s - Value %s", key, value));
  }
}
