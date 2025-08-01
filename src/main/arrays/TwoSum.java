package main.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //HashMap to store seen numbers and their indices.
        // Key: number, Value: index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //Check if the complement exists in the map.
            if (map.containsKey(target - nums[i])) {
                // If it exists, we found our pair.
                return new int[]{map.get(target - nums[i]), i};
            }
            // If complement not found, add the current number and its index to
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        result = twoSum(nums2, target2);
        System.out.println(Arrays.toString(result));
        int[] nums3 = {3,3};
        int target3 = 6;
        result = twoSum(nums3, target3);
        System.out.println(Arrays.toString(result));
    }
}
