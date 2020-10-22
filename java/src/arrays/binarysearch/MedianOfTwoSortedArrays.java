package arrays.binarysearch;

import java.util.*;


//PROBLEM
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

https://leetcode.com/problems/median-of-two-sorted-arrays/
*/


//APPROACH
/*
nums1(x) = {1,3,8,9,15}
nums2(y) = {7,11,18,9,21,25}

Partition both arrays into left & right such that maxLeftX >= minRightY && maxLeftY >= minRightY).
Reference Array should be the smaller array i.e x in our case.

if m+n is odd, median = Max(maxLeftX, maxLeftY))
if m+n is even, median = Average(Max(maxLeftX, maxLeftY), Min(minRightX, minRightY)
*/

/*
start = 0,  end =5
    ==> partitionX=2, partitionY=3
    ==> X: {1,3} | {8,9,15}
    ==> Y: {7,11,18} | {21,25}
*/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //If x is larger than array y --> swap.
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = nums1.length;

        int xLen= end;
        int yLen = nums2.length;

        while(start <= end){
            int partitionX = (start + end)/2;
            int partitionY = (xLen + yLen + 1)/2 - partitionX;

            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE:nums1[partitionX-1];
            int minRightX = (partitionX==xLen) ? Integer.MAX_VALUE:nums1[partitionX];

            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE:nums2[partitionY-1];
            int minRightY = (partitionY==yLen) ? Integer.MAX_VALUE:nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((xLen + yLen)%2 == 0){
                    return (((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2);
                }else{
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                end = partitionX - 1;
            }else{
                start = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
