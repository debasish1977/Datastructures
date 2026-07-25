package com.debu.DataStructure.Sliding.Window.Example;

import java.util.HashMap;

public class LengthOfLongestSubArray {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
        {
            throw new IllegalArgumentException("Input cant be null or empty");
        }

        int fp = 0;
        int sp = 0;
        int sum = 0;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int ans = 0;

        while(sp < n)
        {
            char ch = s.charAt(sp);
            addToMap(map,ch);
            while(fp < sp && !isValid(map))
            {
                deleteFromMap(map,s.charAt(fp));
                fp++;
            }
            ans = sp -fp + 1;
            sp++;
        }
        return ans;

    }

    public void addToMap(HashMap<Character,Integer> map, char ch)
    {
        map.put(ch,map.getOrDefault(ch,0)+1);
    }

    public void deleteFromMap(HashMap<Character,Integer> map,char ch)
    {
        map.put(ch,map.get(ch)-1);
    }

    public boolean isValid(HashMap<Character,Integer> map)
    {
        for(char ch: map.keySet())
        {
            if(map.get(ch) > 1)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        LengthOfLongestSubArray lengthOfLongestSubArray = new LengthOfLongestSubArray();
        int output = lengthOfLongestSubArray.lengthOfLongestSubstring("abcabcbb");
        System.out.println(output);
    }
}
