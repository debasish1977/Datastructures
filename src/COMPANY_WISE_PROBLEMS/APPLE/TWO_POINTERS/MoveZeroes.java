package COMPANY_WISE_PROBLEMS.APPLE.TWO_POINTERS;
//Clarifying questions
//Can the input contain +ve, negative and zero values?
//Can the input array be empty or null?
//Do we need to preserve the relative order of non-zero elements?
//Should the modification be performed in-place?

//Approach
//I will solve this using two pointers
//I will have two pointers read & write
//I will first iterate through the inpout array and create the input array
//Then I will increase the write pointer

//Time Complexity: O(N)
//Space Complexity: O(1)

public class MoveZeroes {
    public int[] moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)return new int[0];
        int write = 0;
        for(int read=0;read<nums.length;read++){
            if(nums[read]!=0){
                nums[write++]= nums[read];
            }
        }
        while(write < nums.length){
            nums[write++] = 0;
        }
        return nums;
    }
}
