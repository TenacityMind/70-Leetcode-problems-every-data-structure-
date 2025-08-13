package main.arrays.twopointers;

import java.util.Arrays;

public class SortedArraySquare {
    //Two Pointers from the Ends
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. Initialize pointers
        int left = 0;
        int right = n - 1;
        int resultIndex = n - 1; // Pointer to fill the result array from the end

        // 2. Loop until the pointers meet or cross
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // 3. Compare and place the larger square at the end of the result array
            if (leftSquare > rightSquare) {
                result[resultIndex] = leftSquare;
                left++; // Move the left pointer in
            } else {
                result[resultIndex] = rightSquare;
                right--; // Move the right pointer in
            }
            resultIndex--; // Move the result pointer to the next position to fill
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -4, -3, -2, -1})));
    }

    /* Split, Square and Merge
    public static int[] sortedSquares(int[] nums) {

        // check if first element is positive
        if(nums[0]>=0){
            for(int i=0;i<nums.length;i++){
                nums[i]=nums[i]*nums[i];
            }
            return nums;
        }

        //find the first positive index
        int firstPositiveIndex=nums.length-1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]>=0){
                firstPositiveIndex = i;
                break;
            }
        }

        //reverse the negative numbers and square them
        int[] a = new int[firstPositiveIndex];
        for(int i =0; i<firstPositiveIndex; i++){
            a[i] =nums[firstPositiveIndex-i-1]*nums[firstPositiveIndex-i-1];
        }
        //System.out.println(Arrays.toString(a));

        //positive numbers and square them
        int[] b = new int[nums.length - firstPositiveIndex];
        for(int i=0; i<nums.length - firstPositiveIndex; i++){
            b[i] = nums[firstPositiveIndex+i]*nums[firstPositiveIndex+i];
        }
       //System.out.println(Arrays.toString(b));

        // merge a and b
        int aIndex = 0;
        int bIndex = 0;
        int[] result = new int[nums.length];
        int resultIndex = 0;
        while(aIndex<a.length && bIndex<b.length){
            if(a[aIndex]<=b[bIndex]){
                result[resultIndex++]=a[aIndex++];
            }else{
                result[resultIndex++]=b[bIndex++];
            }
        }

        if(aIndex<a.length){
            while(resultIndex<result.length){
                result[resultIndex++]=a[aIndex++];
            }
        }else{
            while(resultIndex<result.length){
                result[resultIndex++]=b[bIndex++];
            }
        }
        return result;
    }
    */
}

