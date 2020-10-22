package arrays.binarysearch;

//PROBLEM
/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

https://leetcode.com/problems/find-peak-element/

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
*/

//APPROACH
/*
Find nums[mid] with Binary Search such that nums[mid]>nums[mid-1] && nums[mid] > nums[mid+1]
*/

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid==nums.length-1){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
            else if(mid==0){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                }else{
                    start = mid+1;
                }
            }

            else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] <= nums[mid-1]){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return nums[0];
    }
}
