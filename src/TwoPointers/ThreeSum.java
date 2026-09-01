package TwoPointers;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Clarifying Questions
// 1. Can the input contain duplicate values?
// 2. Should the result contain only unique triplets?
// 3. Is it acceptable to modify the input array by sorting it?

// Approach
// Sort the array.
// Fix nums[i] as the first element.
// For the remaining portion, use two pointers:
//
// If sum < 0  -> increment left.
// If sum > 0  -> decrement right.
// If sum == 0 -> add the triplet, move both pointers,
//                and skip duplicates.
// Also skip duplicate values for nums[i].

//Time Complexity: O(N2)
//Space Complexity: O(1)

//Leetcode link: https://leetcode.com/problems/3sum/description/?envType=company&envId=apple&favoriteSlug=apple-all


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length < 3)
        {
            return result;
        }

        Arrays.sort(nums);
        int sum = 0;
        for(int i=0;i<nums.length -2;i++){
            // Skip duplicate first elements
            if(i > 0 && nums[i]==nums[i-1])continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left]==nums[left-1])left++;
                    while(left < right && nums[right]==nums[right+1])right--;
                }
                else if(sum < 0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
