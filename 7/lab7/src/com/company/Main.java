package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph = new Graph(6);
        graph.addVertex(new Vertex("A"));
        graph.addVertex(new Vertex("B"));
        graph.addVertex(new Vertex("C"));
        graph.addVertex(new Vertex("D"));
        graph.addVertex(new Vertex("E"));
        graph.addVertex(new Vertex("F"));

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "C", 15);
        graph.addEdge("C", "F", 10);
        graph.addEdge("B", "E", 25);
        graph.addEdge("E", "F", 43);
        graph.addEdge("D", "B", 3);
        graph.addEdge("F", "B", 23);
        graph.addEdge("E", "D", 9);

        graph.print();

        System.out.println("MST = " + graph.MST());

    }
}
