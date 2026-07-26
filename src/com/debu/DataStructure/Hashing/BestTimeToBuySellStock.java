package com.debu.DataStructure.Hashing;

//Clarifying requirements
//only +ve integers?
//Cant sell on the same day as buy?

//Plan
//I will implement this with a running price

//Time Complexity: O(N)
//Space Complexity: O(1)

public class BestTimeToBuySellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minSoFar < 0) {
                minSoFar = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
        }
        return maxProfit;
    }
}
