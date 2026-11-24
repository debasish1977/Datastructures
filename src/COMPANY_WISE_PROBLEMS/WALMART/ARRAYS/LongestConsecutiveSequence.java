package COMPANY_WISE_PROBLEMS.WALMART.ARRAYS;

// Clarifying Questions
// Can the input array be null or empty?
// Can the array contain negative numbers and zero?
// Can the array contain duplicate elements?
// Are the elements in the array unsorted?

// Approach
// 1. Add all elements to a HashSet for O(1) expected lookup.
// 2. Iterate through each unique element in the HashSet.
// 3. If num - 1 does not exist, num is the start of a sequence.
// 4. Find the length of the sequence by checking consecutive numbers.
// 5. Update the maximum sequence length.

// Time Complexity: Expected O(N)
// Space Complexity: O(N)

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;
        for (int num : numSet) {
           if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
