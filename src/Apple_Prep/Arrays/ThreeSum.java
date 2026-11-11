package Apple_Prep.Arrays;

//Clarifying questions
//The input contains both +ve & -ve integers
//The solution must not contain duplicate triplets
//The input can be empty?

//Approach
//I will solve this using two pointers

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0)return result;
        Arrays.sort(nums);
        int sum = 0;

        //Fix the first number
        for(int i=0;i<nums.length - 2;i++){
            //Skip duplicate first number
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }

            if(nums[i] > 0){
                break;
            }

            //Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                sum = nums[left] + nums[right] + nums[i];
                if(sum ==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    //Skip duplicate second numbers
                    while(left < right && nums[left]==nums[left-1]){
                        left++;
                    }

                    //Skip duplicate third number
                    while(left < right && nums[right]==nums[right+1]){
                        right--;
                    }

                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right --;
                }
            }
        }
        return result;
    }
}
