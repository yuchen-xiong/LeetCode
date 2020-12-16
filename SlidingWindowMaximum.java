package com.leetcode.bear;
import java.util.*;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k)
        {
            return new int[0];
        }
        Deque<Integer> increQueue = new ArrayDeque<Integer>();
        for(int i = 0; i < k - 1; i++)
        {
           inQueue(nums, increQueue, i);
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;
        for(int i =  k - 1; i < n; i++)
        {
            inQueue(nums, increQueue, i);
            result[idx++] = nums[increQueue.peekFirst()];
            deQueue(increQueue, i - k + 1);
        }
        return result;
    }
    
    private void deQueue(Deque<Integer> increQueue, int i)
    {
        if(increQueue.peekFirst() == i)
        {
        	increQueue.pollFirst();
        }
    }
    
    private void inQueue(int[] nums, Deque<Integer> increQueue, int i)
    {
         while(!increQueue.isEmpty() && nums[increQueue.peekLast()] <= nums[i])
        {
            increQueue.pollLast();
        }
        increQueue.offer(i);
    }
}
