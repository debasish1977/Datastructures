//Clarifying questions
//Can the input array be empty?
//The input array will contain both +ve & -ve integers?
//Should I return the indices or values?
//Is exactly one valid solution guranteed?
//Can I use the same element twice?
//What should I return if no solution exists?

//Approach
//A brute force solution would examine every pair which is O(n2)
//We can reduce this to O(n) by storing previous seen numbers and their
//indices into HashMap. For each nums[i], I calculate target - nums[i]
//If that complement has already be seen, I have found the pair
//Otherwise I store the current value and index

//Space Complexity: O(N)
//Time Complexity: O(N)

package Hashing;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[0];
        int complement = 0;
        HashMap<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            complement = target - nums[i];
            if(freqMap.containsKey(complement)){
                return new int[] {freqMap.get(complement),i};
            }
            freqMap.put(nums[i],i);
        }
        return new int[0];
    }
}
