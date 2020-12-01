package arrays.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * PROBLEM
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * SOLUTION
 * DFS State-space tree for all possibilities
 */
public class Permutations {
    Set<Integer> visited;
    List<List<Integer>> res;

    public void dfs(int[] nums, int i, List<Integer> l){
        visited.add(i);
        l.add(nums[i]);

        if(visited.size() == nums.length){
            res.add(new ArrayList<>(l));
        }

        for(int j=0; j<nums.length; ++j){
            if(!visited.contains(j)){
                dfs(nums, j, l);
            }
        }
        visited.remove(i);
        l.remove(l.size()-1);
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<nums.length; ++i){
            dfs(nums, i, l);
        }
        return res;
    }
}
