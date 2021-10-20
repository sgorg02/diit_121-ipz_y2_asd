package com.company;

public class Child {
    private int growth; // ключ узла
    private String name; // информацыоная часть
    private Child leftChild; // Левый узел потомок
    private Child rightChild; // Правый узел потомок

    public void printNode() { // Вывод значения узла в консоль
        System.out.println("Имя дитини: " + name + ", зріст: " + growth);
    }

    public int getGrowth() {
        return this.growth;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(final int value) {
        this.growth = value;
    }

    public void setName(final String value) {
        this.name = value;
    }

    public Child getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Child leftChild) {
        this.leftChild = leftChild;
    }

    public Child getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Child rightChild) {
        this.rightChild = rightChild;
    }
}