package Sliding_Window;

import java.util.HashSet;

//Clarifying questions
//Array contains both +ve & -ve integers?
//Return the length of longest consecutive element sequence?
//input array can be empty?

//Approach
//I will solve this using Hashset
//I will first put all the elements in the set
//Then I will iterate through the set and try to find if the previous element is there in the set
//If not, I will increase the length

//Time Complexity: O(N)
//Space Complexity: O(N)

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer> numbers = new HashSet<Integer>();
        int maxLen = 0;
        for(int num:nums){
            numbers.add(num);
        }
        for(int num:numbers){
            if(!numbers.contains(num-1)){
                int currentNumber = num;
                int currentLength = 1;
                while(numbers.contains(currentNumber+1)){
                    currentNumber++;
                    currentLength++;
                }
                maxLen = Math.max(maxLen,currentLength);
            }

        }
        return maxLen;
}
