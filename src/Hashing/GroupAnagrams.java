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
//The input array consists of only lowercase english letters?
//Return the answer in any order?

//Approach
//I will solve this using HashMap and frequency Array
//I will iterate throguh the input string and calculate and store the index of characters into the frequency array


//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
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
                freq[str.charAt(i) -'a']++;
            }
            StringBuilder strBuild = new StringBuilder();
            for(int i=0;i<freq.length;i++){
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
