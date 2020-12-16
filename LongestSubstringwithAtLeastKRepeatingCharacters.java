package com.leetcode.bear;
import java.util.*;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
        int[] cntMap = new int[26];
        int maxUnq = getMaxUnique(s);
        int longest = 0;
        int n = s.length();
        for(int curUnq = 1; curUnq <= maxUnq; curUnq++)
        {
            Arrays.fill(cntMap, 0);
            int left = 0, right = 0, idx = 0, unq = 0, countAtLeastK = 0;
            
            while(right < n)
            {
                if(unq <= curUnq)
                {
                    idx = s.charAt(right) - 'a';
                    if(cntMap[idx] == 0)
                    {
                        unq++;
                    }
                    cntMap[idx]++;
                    if(cntMap[idx] == k)
                    {
                        countAtLeastK++;
                    }
                    right++;
                }
                else
                {
                    idx = s.charAt(left) - 'a';
                    if(cntMap[idx] == k)
                    {
                        countAtLeastK--;
                    }
                    cntMap[idx]--;
                    if(cntMap[idx] == 0)
                    {
                        unq--;
                    }
                    left++;
                }
                
                if(unq == curUnq && unq == countAtLeastK)
                {
                    longest = Math.max(longest, right - left);
                }
            }
        }
        return longest;
    }
    
    private int getMaxUnique(String s)
    {
        Set<Character> letterSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
        {
            letterSet.add(s.charAt(i));
        }
        return letterSet.size();
    }
}
