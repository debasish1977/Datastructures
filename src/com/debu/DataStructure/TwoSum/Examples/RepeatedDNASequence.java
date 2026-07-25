package com.debu.DataStructure.TwoSum.Examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public List<String> findRepeatedDNASequence(String str)
    {
        int L = 10;
        if(str==null || str.length() < L)
        {
            throw new IllegalArgumentException("String cant be null or empty");
        }

        Map<String,Integer> count = new HashMap<String,Integer>();
        for(int i=0;i<str.length()-L;i++)
        {
            String sub = str.substring(i,i+L);
            count.put(sub,count.getOrDefault(sub,0)+1);
        }
        List<String> subStringList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: count.entrySet())
        {
            if(entry.getValue() > 2)
            {
                subStringList.add(entry.getKey());
            }
        }
        return subStringList;
    }

    public static void main(String[] args)
    {
        RepeatedDNASequence sequence = new RepeatedDNASequence();
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> subStringList = sequence.findRepeatedDNASequence(str);
        for(String str1:subStringList)
        {
            System.out.println("String-->"+str1);
        }

    }
}
