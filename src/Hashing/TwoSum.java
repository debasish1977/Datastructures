package Hashing;

//Clarifying questions
//Both +ve & -ve integers?
//Only one solution?
//Return the answer in any order?
//Is exactly one valid pair guranteed?
//Should I return indices or values?

//Approach
//As I scan for left to right, I store each previously seen number and its index.
//For the current number x, I check with whether target - x has already been seen.
//If it has, those two values form the required pair

//Time Complexity: O(N)
//Space Complexity: O(N)

public class TwoSum {
}
