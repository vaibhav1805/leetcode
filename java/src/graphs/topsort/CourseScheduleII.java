package graphs.topsort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//PROBLEM
/*
There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

https://leetcode.com/problems/course-schedule-ii/
 */

//APPROACH
/*
1) topological sort to derive the sequence.
2) Also check for cycle, if there is a cycle there won't be any possible solution, return [].
 */
public class CourseScheduleII {
    boolean hasCycle = false;

    public void dfs(Map<Integer, LinkedList<Integer>> graph, int i, Map<Integer, Integer> visited, LinkedList<Integer> l){
        if(visited.containsKey(i) && visited.get(i) == 2){
            return;
        }

        if(visited.containsKey(i) && visited.get(i) == 1){
//            System.out.println("Cycle found");
            hasCycle = true;
            return;
        }

        visited.put(i, 1);

        for(Integer j : graph.get(i)){
            dfs(graph, j, visited, l);
        }

        // System.out.println(i);
        if(hasCycle){
            l.removeAll(l);
        }else{
            l.addFirst(i);
            visited.put(i, 2);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> res = new LinkedList<>();

        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();

        for(int i=0; i<numCourses; ++i){
            visited.put(i, 0);
        }

        for(int i=0; i<numCourses; ++i){
            graph.put(i, new LinkedList<>());
        }

        for(int[] pre : prerequisites){
            LinkedList l = graph.get(pre[1]);
            l.add(pre[0]);
        }

        for(Integer k : graph.keySet()){
            if(visited.containsKey(k) && visited.get(k) == 0){
                dfs(graph, k, visited, res);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
