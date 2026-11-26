package Arrays;
//Clarifying questions
//Can the input array contain -ve integers, +ve integers & zeros?
//Can the input array be null or empty?
//I will return true if any value appears more then once?
//Are there any constraints on size or auxillary memory usage?
//Am I allowed to modify the input array?

//Approach
//I will use a HashSet to maintain the elements encountered during traversals
//For each element in the input array, I will check if the element already exists in the HashSet
//If it exists then I will return true else I will return false

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length < 2)return false;
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                return true;
            }
            seen.add(nums[i]);
        }
        return false;
    }
}
