package main.arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // Loop through the array with the first pointer 'i'
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element of the triplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Use two pointers for the rest of the array
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate values for the left element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate values for the right element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // Move pointers to find the next unique pair
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, need a larger number
                    left++;
                }  else {
                    // Sum is too large, need a smaller number
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

        int[] nums2 = new int[]{0,1,1};
        System.out.println(threeSum(nums2));

        int[] nums3 = new int[]{0,0,0};
        System.out.println(threeSum(nums3));
    }
}
