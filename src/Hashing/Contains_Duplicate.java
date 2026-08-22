package Hashing;

//Clarifying questions
//Array can both +ve & -ve integers?
//Can the array be empty?

//Approach
//I'll maintain a HashSet containing the values I've already seen. As I iterate through the array, if the current value is already in the set, I've found a duplicate and can immediately return true. Otherwise, I'll add it to the set. This gives O(N) expected time and O(N) space.

//Time complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class Contains_Duplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return false;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
