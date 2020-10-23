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
nums1(x) = {1,3,8,9,15}
nums2(y) = {7,11,18,9,21,25}

Partition both arrays into left & right such that maxLeftX >= minRightY && maxLeftY >= minRightY).
Reference Array should be the smaller array i.e x in our case.

if m+n is odd, median = Max(maxLeftX, maxLeftY))
if m+n is even, median = Average(Max(maxLeftX, maxLeftY), Min(minRightX, minRightY)
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
