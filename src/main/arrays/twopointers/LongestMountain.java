package main.arrays.twopointers;

public class LongestMountain {
    public int longestMountain(int[] arr) {
        // This variable will store the maximum mountain length found so far.
        int result = 0;

        // Loop through the array to find potential peaks.
        // We start at index 1 and end at the second-to-last element
        // because a peak must have a left and a right neighbor.
        for (int i = 1; i < arr.length - 1; i++) {

            // Check if the current element arr[i] is a peak.
            // A peak is strictly greater than its immediate left and right neighbors.
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                // Initialize two pointers, 'left' and 'right' of the peak's index.
                int left = i-1;
                int right = i+1;

                // Expand to the left to find the start of the mountain.
                // This while loop moves the 'left' pointer backwards as long as
                // it's part of an uphill slope from the left.
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand to the right to find the end of the mountain.
                // This while loop moves the 'right' pointer forwards as long as
                // it's part of a downhill slope to the right.
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the current mountain (from 'left' to 'right').
                // Update the result if this mountain is the longest one found yet.
                result = Math.max(result, right - left + 1);
            }
        }

        // Return the maximum length found after checking all possible peaks.
        return result;
    }
    public static void main(String[] args) {
        LongestMountain lm = new LongestMountain();
        System.out.println(lm.longestMountain(new int[]{2,1,4,7,3,2,5}));
        System.out.println(lm.longestMountain(new int[]{2,2,2}));
    }
}
