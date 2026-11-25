package COMPANY_WISE_PROBLEMS.WALMART.ARRAYS;
//Clarifying questions
//The string contains only lowercase letters or can contain uniucode characters too?
//Can the string be null or empty?
//Should I return the index rather then the character itself?

//Approach
//Since the input contains only 26 characters, hence I will create a frequency array
//I will perform two traversals
//Count the frequency of every character
//If the count is equal to 1 return that index else -1

//Brute force -- O(N2)
//Auxillary Space - O(1)

//Time Complexity: O(N)
//Space Complexity: O(1)

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0)return -1;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
