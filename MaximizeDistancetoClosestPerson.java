package com.leetcode.bear;

public class MaximizeDistancetoClosestPerson {
	public int maxDistToClosest(int[] seats) {
		if(seats.length == 0)
        {
            return 0;
        }
        
        int i = 0, j = 0, max = 0, n = seats.length;
        
        for(; j < n; j++)
        {
            if(seats[j] == 1)
            {
                if(i == 0)
                {
                    max = j; //left 0s
                }
                else
                {
                    max = Math.max(max, (j - i + 1) / 2); //middle 0s, split in half, to left and to right
                }
                i = j + 1; //move i to next since seats[j] == 1 here decides current range
            }
        }
        
        max = Math.max(max, n - i); //right 0s
        return max;
        
//		my previous solution        
//		int n = seats.length;
//        int max = 0;
//        
//        int[] left = new int[n];
//        int[] right = new int[n];
//        
//        for(int i = 0;  i < n; i++)
//        {
//            if(i == 0)
//            {
//                left[i] = seats[i] == 0 ? 1 : 0;  
//            }
//            else
//            {
//                left[i] = seats[i] == 1 ? 0 : left[i - 1] + 1;
//            }
//        }
//        
//        for(int i = n - 1; i >= 0; i--)
//        {
//            if(i == n - 1)
//            {
//                right[i] = seats[i] == 0 ? 1 : 0;
//            }
//            else
//            {
//                right[i] = seats[i] == 1 ? 0 : right[i + 1] + 1;
//            }
//        }
        
        
//        //handle leftmost and rightmost differently
//        max = Math.max(max, Math.max(left[0], right[0]));
//        max = Math.max(max, Math.max(left[n - 1], right[n - 1]));
//        
//        for(int i = 1; i < n - 1; i++)
//        {
//            max = Math.max(max, Math.min(left[i], right[i]));
//        }
//        
//        return max;
    }
}
