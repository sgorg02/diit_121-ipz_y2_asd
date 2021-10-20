package com.company;

import java.util.*;

public class Graph { //граф матриці суміжності

    private Vertex[] vertices;
    public int currAmountOfVer;
    private int amount_verteces;
    private int[][] adjacency_matrix;

    public Graph(int vertex) {
        amount_verteces = vertex;
        adjacency_matrix = new int[amount_verteces + 1][amount_verteces + 1];
        for (int i = 0; i < amount_verteces + 1; i++)
            for (int j = 0; j < amount_verteces + 1; j++)
                adjacency_matrix[i][j] = 0;

        vertices = new Vertex[amount_verteces + 1];
        currAmountOfVer = -1;
    }

    public void addEdge(String start, String end) {
        try {
            int Start = -1, End = -1;
            for (int i = 0; i < currAmountOfVer + 1; i++) {
                if(start.equals(vertices[i].getChar()))
                    Start = i;
                if(end.equals(vertices[i].getChar()))
                    End = i;
            }
            adjacency_matrix[Start][End] = 1;
            adjacency_matrix[End][Start] = 1;
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Вершин не існує");
        }
    }

    public void removeEdge(String start, String end) {
        try {
            int Start = -1, End = -1;
            for (int i = 0; i < currAmountOfVer + 1; i++) {
                if(start.equals(vertices[i].getChar()))
                    Start = i;
                if(end.equals(vertices[i].getChar()))
                    End = i;
            }
            adjacency_matrix[Start][End] = 0;
            adjacency_matrix[End][Start] = 0;
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Вершин не існує");
        }
    }

    public void addVertex(Vertex vertex) {
        if(currAmountOfVer > amount_verteces)
            System.out.println("Немає місця для додавання Vertex");
        else {
            ++currAmountOfVer;
            vertices[currAmountOfVer] = vertex;
        }
    }

    public void deleteVertex(String Char) {
        int indxOfVertexFound = -1;
        boolean found = false;
        for (int i = 0; i < currAmountOfVer + 1; i++) {
            if(Char.equals(vertices[i].getChar())) {
                indxOfVertexFound = i;
                currAmountOfVer--;
                found = true;
            }
        }
        if(!found) {
            System.out.println("Немає такої вершини!");
            return;
        }
        for(int i = indxOfVertexFound; i < currAmountOfVer + 1; i++) {
            vertices[i] = vertices[i + 1];
            for (int j = 0; j < currAmountOfVer + 1; j++) {
                adjacency_matrix[i][j] = adjacency_matrix[i + 1][j + 1];
            }
        }
    }

    private ArrayList<Vertex> findNeighbours(Vertex node) {
        int nodeIndex=-1;
        ArrayList<Vertex> neighbours = new ArrayList<>();

        //індекс пошуку для вузла
        for (int i = 0; i <currAmountOfVer + 1; i++) {
            if(vertices[i].equals(node)) {
                nodeIndex=i;
                break;
            }
        }

        //додавання сусідніх вузлів до списку
        if(nodeIndex != -1) {
            for (int i = 0; i < currAmountOfVer + 1; i++)
                if(adjacency_matrix[nodeIndex][i] == 1)
                    neighbours.add(vertices[i]);
        }

        return neighbours;
    }

    public void BFS(int start){ //обход в ширину
        if(start > currAmountOfVer ||  start < 0 ) //виняток для неправильного номера вузла
            throw new ArrayIndexOutOfBoundsException("Поза межами");

        Queue<Vertex> queue = new LinkedList<>(); //черга для зберігання сусідніх та невідвіданих вузлів
        queue.add(vertices[start]); //почніть з пуску стартового вузла
        vertices[start].wasVisited = true;

        while (!queue.isEmpty())
        {
            Vertex element = queue.remove();
            System.out.print(element.getChar() + "  ->  ");

            ArrayList<Vertex> neighbours = findNeighbours(element); //отримати сусідні вузли
            for (Vertex node : neighbours) { //штовхання невідвіданих сусідських вузлів
                if(node != null && !node.wasVisited) {
                    queue.add(node);
                    node.wasVisited = true;
                }
            }
        }
        System.out.println();
        //набір, не відвідуваний для всіх вузлів
        for (int i = 0; i < currAmountOfVer + 1; i++)
            vertices[i].wasVisited = false;
    }

    public void print() {
        for (int i = 0; i < currAmountOfVer + 1; i++)
            System.out.print("   " +  vertices[i].getChar());

        System.out.println();
        for (int i = 0; i < currAmountOfVer + 1; i++) {
            System.out.print(vertices[i].getChar());
            for (int j = 0; j < currAmountOfVer + 1; j++)
                System.out.print("   " + adjacency_matrix[i][j]);
            System.out.println();
        }
    }

    public void DFS(int start)  throws ArrayIndexOutOfBoundsException { //обход в глубину
        if(start > currAmountOfVer ||  start < 0 ) //виняток для неправильного номера вузла
            throw new ArrayIndexOutOfBoundsException("Поза межами");

        Stack<Vertex> stack = new Stack<>(); //стек для зберігання сусідніх та невідвіданих вузлів
        stack.add(vertices[start]); //почніть з пуску стартового вузла

        while(!stack.isEmpty()) {
            Vertex element=stack.pop(); //вимкнути вузол зі стеку та надрукувати, якщо його не відвідали
            if(!element.wasVisited) {
                System.out.print(element.getChar() + "  ->  ");
                element.wasVisited = true;
            }

            ArrayList<Vertex> neighbours = findNeighbours(element); //отримати сусідні вузли
            Collections.reverse(neighbours); //переверніть список, щоб перенести вузли в стек у правильному порядку
            for(Vertex node : neighbours) //штовхання невідвіданих сусідських вузлів
                if(node != null && !node.wasVisited)
                    stack.push(node);

        }

        System.out.println();
        //набір, не відвідуваний для всіх вузлів
        for (int i = 0; i < currAmountOfVer + 1; i++)
            vertices[i].wasVisited = false;
    }

    public void SetVisit(boolean res){
        for (int i = 0; i < currAmountOfVer; i++)
            vertices[i].wasVisited = res;
    }
}