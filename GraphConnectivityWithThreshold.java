package com.leetcode.bear;
import java.util.*;

public class GraphConnectivityWithThreshold {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        int[] f = new int[n + 1];
        for(int i = 0; i <= n; i++)
        {
            f[i] = i;
        }
        
        
        //z > threshold, i must be at least >= threshold
        for(int i = threshold; i < n; i++)
        {
            for(int j = i + 1; j <= n; j++)
            {
                if(!connected(i, j, f) && gcd(i, j, threshold))
                {
                    union(i, j, f); //get all the connections first
                }
            }
        }
        
        for(int[] query : queries)
        {
            int x = query[0];
            int y = query[1];
            
            result.add(connected(x, y, f));
        }
        return result;
    }
    
    private void union(int x, int y, int[] f)
    {
        int fx = find(x, f);
        int fy = find(y, f);
        if(fx != fy)
        {
            f[fx] = fy;
        }
    }
    
    private boolean connected(int x, int y, int[] f)
    {
        return find(x, f) == find(y, f);
    }
    
    private int find(int x, int[] f)
    {
    	//compression using if and recursion
//        if(f[x] != x)
//        {
//            f[x] = find(f[x], f);
//        }
//        return f[x];
    	 int fx;
         int temp = x;
         
         while(f[x] != x)
         {
             x = f[x];
         }
         
         while(temp != x)
         {
             fx = f[temp];
             f[temp] = x;
             temp = fx;
         }
         
         return x;
    }
    
    
    private boolean gcd(int a, int b, int th)
    {
        if(b == 0 && a > th)
        {
            return true;
        }
        
        if(b < th)
        {
            return false;
        }
        
        return gcd(b, a % b, th);
        
    }
	
}
