package TwoPointers;
//Clarifying questions
//Will the array contain both +ve & -ve integers?
//input array can be empty?
//We must do this in-place?

//Approach
//We will solve this using two pointers
//There will be one pointer to read and one pointer toi write

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)return new int[0];
        int write = 0;
        for(int read=0;read<nums.length;read++){
            if(nums[read]!=0){
                nums[write]=nums[read];
                write++;
            }
        }
        while(write < nums.length){
            nums[write++]=0;
        }
        return nums;

    }
}
