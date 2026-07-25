package com.debu.DataStructure.TwoSum.Examples;

public class Solution {
    public double myPow(double x,int n)
    {
        if(n==0) return 1;
        long power = (long)n;
        double result = 1.0;
        for(int i=0;i<n;i++)
        {
            result*=x;
        }
        if(power < 1)
        {
            result = 1/result;
        }
        return result;
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        double result = solution.myPow(2.0000,10);
        System.out.println(result);
    }
}
