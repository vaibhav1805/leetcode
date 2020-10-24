package arrays.subarrays;

//PROBLEM
/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.

https://leetcode.com/problems/minimum-size-subarray-sum/
*/


public class MinimumSizeSubarraySum {
    public int minSubArrayLenBrute(int s, int[] nums) {

        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; ++i){
            sum = 0;
            for(int j=i; j<nums.length; ++j){
                sum += nums[j];

                if(sum >= s){
                    ans = Math.min(ans, j-i+1);
                    break;
                }
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans:0;
    }

    public int minSubArrayLenDP(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        for(int i=1; i<nums.length; ++i){
            sums[i] = sums[i-1] + nums[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; ++i){
            for(int j=i; j<nums.length; ++j){

                int sum = sums[j] - sums[i] + nums[i];
                if(sum >= s){
                    ans = Math.min(ans, j-i+1);
                    break;
                }
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans:0;
    }

//APPROACH
/*
nums = [2,3,1,2,4,3]
Take two pointers i & j.
Move i till we hit sum>=s condition and keep j at start.
Once condition hit start removing one element from left and add on right
*/

    public int minSubArrayLenTwoPointer(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for(int i=0; i<nums.length; ++i){
            sum += nums[i];
            while(sum >=s){
                res = Math.min(res, i-j+1);
                sum -= nums[j];
                j++;
            }
        }

        return (res!=Integer.MAX_VALUE) ? res:0;
    }
}
