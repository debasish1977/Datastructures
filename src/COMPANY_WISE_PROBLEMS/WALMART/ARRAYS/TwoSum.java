package COMPANY_WISE_PROBLEMS.WALMART.ARRAYS;
//Clarifying Questions
//Can the input array be null or empty?
//Can the array contain positive integers, negative numbers, zero and duplicates?
//Are we guranteed exactly one valid solution?
//Must the two indices be distinct?
//The input array can contain both +ve & -ve integers?
//Each input would have exactly one solution?

//Approach
//A brute-force approach would examine every pair of elements, resulting in O(n²) time and O(1) auxiliary space.
//We can optimize this using a HashMap that stores previously visited values and their indices.
//For each element, I calculate its complement as target minus the current value. If the complement exists in the map,
//I return the previously stored index and the current index.
//Otherwise, I insert the current value and its index into the map.
//By checking the complement before inserting the current element, I ensure that we never reuse the same index.

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
