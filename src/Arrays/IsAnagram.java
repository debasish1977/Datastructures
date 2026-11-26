package Arrays;
//Clarifying questions
//Do both strings contain only lowercase english letters[a-z] or arbitrary unicode
//Can either input string be null or empty?
//Is the comparison case sensitive?
//What are the maximum length of the two strings?

//Approach
//I will convert the two strings into character array
//Then I will sort the two character arrays
//Then I will compare if the two character arrays match
//If they matches I will return true else return false

//Time Complexity: O(NlogN)
//Space Complexity: O(NlogN)

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null){
            return s==t;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] frequency = new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }
        for(int count:frequency){
            if(count!=0){
                return false;
            }

        }
        return true;
    }
}
