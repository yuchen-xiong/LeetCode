package com.leetcode.bear;
import java.util.*;

public class MinimumDominoRotationsForEqualRow {
	public int minDominoRotations(int[] A, int[] B) {
        int AB = getMinRotation(A, B);
        int BA = getMinRotation(B, A);
        
        if(AB == -1 && BA == -1)
        {
            return -1;
        }
        
        if(AB != -1 && BA != -1)
        {
            return Math.min(AB, BA);
        }
        
        if(AB == -1)
        {
            return BA;
        }
        
        return AB;
    }
    
    private int getMinRotation(int[] A, int[] B)
    {
        int min = Integer.MAX_VALUE;
       
        //dice is from 1 - 6, try all 1, 2, 3...till 6
        for(int i = 1; i <= 6; i++)
        {
            int cnt = 0;
            int j = 0;
            for(; j < A.length; j++)
            {
                if(A[j] == i)
                {
                    continue;
                }
                else if(B[j] == i)  //if A doesn't have this dice, see if B has or not
                {
                    cnt++; //swap
                }
                else //couldn't get current dice i from A and B 
                {
                    break;
                }
            }
            
            if(j == A.length && cnt < min)
            {
                min = cnt;
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
