/*
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?

 */

import java.util.*;

public class MoveZeroes {
    // Time complexity  : O(N)
    // Space complexity : O(1)
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) { // [0,1,0,3,12]
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length :");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MoveZeroes obj = new MoveZeroes();

        obj.moveZeroes(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}


/*
Logic:
    i → traverses array
    j → keeps track of position for next non-zero element

When a non-zero is found:
    swap nums[i] with nums[j]
    increment j

Interview Explanation (Very Important)
We use two pointers.

Pointer i traverses the array.

Pointer j maintains the position where the next non-zero element should be placed.

Whenever a non-zero element is found, we swap it with index j and increment j.

This ensures:
- all non-zero elements stay in original order
- all zeroes move to the end
- operation happens in one traversal
 */