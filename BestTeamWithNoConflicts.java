package com.leetcode.bear;
import java.util.*;

public class BestTeamWithNoConflicts {
	public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] team = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }
        
        //sort by age first, then score
        Arrays.sort(team, new Comparator<int[]>(){
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
        
        //f[x] = x + all qualified scores with age < x
        int[] f = new int[n];
        f[0] = team[0][1];
        
        for(int i = 0; i < n; i++)
        {
            int max = team[i][1]; //form a team with its score itself
            for(int j = 0; j < i; j++)
            {
                if(team[j][1] <= team[i][1])
                {
                    max = Math.max(max, f[j] + team[i][1]);
                }
            }
            
            f[i] = max;
        }
        
        int result = 0; //f[i] are the highest score combination with current i player
        for(int i = 0; i < n; i++)
        {
            result = Math.max(result, f[i]);
        }
        
        return result;
    }
}
