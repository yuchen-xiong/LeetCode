package com.leetcode.bear;

import java.util.*;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        getPermutation(nums, n, list, lists, used);
        return lists;
    }
    
    private void getPermutation(int[] nums, int n, List<Integer> list, List<List<Integer>> lists, boolean[] used)
    {
        if(list.size() == n)
        {
            lists.add(new ArrayList<Integer>(list)); 
            return;
        }
      
        for(int i = 0; i < n; i++)
        {
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
            {
                continue;
            }
            
            if(!used[i])
            {   
                list.add(nums[i]);
                used[i] = true;
                getPermutation(nums, n, list, lists, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
           
        }
    }
}
