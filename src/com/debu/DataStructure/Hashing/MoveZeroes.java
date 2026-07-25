package com.debu.DataStructure.Hashing;

//Clarifying Questions
//Will the integer array contain only +ve integers?
//Need to in-place?
//Input array can be empty?

//Approach
//I will do this two pointers
//There will be one pointer which will be used to write
//There will be one pointer which will be used to read

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)return new int[0];
        int write = 0;
        for(int read=0;read < nums.length;read++){
            if(nums[read] !=0){
                nums[write++] = nums[read];
            }
        }
        while(write < nums.length){
            nums[write++]=0;
        }
        return nums;
    }
}
