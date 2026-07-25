package com.debu.DataStructure;

public class GraphA {

    private int[][] matrix;

    public GraphA(int n)
    {
        matrix = new int[n][n];
    }

    public void addEdge(int u,int v, boolean undirected)
    {
        matrix[u][v] = 1;
        if(undirected)
        {
            matrix[v][u] = 1;
        }
    }
}
