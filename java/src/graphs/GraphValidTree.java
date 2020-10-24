package graphs;

import java.util.*;

//Problem
/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
write a function to check whether these edges make up a valid tree.

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
 */

//Appraoch
/*
Check if the graph is acyclic and fully connected.
 */
public class GraphValidTree {
    public boolean validTreeBfS(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        //Populate graph with edges
        for(int[] edge :  edges){
            Set<Integer> s1 = graph.getOrDefault(edge[0], new HashSet<>());
            s1.add(edge[1]);
            graph.put(edge[0], s1);

            Set<Integer> s2 = graph.getOrDefault(edge[1], new HashSet<>());
            s2.add(edge[0]);
            graph.put(edge[1], s2);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(0);

        while(!q.isEmpty()){
            Integer node = q.poll();
            if(visited.contains(node)){
                return false;
            }
            visited.add(node);
            //Exploring a level
            for(Integer vertex : graph.getOrDefault(node, new HashSet<>())){
                q.add(vertex);
                //Removing reverse edge from edges from the map of edges as graph is undirected
                graph.get(vertex).remove(node);
            }
        }

        return visited.size() == n;
    }
}
