package com.leetcode.bear;
import java.util.*;

public class CheapestFlightsWithinKStops {
	class Price
	{
	    int city, stop, price;
	    
	    public Price(int c, int s, int p)
	    {
	        city = c;
	        stop = s;
	        price = p;
	    }
	}
	
	class PriceComparator implements Comparator<Price>
	{
		@Override
		public int compare(Price a, Price b)
        {
            if(a.price == b.price)
            {
                return a.stop - b.stop;
            }
            return a.price - b.price;
        }
	}

	class Solution {
	    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        if(src == dst)
	        {
	            return 0;
	        }
	        
	        Map<Integer, List<int[]>> graph = new HashMap<>();
	        for(int i = 0; i < flights.length; i++)
	        {
	            int from = flights[i][0], to = flights[i][1], price = flights[i][2];
	            graph.putIfAbsent(from, new ArrayList<>());
	            graph.get(from).add(new int[]{to, price});
	        }
	        
	        int min = Integer.MAX_VALUE;
	        PriorityQueue<Price> minHeap = new PriorityQueue<>(n, new PriceComparator());
	        minHeap.offer(new Price(src, K, 0));
	        
	        while(!minHeap.isEmpty())
	        {
	            Price cur = minHeap.poll();
	            if(cur.city == dst)
	            {
	                return cur.price;
	            }
	            
	            if(!graph.containsKey(cur.city) || cur.stop < 0)
	            {
	                continue;
	            }
	            
	            for(int[] next : graph.get(cur.city))
	            {
	                minHeap.offer(new Price(next[0], K - 1, cur.price + next[1]));
	            }
	        }
	        
	        return -1;
	    }
	}
}
