package com.company;

import static java.util.Arrays.fill;

public class Graph {
    private Vertex[] vertices;
    public int currAmountOfVer;
    private int amount_verteces;
    private int[][] adjacency_matrix;
    private int INF = Integer.MAX_VALUE / 2;

    public Graph(int vertex) {
        amount_verteces = vertex;
        adjacency_matrix = new int[amount_verteces + 1][amount_verteces + 1];
        for (int i = 0; i < amount_verteces + 1; i++)
            for (int j = 0; j < amount_verteces + 1; j++)
                adjacency_matrix[i][j] = INF;

        vertices = new Vertex[amount_verteces + 1];
        currAmountOfVer = -1;
    }

    public void addVertex(Vertex vertex) {
        if(currAmountOfVer > amount_verteces)
            System.out.println("Немає місця для додавання Vertex");
        else {
            ++currAmountOfVer;
            vertices[currAmountOfVer] = vertex;
        }
    }

    public void addEdge(String start, String end, int Dist) {
        try {
            int Start = -1, End = -1;
            for (int i = 0; i < currAmountOfVer + 1; i++) {
                if(start.equals(vertices[i].getChar()))
                    Start = i;
                if(end.equals(vertices[i].getChar()))
                    End = i;
            }
            adjacency_matrix[Start][End] = Dist;
            adjacency_matrix[End][Start] = Dist;
        }
        catch (ArrayIndexOutOfBoundsException index) {
            System.out.println("Вершин не існує");
        }
    }

    public int MST() {
        int ret = 0; // вес MST
        boolean[] used = new boolean [amount_verteces]; // массив пометок
        int[] dist = new int [amount_verteces]; // массив расстояния


        fill(dist, INF); // устанаавливаем расстояние до всех вершин INF
        dist[0] = 0; // для начальной вершины положим 0

        for (;;) {
            int v = -1;

            for (int nv = 0; nv < amount_verteces; nv++) // перебираем вершины
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) { // выбираем самую близкую непомеченную вершину
                    //System.out.println("Самая близкая вершына " + nv);
                    v = nv;
                }

            if (v == -1)
                break; // ближайшая вершина не найдена

            used[v] = true; // помечаем ее

            for (int nv = 0; nv < amount_verteces; nv++)
                if (!used[nv] && adjacency_matrix[v][nv] < INF) // для всех непомеченных смежных
                    dist[nv] = Math.min(dist[nv], adjacency_matrix[v][nv]); // улучшаем оценку расстояния


            System.out.println();
            for (int i = 0; i < amount_verteces; i++)
                System.out.println(dist[i]);
        }

        for (int v = 0; v < amount_verteces; v++)
            ret += dist[v];

        return ret;
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

    public void print() {
        for (int i = 0; i < currAmountOfVer + 1; i++)
            System.out.print("\t" +  vertices[i].getChar());

        System.out.println();
        for (int i = 0; i < currAmountOfVer + 1; i++) {
            System.out.print(vertices[i].getChar());
            for (int j = 0; j < currAmountOfVer + 1; j++) {
                if (adjacency_matrix[i][j] == INF)
                    System.out.print("\t" + 0);
                else
                    System.out.print("\t" + adjacency_matrix[i][j]);
            }
            System.out.println();
        }
    }
}
