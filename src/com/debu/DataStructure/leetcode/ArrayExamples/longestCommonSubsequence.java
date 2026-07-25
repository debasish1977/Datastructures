package com.debu.DataStructure.leetcode.ArrayExamples;

public class longestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1==null && text2 == null)
            return 0;
        int count = 0;
        int n = text1.length();
        int m = text2.length();
        if(n > m)
        {
            for(int i=0;i <text2.length();i++)
            {
                char ch = text2.charAt(i);
                if(text1.indexOf(ch) != -1)
                {
                    count++;
                }
            }
        }
        else
        {
            for(int i=0;i <text1.length();i++)
            {
                char ch = text1.charAt(i);
                if(text2.indexOf(ch) != -1)
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        String text1 = "ezupkr";
        String text2 = "ubmrapg";
        System.out.println("Longest Common Subsequence: " + longestCommonSubsequence(text1,text2));
    }
}
