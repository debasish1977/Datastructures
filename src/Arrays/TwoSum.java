package Arrays;
//Clarifying Questions
//The input array can contain both +ve & -ve integers?
//The input array can be empty?
//Return exactly one pair of indices?
//Can I assume only one valid solution exists?
//Should I return exactly one pair of indices?

//Approach
//I'll use a HashMap to store previously visited numbers and their indices. For each number,
//I'll calculate the complement required to reach the target. If that complement already exists in the map, I've found two distinct //indices whose values sum to the target. Otherwise, I'll store the current number and continue.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        int complement = 0;
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
