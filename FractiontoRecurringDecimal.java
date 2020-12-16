package com.leetcode.bear;
import java.util.*;
public class FractiontoRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0)
        {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
        {
            sb.append("-");    
        }
        
        long lNumerator = Math.abs((long)numerator);
        long lDenominator = Math.abs((long)denominator);
        
        long num = lNumerator / lDenominator;
        sb.append(num);
        num = lNumerator % lDenominator;
        if(num == 0)
        {
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> idxMap = new HashMap<>();
        idxMap.put(num, sb.length());
        
        while(num != 0)
        {
            num *= 10;
            sb.append(num / lDenominator);
            num = num % lDenominator;
            if(idxMap.containsKey(num))
            {
                int idx = idxMap.get(num);
                sb.insert(idx, "(");
                sb.append(")");
                break;
            }
            else
            {
                idxMap.put(num, sb.length());
            }
        }
        
        return sb.toString();
    }
}
