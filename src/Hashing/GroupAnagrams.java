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

//Clarifying Questions
//Can the input array be empty?
//Input array can contain only lowercase english letters?

//Approach
//For each string, I'll build a 26-element character-frequency vector. All anagrams have exactly the same frequency vector,
//so I'll serialize that vector into a canonical key and use it to group strings in a hash map.

//Time Complexity: O(M*N)
//Space Complexity: O(M*N)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0)return result;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];
            for(int i=0;i<str.length();i++){
                freq[str.charAt(i)-'a']++;
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
