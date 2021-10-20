package com.company;

import java.util.*;

public class Graph2 { //граф списком суміжності

    private List<Vertex> vertexes;
    private List<List<Vertex>> adjencyList;
    private int currAmountVertex;

    public Graph2() {
        currAmountVertex = -1;
        vertexes = new ArrayList<>();
        adjencyList = new ArrayList<>();
    }

    public void makeEdge(String to, String from) {
        try {
            int To = 0, From = 0, IndxFound = -1;
            for (Vertex v : vertexes) {
                ++IndxFound;
                if (to.equals(v.getChar()))
                    To = IndxFound;
                if (from.equals(v.getChar()))
                    From = IndxFound;
            }
            adjencyList.get(To).add(vertexes.get(From));
            adjencyList.get(From).add(vertexes.get(To));
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Вершин не існує");
        }
    }

    public void removeEdge(String to, String from){
        try {
            int To = -1, From = -1, IndxFound = -1;
            for (int i = 0; i < currAmountVertex + 1; i++) {
                ++IndxFound;
                if (to.equals(vertexes.get(i).getChar()))
                    To = IndxFound;
                if (from.equals(vertexes.get(i).getChar()))
                    From = IndxFound;
            }
            adjencyList.get(To).remove(vertexes.get(From));
            adjencyList.get(From).remove(vertexes.get(To));
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Вершин не існує");
        }
    }

    public void addVertex(Vertex vertex){
        ++currAmountVertex;
        vertexes.add(vertex);
        adjencyList.add(new ArrayList<Vertex>());
    }

    public void deleteVertex(String Char){
        int indxFoundVertex = -1;
        boolean found = false;
        for (int i = 0 ; i < currAmountVertex + 1; i++) {
            if(Char.equals(vertexes.get(i).getChar())) {
                ++indxFoundVertex;
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Немає такої вершини!");
            return;
        }
        --currAmountVertex;
        Vertex deleted = vertexes.remove(indxFoundVertex);
        List<Vertex> deletedV = adjencyList.remove(indxFoundVertex);
    }

    private ArrayList<Vertex> findNeighbours(Vertex node) {
        ArrayList<Vertex> neighbours = new ArrayList<>();
        int nodeIndex = vertexes.indexOf(node); //індекс пошуку для вузла

        if(nodeIndex != -1) //додавання сусідів вузлів до списку
            for (Vertex i : adjencyList.get(nodeIndex))
                neighbours.add(i);

        return neighbours;
    }

    public void DFS(int start) throws ArrayIndexOutOfBoundsException { //обход в ширину

        if(start > vertexes.size() || start < 0 ) //виняток для неправильного номера вузла
            throw new ArrayIndexOutOfBoundsException("Поза межами");

        Stack<Vertex> stack = new  Stack<>(); //стек для зберігання сусідніх та невідвіданих вузлів
        stack.add(vertexes.get(start)); //почніть з пуску стартового вузла

        while (!stack.isEmpty()) {
            Vertex element = stack.pop(); //вимкнути вузол зі стеку та надрукувати, якщо його не відвідали
            if(!element.wasVisited) {
                System.out.print(element.getChar() + "  ->  ");
                element.wasVisited = true;
            }

            List<Vertex> neighbours= findNeighbours(element); //отримати сусідні вузли
            Collections.reverse(neighbours);   //переверніть список, щоб перенести вузли в стек у правильному порядку

            for (Vertex nodeIter : neighbours) { //штовхання невідвіданих сусідніх вузлів
                if(nodeIter != null && !nodeIter.wasVisited)
                    stack.add(nodeIter);
            }
        }
        System.out.println();

        //набір, не відвідуваний для всіх вузлів
        for(Vertex nodeIter : vertexes)
            nodeIter.wasVisited = false;
    }

    public void BFS(int start) throws ArrayIndexOutOfBoundsException { //обход в глубину

        if(start > vertexes.size() || start < 0 ) //виняток для неправильного номера вузла
            throw new ArrayIndexOutOfBoundsException("Поза межами");

        Queue<Vertex> queue = new LinkedList<>(); //черга для зберігання сусідніх та невідвіданих вузлів
        vertexes.get(start).wasVisited = true; //почніть з пуску стартового вузла
        queue.add(vertexes.get(start));

        while (!queue.isEmpty()) {
            Vertex element = queue.remove();
            System.out.print(element.getChar() + "  ->  ");

            ArrayList<Vertex> neighbours = findNeighbours(element); //отримати сусідні вузли
            for (Vertex nodeIter : neighbours) { //штовхання невідвіданих сусідських вузлів
                if(nodeIter!=null && !nodeIter.wasVisited) {
                    queue.add(nodeIter);
                    nodeIter.wasVisited = true;
                }
            }
        }
        System.out.println();
        //набір, не відвідуваний для всіх вузлів
        for(Vertex nodeIter : vertexes)
            nodeIter.wasVisited = false;
    }

    public void print(){
        for (Vertex v : vertexes)
            System.out.print(v.getChar() + " ");
        System.out.println(" ");

        for(int i = 0; i < currAmountVertex + 1; i++) {
            System.out.print(vertexes.get(i).getChar() + " ");
            for (Vertex v : adjencyList.get(i))
                System.out.print(v.getChar() + " ");
            System.out.println();
        }
    }

    public void SetVisit(boolean res){
        for (Vertex v : vertexes)
            v.wasVisited = res;
    }
}