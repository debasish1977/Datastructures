package com.debu.DataStructure.leetcode.Examples;

import java.util.*;

public class GraphB {
    private boolean undirected;
    private ArrayList<ArrayList<Integer>> adj;

    public GraphB(int n,boolean undirected)
    {
        this.undirected = undirected;
        this.adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            adj.add(list);
        }
    }

    public void addEdge(int u,int v)
    {
        adj.get(u).add(v);
        if(undirected)
        {
            adj.get(v).add(u);
        }
    }

     private void bfsCore(int source,boolean[] visited)
     {
         if(visited[source] == false)
         {
             visited[source] = true;
         }
         Queue<Integer> queue = new LinkedList<Integer>();
         queue.add(source);
         while(queue.size() > 0)
         {
             System.out.println(queue.peek());
             int top = queue.remove();
             List<Integer> neighbors = adj.get(top);
             for(Integer neighbor:neighbors)
             {
                 if(visited[neighbor] == false)
                 {
                     visited[neighbor] = true;
                     queue.add(neighbor);
                 }
             }
         }
     }

     public void bfs()
     {
         boolean[] visited = new boolean[adj.size()];
         Arrays.fill(visited,false);
         for(int i=0; i<visited.length;i++)
         {
             if(visited[i]==false)
             {
                 bfsCore(i,visited);
             }
         }
     }


    public void printGraph()
    {
        for(ArrayList<Integer> list:adj)
        {
            System.out.println(list.toString());
        }
    }
    public static void main(String[] args)
    {
        GraphB graph = new GraphB(5,true);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.printGraph();
    }
}
