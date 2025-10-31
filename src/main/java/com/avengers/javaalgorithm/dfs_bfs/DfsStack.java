package com.avengers.javaalgorithm.dfs_bfs;

import java.util.*;

public class DfsStack {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    static{
        graph.put(1, Arrays.asList(2, 5, 9));
        graph.put(2, Arrays.asList(1, 3));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3));
        graph.put(5, Arrays.asList(1, 6, 8));
        graph.put(6, Arrays.asList(5, 7));
        graph.put(7, Arrays.asList(6));
        graph.put(8, Arrays.asList(5));
        graph.put(9, Arrays.asList(1, 10));
        graph.put(10, Arrays.asList(9));
    }

    public static List<Integer> dfs (Map<Integer, List<Integer>> adjacentGraph, int startNode){
         Stack<Integer> stack = new Stack<>();
         stack.push(startNode);
         ArrayList<Integer> visited = new ArrayList<>();

         while(!stack.isEmpty()){
             int curNode = stack.pop();
             visited.add(curNode);

             for(int adjacentNode : adjacentGraph.get(curNode)){
                 if(!visited.contains(adjacentNode)){
                     stack.push(adjacentNode);
                 }
             }
         }
         return visited;
    }


    public static void main(String[] args) {
        // [1, 9, 10, 5, 8, 6, 7, 2, 3, 4]
        System.out.println(dfs(graph, 1));
    }
}
