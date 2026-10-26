package Arrays;

//https://leetcode.com/problems/longest-consecutive-sequence/?envType=company&envId=apple&favoriteSlug=apple-all

//Clarifying Questions
//Input elements can be both +ve and -ve
//Input array can be empty?
//Can the array contain duplicate values?	Yes
//Can the array contain negative numbers and zero?	Yes
//Can the input array be empty or null?	Empty is valid; assume non-null
//Can integers reach Integer.MIN_VALUE or Integer.MAX_VALUE?	Yes
//Should I return the length or the actual sequence?	Only the length
//Can I use additional memory?	Yes, O(n) space is acceptable
//Can I modify the input array?	Prefer not to
//Is O(n) expected time mandatory?


//I would use a HashSet to store all unique numbers, allowing O(1) average-time lookups.
//Instead of trying to build a sequence starting from every number, I would only start counting when the previous number, num - 1, does not exist in the set.
//That tells me the current number is the beginning of a consecutive sequence.
//From there, I would keep checking num + 1, num + 2, and so on, until the sequence ends.
//I would track the maximum sequence length and return it."

//Time Complexity: O(N)
//Space Complexity: O(N)


import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int element : set) {
            if(element == Integer.MIN_VALUE || !set.contains(element-1)){
                int length = 1;
                int current = element;
                while(current != Integer.MAX_VALUE && set.contains(current+1)) {
                    length++;
                    current++;
                }
                maxLen = Math.max(length,maxLen);
            }
        }
        return maxLen;
    }

}
