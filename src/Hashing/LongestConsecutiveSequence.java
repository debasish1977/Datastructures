package Hashing;

//Clarifying Questions
//The input array contains both +ve & -ve integers?
//The input array can be empty?

//Approach
/* I'll first insert every number into a HashSet so I can perform expected O(1) membership checks.
Then I'll iterate through the unique numbers. I only start counting a sequence when num - 1 is not present,
which means num is the beginning of a consecutive sequence. From there, I'll repeatedly check num + 1, num + 2,
and so on. Since each sequence is expanded exactly once, the total expected runtime is O(N), with O(N) additional space. */

//Time complexity: O(N)
//Space complexity: O(N)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        HashSet<Integer> elementSet = new HashSet<>();
        int maxLen = 0;
        for(int num:nums){
            elementSet.add(num);
        }
        for(int element:elementSet){
            if(elementSet.contains(element)){
                int num = element;
                int length = 1;
                while(elementSet.contains(num+1)){
                    length++;
                    num++;
                }
                maxLen = Math.max(maxLen,length);
            }

        }
        return maxLen;
    }
}
