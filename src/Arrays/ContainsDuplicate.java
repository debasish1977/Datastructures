package Arrays;

//Clarifying questions
//The input array can contain both +ve & -ve integers?
//The input array can be empty?

//Approach
//I'll use a HashSet to keep track of elements I've already seen. For each number, I'll check whether it already exists in the set.
//If it does, I've found a duplicate and can return true immediately.
//Otherwise, I'll add it to the set and continue. If I process the entire array without finding a duplicate, I'll return false

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        if(nums==null || nums.length==0)return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
