package arrays.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//PROBLEM
/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

https://leetcode.com/problems/combination-sum/
 */

//APPROACH
/*
Reduced to coin-change problem (unbounded knapsack)
 */

//The backtracking algo has a bug doesn't print all combinations in some cases.
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSumDPBacktrack(int[] candidates, int target) {

        Arrays.sort(candidates);

        //Binary 2D Binary Array to store if a 'j' sum is possible with subset of 'i' integers
        int[][] cache = new int[candidates.length][target+1];
        for(int i=0; i<candidates.length; ++i){
            cache[i][0] = 1;
        }

        for(int i=1; i<=target; ++i){
            cache[0][i] = (i % candidates[0]==0)?1:0;
        }

        for(int i=1; i<candidates.length; ++i){
            for(int j=candidates[i]; j<=target; ++j){
                int diff = j - candidates[i];
                //Check if sum 'j - candidates[i[' is possible with same integer or a previous integer.
                cache[i][j] = ((cache[i-1][diff] == 1) || (cache[i][diff]) == 1) ? 1:0;
            }
        }

        //Print DP array
//        for(int i=0; i<candidates.length; ++i){
//            for(int j=0; j<=target; ++j){
//                System.out.print(cache[i][j] + " ");
//            }
//            System.out.println();
//        }

        //Backtrack from DP array.
        for(int i=0; i<candidates.length; ++i){
            if(cache[i][target] == 1){
                List<Integer> r = new ArrayList<>();
                backTrack(cache, candidates, i, target, r);
            }
        }

        return res;
    }

    public void backTrack(int[][] cache, int[] candidates, int i, int target, List<Integer> r){

        if(target == 0){
            Collections.sort(r);
//            System.out.println("adding "  + r.toString());
            if(!res.contains(r)){
                res.add(r);
            }
            return;
        }

        int tmp = target;
        int start = candidates[i];

        r.add(start);
        tmp -= start;

        List<Integer> r1 = new ArrayList<>(r);

//        System.out.println(i + " " + tmp);
        if(cache[i][tmp] == 1){
//            System.out.println("**************");
            backTrack(cache, candidates, i, tmp, r);
        }

//        System.out.println("test " + r1.toString() + " " + (i-1) + " " + tmp);
        if(i-1>=0 && cache[i-1][tmp] == 1){
//            System.out.println("$$$$$$$$$$$$");
            backTrack(cache, candidates, i-1, tmp, r1);
        }
    }
}
