//Clarifying questions
//The input array can contain both +ve & -ve integers?
//The input array can be empty?
//Exactly one solution

//Approach
//I will solve this using HashMap & by calculating complement
//I will iterate through the input array and calculate the complement for each element
//If the complement exists in the hashmap then I will return the index
//Else I will return blank input array

//Time Complexity: O(N)
//Space Complexity: O(N)

package Hashing;

import java.util.HashMap;

/*
Leet code link:  https://leetcode.com/problems/two-sum/?envType=company&envId=apple&favoriteSlug=apple-all
*/

//Clarifying Questions
//The input array can contain both +ve & -ve integers?
//Each input should have exactly one solution?
//Return the answer in any order?
//Input array can be empty?

//Approach
//I will solve this using HashMap & by calculating complement
//I will use a HashMap mapping each previously see number to its index.
//For each element nums[i], I will calculate target - nums[i].
//If that complement has already been seen, I have found the pair
//& return the stored index & i.
//Otherwise I store the current value and its index and continue.
//This gives O(N) expected time and O(N) space

//Time Complexity: O(N)
//Space Complexity: O(N)

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        int complement = 0;
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
