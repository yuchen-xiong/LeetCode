package com.leetcode.bear;

public class BagofTokens {
	int max = 0;
    public int bagOfTokensScore(int[] tokens, int P) {
        //solution:
        //1.within the limit, try all the scenarios 
        //2.find the max score
        //end condition:
        //1.all tokens are used
        //2.cannot gain score  power < all unused token
        //3. cannot gain power  score < 1
        int n = tokens.length;
        boolean[] used = new boolean[n];
        getMaxScore(tokens, P, used, 0);
        return max;
    }
    
    private void getMaxScore(int[] tokens, int P, boolean[] used, int score)
    {
        //exit condition
        
        max = Math.max(max, score);
        
        for(int i = 0; i < tokens.length; i++)
        {
            if(!used[i])
            {
                //gain score
                if(tokens[i] <= P)
                {
                    used[i] = true;
                    score += 1;
                    P -= tokens[i];
                    getMaxScore(tokens, P, used, score);
                    used[i] = false;
                    score -= 1;
                    P += tokens[i];
                }
    
                //gain power
                if(score > 0)
                {
                    used[i] = true;
                    score -= 1;
                    P += tokens[i];
                    getMaxScore(tokens, P, used, score);
                    used[i] = false;
                    score += 1;
                    P -= tokens[i];
                }
            }
        }
    }
}
