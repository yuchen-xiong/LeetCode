package com.leetcode.bear;
import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        int[] pre = null;
        for(int[] item : intervals)
        {
            if(pre == null || item[0] > pre[1]) //cur start > pre end
            {
                result.add(item);
                pre = item; //pre = item only when item has no overlap with pre
            }
            else
            {
//                int[] last = result.get(result.size() - 1);
//                last[1] = Math.max(last[1], item[1]);
            	pre[1] = Math.max(pre[1], item[1]);
            }
        }
        
        int[][] arr = new int[result.size()][];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}
