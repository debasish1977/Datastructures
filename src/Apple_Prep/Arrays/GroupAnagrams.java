package Apple_Prep.Arrays;

//Clarifying questions
//Are all strings lowercase english letters?
//Can the input contain empty strings or duplicate strings?
//Does the output ordering matter?
//The input array can be empty?

//Approach
//I will solve this using HashMap & by calculating the frequency array
//First I will iterate through the input array and put every element in the Map as Key & value
//Then I will iterate through the input array and put the characters into the frequency array
//I will iterate through the input array and build the keys
//I will then check if the key exists in the map, if not I will populate the HashMap

//Time Complexity: O(n*k)
//Space Complexity: O(n*k)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs==null || strs.length==0)return result;
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                freq[ch-'a']++;
            }
            String key = Arrays.toString(freq);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
