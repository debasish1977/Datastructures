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

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0)return new int[0];
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(freqMap.containsKey(complement)){
                return new int[] {freqMap.get(complement),i};
            }
            freqMap.put(nums[i],i);
        }
        return new int[0];
    }
}
