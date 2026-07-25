/*
'''
At a large party, we have many cakes of various sizes. We want to give all of the attendees the largest possible slice we can, but also make sure all of the slices are the same size.
The cakes are all long and rectangular like a [Jelly Roll](https://www.kingarthurbaking.com/recipes/jelly-roll-recipe), therefore each cake is represented by a single number indicating it's length.

Given an array of cake sizes and number of attendees, what is the largest piece of cake we can give each person. We want to give each person one whole piece of cake, not two that add up to the given size. Any leftover portions of cake can be used to make cake pops!


EXAMPLE(S)
For cakes [5, 2, 7, 4, 9] and 5 attendees, the largest slice we can cut is 4.
- We can cut one slice of size 4 from the first cake with some leftover.
- We don't use the second cake.
- We can get one slice out of the third and fourth cakes.
- The final cake of size 9, we can cut two slices.
- If we tried to cut slices of size 5, we can only make three from the cakes of length 5, 7, and 9 so 4 is the best we can do.

For cakes [1, 2, 3, 4, 9] and 6 attendees, the largest slice we can cut is 2.
- We can't use the first cake, but can get one slice out of the next 2.
- The cake of size four we can divide in half to get two slices.
- We can get four slices out of the cake of length 9.

cakes: [8, 4, 2, 6, 1, 2, 1, 7]
[1, 1, 2, 2, 4, 6, 7, 8]
attendees: 14
output: 2

cakes: [1, 2, 3, 4, 9]
attendees: 5
output: 3

Idea #1:
- sort through the array
- loop through the array
 - for each element -
    loop and mod division the value of array with selected  element
     - add the mod values togerther
    - check if equal or greater than attendees count
    - return the value if once value goes below attendess count

Idea #2:
- Sort the array
- Find the mid element of the sorted array
- Loop and mod division the value of array with selected mid element
- add the division values together
- if the count is less then the no of attendees then we move the pointer to the next element on the left side of the middle element.
- if the count is greater then the no of attendees, then we move the pointer to the next element on the right hand side of the middle element
- If the count matches with the middle element then we end the process.


FUNCTION SIGNATURE
function maxSliceSize(cakes, attendees)
def max_slice_size(cakes, attendees):
'''
*/


package com.debu.DataStructure.Formation.Probs;

import java.util.Arrays;

public class CuttingCake {
    public  int maxSliceSize(int[] cakes, int attendees) {
        if (cakes == null || cakes.length == 0) {
            return 0;
        }
        Arrays.sort(cakes);
        int right = 0;  //Right pointer
        int left = cakes.length - 1;  //Left Pointer
        int found = 0;
        while (right <= left) {
            int mid = (right + left) / 2; //Mid point of the array
            int middleElement = cakes[mid];
            int pieces = 0;
            for (int val : cakes) {
                pieces = pieces + val / middleElement;
            }
            if (pieces < attendees) {
                left = mid - 1;
            } else if (pieces > attendees) {
                right = mid + 1;
                found = middleElement;
            } else {
                return middleElement;
            }
        }
        return found;
    }

    public static void main(String[] args)
    {
        int[] cakes = {5, 2, 7, 4, 9};
        int attendees = 5;
        CuttingCake cuttingCake = new CuttingCake();
        System.out.println(cuttingCake.maxSliceSize(cakes, attendees));

    }
}
