package com.company;


// Вершинный класс
public class Vertex {
    private String Char;
    public boolean wasVisited; //для матриці суміжності

    public Vertex(String Char) {
        this.Char = Char;
        wasVisited = false;
    }

    public String getChar() {
        return Char;
    }
}