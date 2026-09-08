package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Clarifying Questions
//Can the input array be empty?
//Input array can contain only lowercase english letters?

//Approach
//For each string, I'll build a 26-element character-frequency vector. All anagrams have exactly the same frequency vector,
//so I'll serialize that vector into a canonical key and use it to group strings in a hash map.

//Time Complexity: O(M*N)
//Space Complexity: O(M*N)

//Group Anagrams
//https://leetcode.com/problems/group-anagrams/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0)return result;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
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
