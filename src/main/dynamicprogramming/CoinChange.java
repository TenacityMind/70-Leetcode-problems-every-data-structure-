package main.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    /**
     * Calculates the fewest number of coins needed to make up a given amount.
     *
     * @param coins  An array of available coin denominations.
     * @param amount The target amount of money.
     * @return The fewest number of coins needed, or -1 if the amount cannot be made.
     */
    public int coinChange(int[] coins, int amount) {

        // Create a dp array to store the minimum coins for each amount from 0 to 'amount'.
        // dp[i] will hold the minimum number of coins required to make the amount 'i'.
        int[] dp = new int[amount + 1];

        // Fill the array with a "placeholder" value that is larger than any possible answer.
        // 'amount + 1' is a good choice because the max coins you could possibly use is 'amount' (all 1s).
        // This helps us later identify which amounts were impossible to make.
        Arrays.fill(dp, amount + 1);

        // --- The Base Case ---
        // It takes 0 coins to make an amount of 0. This is our starting point.
        dp[0] = 0;

        // --- Build the Solution from the Bottom Up ---
        // Loop through every amount from 1 up to the target amount.
        for (int i = 1; i <= amount; i++) {
            // For each amount, check every available coin.
            for (int coin : coins) {
                // We only consider a coin if its value is less than or equal to the
                // current amount 'i' we are trying to make.
                //here it checks will the resulting index be valid
                if (i - coin >= 0) {
                    // This is the core of the dynamic programming solution.
                    // We update the minimum coins for amount 'i' by choosing the smaller of two options:
                    // 1. Its current value (dp[i]).
                    // 2. 1 (for the current coin) + the minimum coins needed for the remaining amount (dp[i - coin]).
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // --- Final Result ---
        // After the loops, if dp[amount] is still our placeholder value, it means
        // we were never able to form that amount. In that case, we return -1.
        // Otherwise, we return the calculated minimum number of coins.
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
