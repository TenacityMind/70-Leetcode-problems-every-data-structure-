package main.arrays.slidingwindows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    /**
     * Finds all pairs of elements with the minimum absolute difference from an array.
     *
     * @param arr The input array of distinct integers.
     * @return A list of pairs, where each pair has the minimum absolute difference.
     */
    public static List<List<Integer>> findMinimumAbsoluteDifference(int[] arr) {
        // Step 1: Sort the array. This is the key step, as it ensures the
        // minimum difference will only ever be between adjacent elements.
        Arrays.sort(arr);

        // Initialize minDifference to the largest possible integer value.
        int minDifference = Integer.MAX_VALUE;

        // --- First Pass: Find the value of the minimum difference ---
        // We loop from the start to the second-to-last element to compare adjacent pairs.
        for (int i = 0; i < arr.length - 1; i++) {
            // If the difference between the current pair is smaller than what we've seen so far...
            if (arr[i + 1] - arr[i] < minDifference) {
                // ...update minDifference to this new smallest value.
                minDifference = arr[i + 1] - arr[i];
            }
        }

        // Create a list to store our final pairs.
        List<List<Integer>> res = new ArrayList<>();

        // --- Second Pass: Collect all pairs that match the minimum difference ---
        for (int i = 0; i < arr.length - 1; i++) {
            // If the difference between the current pair equals our target minDifference...
            if (arr[i + 1] - arr[i] == minDifference) {
                // ...add this pair to our result list.
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        // Return the final list of pairs.
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumAbsoluteDifference(new int[]{4,2,1,3}));
        System.out.println(findMinimumAbsoluteDifference(new int[]{1,3,6,10,15}));
        System.out.println(findMinimumAbsoluteDifference(new int[]{3,8,-10,23,19,-4,-14,27}));
    }
}
