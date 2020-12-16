package com.leetcode.bear;
import java.util.*;

public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0 || k <= 0)
        {
            return 0;
        }
        
        int n = prices.length;
        //make as many as transactions possible, greedy
        if(k >= n / 2)
        {
            int profit = 0;
            for(int i = 1; i < n; i++)
            {
                int diff = prices[i] - prices[i - 1];
                if(diff > 0)
                {
                    profit += diff;
                }
            }
            return profit;
        }
        
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];
        Arrays.fill(sell, 0);
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < k; j++)
            {
                if(j == 0)
                {
                    //in terms of profits, buy is negative, the first transaction in termns of profits is -prices[i]
                    buy[j] = Math.max(buy[j], -prices[i]);
                }
                else
                {
                    //previous sell - cur buy
                    buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                }
                
                //in terms of profits, sell is positive
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                
            }
        }
        
       return sell[k - 1];
    }
}
