package main.arrays.twopointers;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int left =0;// 'left' pointer for the buy day
        int right =1;// 'right' pointer for the sell day

        while(right < prices.length) {
            // Check if we've found a profitable transaction
            if(prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            }
            else {
                // Found a new minimum price, move the buy day pointer up
                left = right;
            }
            // Move the sell day pointer to the next day
            right++;

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
