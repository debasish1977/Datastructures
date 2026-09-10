package TwoPointers;

import java.util.Arrays;

//Clarifying Questions
//Only +ve integers?
//input can contain both +ve and -ve integers?

//Approach
//I will solve this using two pointers approach


//Time Complexity: O(N)
//Space complexity: O(1)

public class PairWithTargetSum {
    public static int[] search(int[] arr,int targetSum){
        if(arr==null || arr.length < 2) return new int[] {-1,-1};
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int sum = 0;
        while(left < right){
            sum = arr[left] + arr[right];
            if(sum == targetSum){
                return new int[] {left,right};
            }
            else if(sum < targetSum){
                left++;
            }
            else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }
}
