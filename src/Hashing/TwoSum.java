//Clarifying questions
//The input array contains both +ve & -ve integers?
//The input array can be empty?
//Can I assume only one valid pair exists?
//Can the same element be used twice?
//Can the input be null?

//Approach
//I will solve this using HashMap & Complement approach
//As I scan from left to right, the map contains values I have already seen and their indices
//For each current value, nums[i], I will check target - nums[i] has already seen
//If so those two indices form the answer

//Time Complexity: O(N)
//Space Complexity: O(N)

package Hashing;

import java.util.HashMap;

/*
Leet code link:  https://leetcode.com/problems/two-sum/?envType=company&envId=apple&favoriteSlug=apple-all
*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
