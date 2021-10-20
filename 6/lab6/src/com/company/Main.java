package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int menu;

        Graph graph = new Graph(6);
        Graph graph2 = new Graph(6);

        graph2.addVertex(new Vertex("A"));
        graph2.addVertex(new Vertex("B"));
        graph2.addVertex(new Vertex("C"));
        graph2.addVertex(new Vertex("D"));
        graph2.addVertex(new Vertex("E"));
        graph2.addVertex(new Vertex("F"));

        graph2.addEdge("A", "B");
        graph2.addEdge("A", "C");
        graph2.addEdge("C", "F");
        graph2.addEdge("B", "E");
        graph2.addEdge("E", "F");
        graph2.addEdge("D", "B");
        graph2.addEdge("F", "B");
        graph2.addEdge("E", "D");

        graph2.print();
        System.out.println("------------------------------------");
        graph2.removeEdge("C", "F");
        graph2.removeEdge("A", "B");

        graph2.print();
        System.out.println("------------------------------------");
        graph2.deleteVertex("A");

        graph2.print();
        System.out.println("------------------------------------");
        System.out.println("DFS");

        graph2.DFS(3);
        System.out.println("");
        graph2.SetVisit(false);

        System.out.println("------------------------------------");
        System.out.println("BFS");

        graph2.BFS(2);
        graph2.SetVisit(false);

        /*do{
            System.out.println("1.Створення графа");
            System.out.println("2.Додавання вершини");
            System.out.println("3.Додавання ребра");
            System.out.println("4.Відалення дуги");
            System.out.println("5.Обхід в глибину");
            System.out.println("6.Обхід в ширину");
            System.out.println("7.Вивід матрииці суміжності");
            System.out.println("8.Вихід");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();

            switch (menu) {
                case 1 -> {
                    graph.addVertex(new Vertex("A"));
                    graph.addVertex(new Vertex("B"));
                    graph.addVertex(new Vertex("C"));
                    graph.addVertex(new Vertex("D"));
                    graph.addVertex(new Vertex("E"));
                    graph.addVertex(new Vertex("F"));

                    graph.addEdge("A", "B");
                    graph.addEdge("A", "C");
                    graph.addEdge("C", "F");
                    graph.addEdge("B", "E");
                    graph.addEdge("E", "F");
                    graph.addEdge("D", "B");
                    graph.addEdge("F", "B");
                    graph.addEdge("E", "D");
                }
                case 2 -> {
                    String vertex;
                    Scanner scannerVertex = new Scanner(System.in);
                    vertex = scannerVertex.nextLine();
                    graph.addVertex(new Vertex(vertex));
                }
                case 3 -> {
                    String start, end;
                    System.out.println("Введіть початок: ");
                    Scanner scannerStart = new Scanner(System.in);
                    start = scannerStart.nextLine();
                    System.out.println("Введіть кінець: ");
                    Scanner scannerEnd = new Scanner(System.in);
                    end = scannerEnd.nextLine();
                    graph.addEdge(start, end);
                }
                case 4 -> {
                    System.out.println("Видаляемо ребро C, F");
                    System.out.println("Видаляемо ребро A, B");
                    graph.removeEdge("C", "F");
                    graph.removeEdge("A", "B");
                    graph.print();
                }
                case 5 -> {
                    graph.BFS(2);
                    //System.out.println();
                }
                case 6 -> {
                    graph.DFS(3);
                    //System.out.println();
                }
                case 7 -> graph.print();
            }

        } while (menu != 8);*/
    }
}