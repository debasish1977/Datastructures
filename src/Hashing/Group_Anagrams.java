package Hashing;

//Clarifying Questions
//Are Strings limited to lowercase english letters?
//Can the input array or individual strings be null?
//Can Strings be empty?
//Does the order of groups or Strings within each group matter?

//Approach
//I will solve this frequency array & HashMap

//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0) return result;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];
            char[] chArray = str.toCharArray();
            for(char ch:chArray){
                freq[ch-'a']++;
            }
            StringBuilder strBuild = new StringBuilder();
            for(int i=0;i<26;i++){
                strBuild.append('#');
                strBuild.append(freq[i]);
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
