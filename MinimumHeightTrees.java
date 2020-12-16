package com.leetcode.bear;

import java.util.*;

public class MinimumHeightTrees {
	class Solution {
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//
//	        if(n == 0)
//	        {
//	            return new ArrayList<>();
//	        }
//	        
//	        if(n == 1)
//	        {
//	            List<Integer> roots = new ArrayList<>();
//	            roots.add(0);
//	            roots.add(1);
//	            return roots;
//	        }
//	        
//	        List<Integer>[] nodes = new ArrayList[n];
//	        for(int i = 0; i < n; i++)
//	        {
//	            nodes[i] = new ArrayList<>();
//	        }
//	        
//	        for(int i = 0; i < edges.length; i++)
//	        {
//	            int n1 = edges[i][0];
//	            int n2 = edges[i][1];
//	            nodes[n1].add(n2);
//	            nodes[n2].add(n1);
//	        }
//	        
//	        List<Integer> leaves = new ArrayList<>();
//	        for(int i = 0; i < n; i++)
//	        {
//	            if(nodes[i].size() == 1)
//	            {
//	                leaves.add(i);
//	            }
//	        }
//	        
//	        int count = n;
//	        while(count > 2)
//	        {
//	            int size = leaves.size();
//	            count -= size;
//	            List<Integer> newLeaves = new ArrayList<>();
//	            for(int i = 0; i < size; i++)
//	            {
//	                int leaf = leaves.get(i);
//	                for(int j = 0; j < nodes[leaf].size(); j++)
//	                {
//	                    int root = nodes[leaf].get(j);
//	                    nodes[root].remove(leaf);
//	                    if(nodes[root].size() == 1)
//	                    {
//	                        newLeaves.add(root);
//	                    }
//	                }
//	            }
//	            leaves = newLeaves;
//	        }
//	        
//	        return leaves;
//	    }
		
		//Solution2
        // Write your code here
        if(n == 0)
        {
            return new ArrayList<Integer>();
        }
        
        if(n == 1)
        {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++)
        {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            edgeMap.putIfAbsent(v1, new ArrayList<Integer>());
            edgeMap.get(v1).add(v2);
            degreeMap.put(v1, degreeMap.getOrDefault(v1, 0) + 1);
            edgeMap.putIfAbsent(v2, new ArrayList<Integer>());
            edgeMap.get(v2).add(v1);
            degreeMap.put(v2, degreeMap.getOrDefault(v2, 0) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int key : edgeMap.keySet())
        {
            if(edgeMap.get(key).size() == 1)
            {
                queue.offer(key);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
        {
            result = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int cur = queue.poll();
                result.add(cur);
                for(int next : edgeMap.get(cur))
                {
                    int degree = degreeMap.get(next);
                    degree--;
                    degreeMap.put(next, degree);
                    if(degree == 1)
                    {
                        queue.offer(next);
                    }
                }
            }
        }
        
        return result; 
	    }
	}
}
