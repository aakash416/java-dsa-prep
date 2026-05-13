/*
121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */

import java.util.*;

public class BestTimeToBuyAndSellStockSolved {
    //  Brute force approach
    //  Time complexity   : O(N^2)
    //  Space complexity  : O(1)
    public int maxProfitBruteForceApproach(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] < prices[j]) {
                    ans = Math.max(ans, prices[j] - prices[i]);
                }
            }
        }
        return ans;
    }
    // Optimal Approach
    // Time complexity  : O(N)
    // Space complexity : O(1)

    public int maxProfit(int[] prices) { // [7,1,5,3,6,4]
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length :");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter array elemnts :");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        BestTimeToBuyAndSellStockSolved obj = new BestTimeToBuyAndSellStockSolved();
        int ans = obj.maxProfit(prices);
        System.out.println("Maximum profit is : " + ans);
        sc.close();
    }
}


/*
Interview Explanation

We maintain the minimum stock price seen so far while traversing the array.
At each index:
- we calculate the profit if we sell today
- update maximum profit accordingly

This allows solving the problem in a single traversal.
 */