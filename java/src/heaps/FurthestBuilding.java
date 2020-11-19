package heaps;

import java.util.*;

/**
 * PROBLEM
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 *
 *
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 * 
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] diffs = new int[heights.length];
        diffs[0] = 0;
        for(int i=1; i<heights.length; ++i){
            diffs[i] = heights[i] - heights[i-1];
        }

        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int i=0;
        for(; i<diffs.length; ++i){
            int diff = diffs[i];
            if(diff <= 0){
                continue;
            }
            else if(diff <= bricks){
                bricks -= diff;
                pq.add(diff);
            }else if(ladders > 0){
                if(!pq.isEmpty() && pq.peek() > diff){
                    Integer used = pq.poll();
                    bricks = bricks +used - diff;
                    pq.add(diff);
                }
                ladders--;
            }else{
                break;
            }
        }

        return i-1;
    }
}
