package Sliding_Window;

//Clarifying Questions
//Are strings limited to lowercase english letters?
//Can the input contain null strings?
//Can the array itself be null?

//Approach
//Two strings are anagrams if they have identical character frequencies.
//For each string, I create a 26 element frequency array and serialize into canonical key
//I use that key in a hashmap, where the value is the list of the strings
//with the same frequency signature
//Since every anagram produces the same key, all anagrams are grouped together

//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length ==0)return result;
        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str:strs){
            int[] arr = new int[26];
            for(char ch:str.toCharArray()){
                arr[ch-'a']++;
            }
            StringBuilder strBuild = new StringBuilder();
            for(int i=0;i<26;i++){
                strBuild.append('#');
                strBuild.append(arr[i]);
            }
            String key = strBuild.toString();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
