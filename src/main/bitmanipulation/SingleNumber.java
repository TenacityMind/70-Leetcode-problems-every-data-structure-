package main.bitmanipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // Initialize the result to 0.
        int result = 0;

        // Iterate through each number in the array.
        for (int num : nums) {
            // XOR the current number with the result.
            // Duplicate numbers will cancel each other out.
            result = result ^ num;
        }

        // The remaining value is the single, unique number.
        return result;
    }
}
