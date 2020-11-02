package graphs;

//PROBLEM
/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]

https://leetcode.com/problems/01-matrix/
 */

import java.util.LinkedList;
import java.util.Queue;

//APPROACH
/*
BFS can be used to find shortest distances. Whenever 1 is encountered start a BFS at that index.
 */
public class OIMatrix {
    public class Pair{
        public int x;
        public int y;
        public int d;
        public Pair(){}
        public Pair(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public int bfs(int[][] matrix, int i, int j, int dist){
        int distance = 0;

        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j, 0));

        boolean found = false;

        while(!q.isEmpty() && !found){

            int size = q.size();

            for(int k =0; k<size; ++k){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                int d = p.d;

                if(matrix[x][y] == 0){
                    found = true;
                    distance = d;
                    break;
                }

                for(int[] m : moves){
                    int nextX = x + m[0];
                    int nextY = y + m[1];

                    if(nextX<0 || nextY<0 || nextX>=matrix.length || nextY>=matrix[0].length){
                        continue;
                    }
                    q.add(new Pair(nextX, nextY, d+1));
                }
            }
        }
        return distance;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                if(matrix[i][j] == 1){
                    res[i][j] = bfs(matrix, i, j, 0);
                }else{
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }
}
