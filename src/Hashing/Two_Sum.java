//Clarifying questions
//Both +ve & -ve integers?
//Only one solution?
//Return the answer in any order?
//Is exactly one valid pair guranteed?
//Should I return indices or values?

//Approach
//As I scan for left to right, I store each previously seen number and its index.
//For the current number x, I check with whether target - x has already been seen.
//If it has, those two values form the required pair

//Time Complexity: O(N)
//Space Complexity: O(N)

package Hashing;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
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
