package arrays.rotations;

/**
 * PROBLEM
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums, return the minimum element of this array.
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * APPROACH
 * Binary Search
 */
public class FindMinimunInRotatedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid-1 >=0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            else if(mid+1 < nums.length && nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid] > nums[start]){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }

        return (nums[0] < nums[nums.length-1]) ? nums[0] : nums[nums.length -1];
    }
}
