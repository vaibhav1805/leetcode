package dynamic;

/**
 * PROBLEM
 * Given an integer array arr, you should partition the array into (contiguous) subarrays of length at most k.
 * After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning.
 *
 *
 * Input: arr = [1,15,7,9,2,5,10], k = 3
 * Output: 84
 * Explanation: arr becomes [15,15,15,9,10,10,10]
 */

public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];

        for(int i=1; i<arr.length; ++i){
            int maxVal = arr[i];
            int maxSum = arr[i] + dp[i-1];

            for(int j=i-1; j>=0 && j> i-k; --j){
                maxVal = Math.max(maxVal, arr[j]);
                if(j == 0){
                    maxSum = Math.max(maxSum, maxVal * (i-j+1));
                }else{
                    maxSum = Math.max(maxSum, dp[j-1] + (maxVal * (i-j+1)));
                }
            }
            dp[i] = maxSum;
        }

        return dp[arr.length-1];
    }
}
