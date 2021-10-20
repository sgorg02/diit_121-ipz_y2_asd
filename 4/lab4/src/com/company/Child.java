package com.company;


public class Child implements Comparable<Child>{
    private final int height;

    public Child(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Child o) {
        //давайте будем сортировать объекты Employee по значению поля id от меньшего к большему
        //будем возвращать отрицательное число, 0 или положительное число по каждому сравнению объектов
        // здесь мы просто отнимаем значение поля одного объекта от значения поля другого объекта
        // в результате получим 1 из 3 вариантов описанных выше вариантов
        return (this.height - o.height);
    }
}
