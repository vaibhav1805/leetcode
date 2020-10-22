package arrays.binarysearch;

public class MedianOfTwoSortedArraysLinear {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[n+m];

        int i =0, j=0, k=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;
            }else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i<m){
            res[k] = nums1[i];
            k++;
            i++;
        }

        while(j<n){
            res[k] = nums2[j];
            k++;
            j++;
        }

        int mid = (m+n)/2;
        if((m+n)%2 ==0){
            return ((double)(res[mid] + res[mid-1]))/2;
        }else{
            return (double)res[mid];
        }
    }
}
