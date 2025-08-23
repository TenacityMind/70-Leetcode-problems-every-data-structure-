package main.arrays.slidingwindows;

public class MinimumSubArray {
    public static int minSubArrayLen(int target, int[] nums) {
        // Initialize the left pointer of the window and the current sum
        int left = 0;
        int currentSum = 0;

        // Initialize minLength to a value larger than any possible result
        int minLength = Integer.MAX_VALUE;

        // The 'right' pointer expands the window by iterating through the array
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the window's sum
            currentSum += nums[right];

            // Once the sum is large enough, shrink the window from the left
            // to find the smallest possible valid subarray.
            while (currentSum >= target) {
                // Update the minimum length found so far
                minLength = Math.min(minLength, right - left + 1);

                // Subtract the leftmost element and move the left pointer to the right
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, no valid subarray was found.
        // Otherwise, return the smallest length found.
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));

    }
}
