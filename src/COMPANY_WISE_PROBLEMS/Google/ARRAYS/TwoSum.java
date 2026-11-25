package COMPANY_WISE_PROBLEMS.Google.ARRAYS;
//Clarifying Questions
//Can the array contain negative numbers and zeros?
//Is the input guranteed to be non null and contains atleast two elements?
//Are we guranteed exactly one valid solution?
//Must the two indices be distinct?
//Can the array contain duplicate values?
//What are the constraints on input values and targets?

//Approach
//A brute-force approach would examine every pair, resulting in O(n²) time complexity.
//We can optimize this using a HashMap that stores previously encountered values and their indices.
//For each element, I calculate the complement required to reach the target. If the complement exists in the map,
//I return its stored index and the current index.
//Otherwise, I insert the current element and its index into the map.
//By checking the complement before inserting the current element, I guarantee that the same array element is never used twice.
//This requires a single traversal with expected O(n) time and O(n) auxiliary space.

//Time Complexity: O(N)
//Space Complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length < 2)return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
