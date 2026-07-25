package Binary_Search;

//Clarification Questions
//Is the array sorted in ascending order before rotation?
//Are all elements distinct?
//Can the input array be empty?
//Should I return -1 if the target is not found?

//Approach
//I will use Binary Search
//At every iteration, one half of the array is always sorted
//Determine whether left half or right half is sorted
//Check if the target lies within the sorted half
//Discard the other half
//Continue until target is found or the search space becomes empty

//Time Complexity: O(logN)
//Space Complexity: O(1)

public class Search_In_Rotated_Array {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //Left half is sorted
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
