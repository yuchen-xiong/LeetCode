package com.leetcode.bear;

public class NumbersAtMostNGivenDigitSet {
	public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = digits.length;
        
        int result = 0;
        for(int i = 1; i < s.length(); i++) //less than s.length() digits
        {
            result += Math.pow(len, i); //n * n * ...n (cnt of i) combinations
        }
        
        for(int i = 0; i < s.length(); i++) //equal to s.length() digits
        {
            boolean same = false;
            for(int j = 0; j < len; j++)
            {
                if(digits[j].charAt(0) < s.charAt(i))
                {
                    result += Math.pow(len, s.length() - i - 1); //any digit after i will be n ^ i combinations
                }
                
                if(digits[j].charAt(0) == s.charAt(i))
                {
                    same = true;
                    if(i == s.length() - 1) //equals, one solution
                    {
                        result += 1;
                    }
                }
            }
            
            if(!same) //same equals true, check next before i digit
            {
                return result;
            }
        }
        
        return result;
    }
}
