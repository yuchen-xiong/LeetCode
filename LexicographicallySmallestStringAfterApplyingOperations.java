package com.leetcode.bear;
import java.util.*;

public class LexicographicallySmallestStringAfterApplyingOperations {
	public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        String smallest = s;
        queue.offer(s);
        Set<String> set = new HashSet<>();
        set.add(s);
        
        while(!queue.isEmpty())
        {
            String cur = queue.poll();
            if(smallest.compareTo(cur) > 0)
            {
                smallest = cur;
            }
            
            //add operations
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < cur.length(); i++)
            {
                if(i % 2 == 1)
                {
                    int num = (cur.charAt(i) - '0' + a) % 10;
                    sb.append(num);
                }
                else
                {
                    sb.append(cur.charAt(i));
                }
            }
            
            String addStr = sb.toString();
            if(!set.contains(addStr))
            {
                set.add(addStr);
                queue.offer(addStr);
            }
            
            String rotateStr = cur.substring(cur.length() - b, cur.length()) + cur.substring(0, cur.length() - b);
            if(!set.contains(rotateStr))
            {
                set.add(rotateStr);
                queue.offer(rotateStr);
            }
        }
        
        return smallest;
    }
}
