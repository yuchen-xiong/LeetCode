package com.leetcode.bear;
import java.util.*;

public class DetermineifTwoStringsAreClose {
	public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
        {
            return false;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int n = word1.length();
        queue.offer(word1);
        
        while(!queue.isEmpty())
        {
            String cur = queue.poll();
            if(cur.equals(word2))
            {
                return true;
            }
            
            List<String> nextStrs = getNext(cur, word2);
            for(String next : nextStrs)
            {
                if(!set.contains(next))
                {
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        
        return false;
    }
    
    private List<String> getNext(String a, String b)
    {
        List<String> list = new ArrayList<>();
        int n = a.length();
        for(int i = 0; i < n; i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                for(int j = i + 1; j < n; j++)
                {
                    if(a.charAt(j) == b.charAt(i))
                    {
                        String swapStr = swap(a, i, j);
                        list.add(swapStr);
                        String transStr = trans(a, a.charAt(i), a.charAt(j));
                        list.add(transStr);
                    }
                }
            }
        }
        
        return list;
    }
    
    private String trans(String a, char c1, char c2)
    {
        char[] arr = a.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == c1)
            {
                arr[i] = c2;
            }
            else if(arr[i] == c2)
            {
                arr[i] = c1;
            }
        }
        
        return String.valueOf(arr);
    }
    
    private String swap(String a, int i, int j)
    {
        char[] arr = a.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
