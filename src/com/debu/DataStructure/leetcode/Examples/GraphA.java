package com.debu.DataStructure.leetcode.Examples;

import java.util.Arrays;

public class GraphA {
    private int[][] matrix;
    private boolean undirected;

    public GraphA(int n,boolean undirected)
    {
        matrix = new int[n][n];
        this.undirected = undirected;
    }

    public void addEdge(int u,int v)
    {
        matrix[u][v] = 1;
        if(undirected)
        {
            matrix[v][u] = 1;
        }
    }

    public void printMatrix()
    {
        for(int[] row:matrix)
        {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args)
    {
        GraphA graph = new GraphA(5,true);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,0);
        graph.printMatrix();
    }
}
