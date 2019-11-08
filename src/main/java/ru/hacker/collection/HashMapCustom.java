package ru.hacker.collection;

import java.util.LinkedList;
import java.util.Objects;

public class HashMapCustom {

  public Object[] massiv = new Object[10_000_000];

  private class Entry {

    public Entry(Object key, LinkedList<String> values) {
      this.key = key;
      this.values = values;
    }

    Object key;

    LinkedList<String> values;
  }

  public void put(Object key, String value) {
    //System.out.println(key.hashCode());
    int hash = Objects.hash(key);
    int index = Math.abs(hash % 10_000_000);
    //System.out.println(index);
    //TODO: добавить проверки, что если по этому индексу есть элемент,
    //то добавить его в список
    Entry entry = new Entry(key, new LinkedList<>());
    entry.values.add(value);
    massiv[index] = entry;
  }

  public Object get(Object key) {
    int hash = Objects.hash(key);
    int index = Math.abs(hash % 10_000_000);
    return massiv[index];
  }
}
