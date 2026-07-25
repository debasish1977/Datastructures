package com.debu.DataStructure.CrackingTheCodeInterview;

public class MaxSubArraySum {
    public static int maxSubArraySum(int[] nums)
    {
        int currentSum = 0;
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++)
        {
            currentSum = Math.max(nums[i],currentSum + nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySum(nums));
    }
}
