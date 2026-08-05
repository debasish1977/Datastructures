//Clarifying questions
// Can the input contain null strings or empty strings?
// Are all characters lowercase English letters from 'a' to 'z'?
// Can the input contain duplicate strings?
// Can the groups and strings within each group be returned in any order?
// What should I return for a null or empty input?

//Approach
//I’ll assume every string contains only lowercase English letters, duplicate strings are allowed, and the output order does not
//matter.

//Time Complexity: O(n*k)
//Space Complexity: O(n*k)
package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0) return result;
        HashMap<String,List<String>> freqMap = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];
            for(char ch:str.toCharArray()){
                freq[ch-'a']++;
            }
            StringBuilder strBuild = new StringBuilder();
            for(int i=0;i<26;i++){
                strBuild.append('#');
                strBuild.append(freq[i]);
            }
            String key = strBuild.toString();
            if(!freqMap.containsKey(key)){
                freqMap.put(key,new ArrayList<>());
            }
            freqMap.get(key).add(str);
        }
        return new ArrayList<>(freqMap.values());
    }
}
