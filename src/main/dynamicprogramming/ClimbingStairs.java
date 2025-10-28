package main.dynamicprogramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // Handling Base Cases
        // If there's only 1 stair, there's only 1 way to climb it (take 1 step)
        if(n == 1) return 1;

        // If there are 2 stairs, there are 2 ways to climb:
        // Way 1: Take 1 step + 1 step
        // Way 2: Take 2 steps at once
        if(n == 2) return 2;

        // Create DP array to store the number of ways to reach each stair
        // Size is (n+1) to include index 0 through n
        int[] stairs = new int[n+1];

        // Initialize base cases in the DP array
        stairs[0] = 0;  // 0 stairs = 0 ways (starting position)
        stairs[1] = 1;  // 1 stair = 1 way (take 1 step)
        stairs[2] = 2;  // 2 stairs = 2 ways (1+1 or 2)

        // Fill the DP array using bottom-up dynamic programming
        // Start from stair 3 and calculate up to stair n
        for(int i = 3; i <= n; i++) {
            // Key insight: To reach stair i, you can either:
            // 1. Come from stair (i-1) and take 1 step, OR
            // 2. Come from stair (i-2) and take 2 steps
            // Total ways = ways to reach (i-1) + ways to reach (i-2)
            stairs[i] = stairs[i-1] + stairs[i-2];

            // Example: For stair 4
            // stairs[4] = stairs[3] + stairs[2]
            // stairs[4] = 3 + 2 = 5
            // This follows the Fibonacci sequence pattern!
        }

        // Return the number of ways to reach the nth stair
        return stairs[n];
    }

}
