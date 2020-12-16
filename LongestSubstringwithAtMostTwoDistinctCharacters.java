package com.leetcode.bear;
import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        Map<Character, Integer> cntMap = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;
        
        for(; r < n; r++)
        {
            char rc = s.charAt(r);
            cntMap.put(rc, cntMap.getOrDefault(rc, 0) + 1);
            
            while(l < r && cntMap.size() > 2)
            {
                char lc = s.charAt(l);
                int lCnt = cntMap.get(lc);
                lCnt--;
                if(lCnt == 0)
                {
                    cntMap.remove(lc);
                }
                else
                {
                    cntMap.put(lc, lCnt);
                }
                l++;
            }
           
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
