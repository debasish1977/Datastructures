package COMPANY_WISE_PROBLEMS.WALMART.ARRAYS.TWO_POINTERS;

public class TwoPointers {
    static boolean twoSum(int[] arr,int target){
        //Sort the array
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target)
                return true;
            else if(sum < target)
                left++;
            else
                right--;
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {-3,-1,0,1,2};
        int target = -2;
        if(twoSum(arr,target)){
            System.out.println("found target");
        }
        else{
            System.out.println("false");
        }
    }
}
