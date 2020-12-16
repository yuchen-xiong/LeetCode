package com.leetcode.bear;
import java.util.*;

public class SummaryRanges {
	 public List<String> summaryRanges(int[] nums) {
	        // Write your code here
	        List<String> answer = new ArrayList<>();
	        for(int i = 0; i < nums.length; i++)
	        {
	            int cur = nums[i];
	            while(i + 1 < nums.length && nums[i + 1] - nums[i] == 1)
	            {
	                i++;
	            }
	            
	            if(cur == nums[i])
	            {
	                answer.add(cur + "");
	            }
	            else
	            {
	                answer.add(cur + "->" + nums[i]);
	            }
	        }
	        return answer;
	    }
//	 public List<String> summaryRanges(int[] nums) {
//	        List<String> result = new ArrayList<>();
//	        if(nums.length == 0)
//	        {
//	            return result;
//	        }
//	        
//	        int start = nums[0];
//	        int end = nums[0];
//	        
//	        for(int i = 1; i < nums.length; i++)
//	        {
//	            int cur = nums[i];
//	            if(end + 1 == cur)
//	            {
//	                end = cur;
//	            }
//	            else
//	            {
//	                addToList(start, end, result);
//	                start = cur;
//	                end = cur;
//	                
//	            }
//	        }
//	        
//	       
//	        addToList(start, end, result);
//	        return result;
//	    }
//	    
//	    private void addToList(int start, int end, List<String> list)
//	    {
//	        if(start == end)
//	        {
//	            list.add(start + "");
//	        }
//	        else
//	        {
//	            list.add(start + "->" + end);    
//	        }
//	    }
}
