package TwoPointers;

//Clarifying Questions
//The input array can contain both +ve & -ve integers?
//Return the maximum amount of water?
//The input array can be empty?

//Approach
//I will solve this using Two Pointers approach
//The first pointer will point to the first index and the second pointer will point to the last index
//I will iterate through the array and calculate the height & the width
//Then I will calculate the area

//Time Complexity: O(N)
//Space Complexity: O(1)

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null || height.length < 2)return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int currentHeight = Math.min(height[left],height[right]);
            int area = width * currentHeight;
            maxArea = Math.max(area,maxArea);
            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
