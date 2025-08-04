package main.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumbersSmallerThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);

        Map<Integer, Integer> countMap = new HashMap<>();
        // Populate the map. The index 'i' is the count of smaller numbers.
        for (int i = 0; i < nums.length; i++) {
            // Use putIfAbsent to only store the index of the first occurrence.
            countMap.putIfAbsent(numsCopy[i], i);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i< nums.length ; i++) {
            result[i] = countMap.get(nums[i]);
        }

        return result;

    }
    public static void main(String[] args) {
        int[] nums = new int[] {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
        int[] nums2 = new int[] {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums2)));
        int[] nums3 = new int[] {7,7,7,7};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums3)));
    }
}
