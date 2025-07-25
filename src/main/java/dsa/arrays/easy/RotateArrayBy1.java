package dsa.arrays.easy;
/*
Left Rotate the Array by One

Problem Statement: Given an array of N integers, left rotate the array by one place.

Examples

Example 1:
Input: N = 5, array[] = {1,2,3,4,5}
Output: 2,3,4,5,1
Explanation:
Since all the elements in array will be shifted
toward left by one so ‘2’ will now become the
first index and and ‘1’ which was present at
first index will be shifted at last.


Example 2:
Input: N = 1, array[] = {3}
Output: 3
Explanation: Here only element is present and so
the element at first index will be shifted to
last index which is also by the way the first index.
 */
import java.util.Arrays;

public class RotateArrayBy1 {
    public static void main(String[] args) {
        int [] nums ={1,2,3,4,5};
        int [] nums2 ={1};
        int [] nums3 ={};
        rotate(nums);
        rotate(nums2);
        rotate(nums3);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
    public static void rotate(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        int temp = nums[0];
        for(int index=0; index<n-1; index++){
            nums[index] = nums[index+1];
        }
        nums[n-1] = temp;
    }
}
