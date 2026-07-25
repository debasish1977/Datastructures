package com.debu.DataStructure.TwoSum.Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlmostPalindrom {
    public boolean almostPalindrome(String str)
    {
        if(str==null && str.length()==0)
        {
            return true;
        }
        str = str.replaceAll(" ","");
        List<String> subStringList = new ArrayList<>();
        int maxLength = 0;
        subStringList = getAllSubstrings(str);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String str1:subStringList)
        {
            if(isPalindrome(str1))
            {
                map.put(str,str.length());
            }

        }
        maxLength = getMaxLengthOfPalindromicSubstring(map);
        if(maxLength < str.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Helper method to check if the string is palindrome
    public boolean isPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;
        while(left < right)
        {
            if(str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Helper method to identify all the substrings of String str
    public static List<String> getAllSubstrings(String str)
    {
        List<String> subStringList = new ArrayList<String>();
        for(int i=0;i<str.length();i++)
        {
            for(int j=i+1;j<=str.length();j++)
            {
                subStringList.add(str.substring(i,j));
            }
        }
        return subStringList;
    }

    //Helper method to find the length of maximum palindromic substring
    public static int getMaxLengthOfPalindromicSubstring(HashMap<String,Integer> map)
    {
        int maxlength = 0;
        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            String key = entry.getKey();
            int val = entry.getValue();
            if(val > maxlength)
            {
                maxlength = val;
            }
        }
        return maxlength;
    }

    public static void main(String[] args)
    {
        String str = "aba";
        AlmostPalindrom main = new AlmostPalindrom();
        System.out.println(main.almostPalindrome(str));
    }
}
