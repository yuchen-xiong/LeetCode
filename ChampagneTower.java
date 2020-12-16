package com.leetcode.bear;

public class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
//        double[] res = new double[10];
//        res[0] = poured;
//        for (int row = 1; row <= query_row; row++) {
//            for (int i = row; i >= 0; i--) {
//                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
//            }
//            for(double item : res)
//            {
//            	System.out.print(item + ",");
//            }
//            
////            System.out.println();
//        }
//       
//        
//        
//        return Math.min(res[query_glass], 1.0);
		
		//Solution 2
		 double[][] arrs = new double[query_row + 1][101];
		    
	        arrs[0][0] = poured;
	        
	        for(int i = 0; i < query_row; i++)
	        {
	            for(int j = 0; j < arrs[i].length; j++)
	            {
	                if(arrs[i][j] > 1)
	                {
	                    arrs[i + 1][j] += Math.max(0, (arrs[i][j] - 1) / 2.0);
	                    arrs[i + 1][j + 1] += (arrs[i][j] - 1) / 2.0;
	                }
	            }
	        }
	        
	        return Math.min(1, arrs[query_row][query_glass]);

    }
}
