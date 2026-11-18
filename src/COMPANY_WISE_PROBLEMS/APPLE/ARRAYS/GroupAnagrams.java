package COMPANY_WISE_PROBLEMS.APPLE.ARRAYS;

//Clarifying questions
//The input array can contain both +ve & -ve integers?
//The input array can be empty?

//Approach
//I will solve this using HashMap & by calculating the frequency array
//First I will iterate through the input array and put every element in the Map as Key & value
//Then I will iterate through the input array and put the characters into the frequency array
//I will iterate through the input array and build the keys
//I will then check if the key exists in the map, if not I will populate the HashMap

//Time Complexity: O(n*k)
//Space Complexity: O(n*k)
//https://leetcode.com/problems/group-anagrams/submissions/2197293629/?envType=company&envId=apple&favoriteSlug=apple-all

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> seen = new HashMap<String,List<String>>();
        if(strs==null || strs.length==0)return result;
        for(String str:strs){
            int[] freq = new int[26];
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                freq[ch-'a']++;
            }
            StringBuilder strBuild = new StringBuilder();
            for(int i=0;i<freq.length;i++){
                strBuild.append('#');
                strBuild.append(freq[i]);
            }
            String key = strBuild.toString();
            if(!seen.containsKey(key)){
                seen.put(key,new ArrayList<>());
            }
            seen.get(key).add(str);
        }
        return new ArrayList<>(seen.values());
    }
}
