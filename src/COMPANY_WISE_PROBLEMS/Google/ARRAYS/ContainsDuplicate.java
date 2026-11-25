package COMPANY_WISE_PROBLEMS.Google.ARRAYS;
//Clarifying Questions
//The input array can be empty?
//The input array can contain negative and zero?

//Approach
//A brute-force solution would compare every pair of elements, requiring O(n²) time and O(1) auxiliary space.
//Alternatively, we could sort the array and check adjacent elements, requiring O(n log n) time.
//Since we only need to determine whether a duplicate exists, I will use a HashSet to store previously encountered elements.
//While traversing the array, if an element already exists in the set, I can immediately return true. Otherwise, I insert it into the set.
//If we complete the traversal without finding a duplicate, I return false.
//This provides expected O(n) time complexity and O(n) auxiliary space without modifying the input array.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0)return false;
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
