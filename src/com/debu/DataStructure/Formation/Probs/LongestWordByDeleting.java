package com.debu.DataStructure.Formation.Probs;

import com.debu.DataStructure.BinaryTree.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordByDeleting {
    public List<String> SortByLengthThenLexico(String s,List<String> words)
    {
        if(s==null || s.length()==0) { return null;}
        if(words==null || words.size()==0) { return null;}

        //Sort by descending length and then by lexicographical order
        Collections.sort(words,new Comparator<String>() {
            @Override
            public int compare(String a,String b)
            {
                if(a.length() != b.length())
                {
                    return Integer.compare(b.length(),a.length());  //Descending length
                }
                return a.compareTo(b);
            }
        });
        System.out.println(words);
        return words;
    }

    //Check if 'word' is a subsequence of 's'
    public static boolean isSubsequence(String word, String s)
    {
        int i=0;
        int j=0;
        while(i<word.length() && j<s.length())
        {
            if(word.charAt(i)==s.charAt(j))
            {
                j++;
            }
            i++;
        }
        return j==word.length();
    }

    //Find the longest string which is a subsequence of 's'
    public static String findLongestSubsequenceString(String s,List<String> words)
    {
        String result = "";
        for(String word: words)
        {
            if(isSubsequence(word,s))
            {
                if(word.length() > result.length() || word.length() == result.length() || word.compareTo(result) <0)
                {
                    result = word;
                }
            }
        }
        return result;
    }



    public static void main(String[] args)
    {
        String s = "abpcplea";
        List<String> words = Arrays.asList("ale","apple","monkey","plea");

        LongestWordByDeleting sortByLexico = new LongestWordByDeleting();
        List<String> newWords = sortByLexico.SortByLengthThenLexico(s,words);
        String result = findLongestSubsequenceString(s,newWords);
        System.out.println("Output-->"+result);
    }
}
