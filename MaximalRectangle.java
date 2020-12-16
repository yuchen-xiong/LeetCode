package com.leetcode.bear;
import java.util.*;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        int[][] heights = new int[m][n + 1];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '0')
                {
                    heights[i][j] = 0;
                }
                else
                {
                    heights[i][j] = (i == 0) ? 1 : heights[i - 1][j] + 1;
                }
            }
        }
        
        //Example 1 heights
        //1 1 1 1 1
        //2 0 2 1 1
        //3 1 3 2 2
        //4 0 0 3 0
        
        int max = 0;
        for(int i = 0; i < n; i++)
        {
            int area = getMaxArea(heights[i]);
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    private int getMaxArea(int[] height)
    {
        int max = 0;
        
        Stack<Integer> stack = new Stack<>();
        int len = height.length;
        
        for(int i = 0; i <= len; i++)
        {
            int ch = (i == len) ? -1 : height[i]; //-1 pop last element
            while(!stack.isEmpty() && ch <= height[stack.peek()]) //increasing stack (minHeight is the limit)
            {
                int h = height[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;  
                int right = i - 1;
                max = Math.max(max, h * (right - left + 1));
            }
            
            stack.push(i);
        }
        
        return max;
    }
}
