package main.arrays.slidingwindows;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    /**
     * Checks if there are any two distinct indices i and j in the array
     * such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * @param nums The input array of integers.
     * @param k   The maximum distance between indices.
     * @return True if a nearby duplicate exists, false otherwise.
     */
    public boolean containsDuplicate(int[] nums, int k) {

        // Use a HashSet to store the elements within the current "window" of size k.
        // This allows for O(1) average time complexity for add, remove, and contains checks.
        Set<Integer> window = new HashSet<>();

        // Iterate through the array one element at a time.
        for (int i = 0; i < nums.length; i++) {

            // The .add() method returns false if the element is already in the set.
            // If it returns false, we've found a duplicate within our window.
            if (!window.add(nums[i])) {
                // Since our window is at most size k, this duplicate must be nearby.
                return true;
            }

            // Maintain the size of the window to be at most k.
            // If the window size exceeds k, we need to remove the oldest element.
            if (window.size() > k) {
                // The oldest element in the window is at index i-k.
                window.remove(nums[i - k]);
            }
        }

        // If the loop completes without finding any duplicates in any window, return false.
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
