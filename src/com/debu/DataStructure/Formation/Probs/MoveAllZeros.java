package com.debu.DataStructure.Formation.Probs;

public class MoveAllZeros {
    public int[] moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
        {
            throw new IllegalArgumentException("Input cant be null or empty");
        }
        int insertPos = 0;
        //Move all non zero elements to the front
        for(int num:nums)
        {
            if(num!=0)
            {
                nums[insertPos++] = num;
            }
        }
        //Move all the zero's at the end
        while(insertPos < nums.length)
        {
            nums[insertPos++] = 0;
        }
        return nums;
    }
    public static void main(String[] args)
    {
        MoveAllZeros solution = new MoveAllZeros();
        int[] input = {0,1,0,3,12};
        int[] output = solution.moveZeroes(input);
        for(int i=0;i<output.length;i++)
        {
            System.out.println(output[i]);
        }
    }

}
