package arrays.rotations;

/**
 * PROBLEM
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 */
public class SearchRotatedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[start] == nums[mid]){
                start++;
                continue;
            }

            if(nums[mid] > nums[start]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        return false;
    }
}
