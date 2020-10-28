package arrays.matrix;

//Problem
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
 */

import java.util.ArrayList;
import java.util.List;


//Solution
/*
directions = {{0,1},{1,0},{0,-1},{-1,0}}
Every time a blockade is encountered change direction in above sequence in a circular fashion till all elements are visited.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m==0){
            return res;
        }
        int n = matrix[0].length;

        if(n==0){
            return res;
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        int xn=0, yn=0;

        int currentIndex = 0;
        int[] current = directions[currentIndex];

        while(!res.contains(matrix[xn][yn])){
            res.add(matrix[xn][yn]);
            int x = xn + current[0];
            int y = yn + current[1];

            if(x>=m || x<0 || y>=n || y<0 || res.contains(matrix[x][y])){
                currentIndex  = changeDirection(directions, currentIndex);
                current = directions[currentIndex];
            }
            xn = xn + current[0];
            yn = yn + current[1];

            if(xn>=m || xn<0 || yn>=n || yn<0){
                break;
            }
        }
        return res;
    }

    public int changeDirection(int[][] directions, int current){
        int next = (current+1)%directions.length;
        return next;
    }
}
