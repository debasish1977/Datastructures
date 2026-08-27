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

//Clarifying questions
//The input string contains lowercase english letters?
//Return the answer in any order?
//Can I assume every string contains only lowercase letters a-z?
//Can I return the groups and the strings within each group in order?

//Approach
//Two strings are anagrams if and only if every character occurs the same number of times in both strings. Since the alphabet
//is limited to 26 lowercase English letters, I'll build a 26-element frequency array for each string and serialize that
//array into a canonical key. I'll then use a HashMap from that key to the list of strings sharing the same frequency distribution.

//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0)return new ArrayList<>();
        HashMap<String,List<String>> groups = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String Key = new String(chars);
            if(!groups.containsKey(Key)){
                groups.put(Key,new ArrayList<>());
            }
            groups.get(Key).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
