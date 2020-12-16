package com.leetcode.bear;

import java.util.*;

import com.lintcode.bear.Pouringcola;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int k = 2;
//		int[] prices = {3,2,6,5,0,3};
//		BestTimeToBuyAndSellStockIV stockTime = new BestTimeToBuyAndSellStockIV();
//		int profit = stockTime.maxProfit(k, prices);
//		System.out.println("Max Profit: " + profit);
		
//		ChampagneTower test = new ChampagneTower();
//		double result = test.champagneTower(1, 1, 1);
//		System.out.println("Result: " + result);
//		Pouringcola test = new Pouringcola();
//		int result = test.getMinTimes(4, 1, 3);
//		System.out.println("Result: " + result);
		MaximizeDistancetoClosestPerson test = new MaximizeDistancetoClosestPerson();
		int[] seats = {0, 1};
		test.maxDistToClosest(seats);
	}

}
