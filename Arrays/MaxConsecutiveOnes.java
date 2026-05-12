/*
485. Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */

import java.util.*;

public class MaxConsecutiveOnes {
    // Time complexity : O(n)
    // Space complexity : O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array length");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int ans = obj.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones : " + ans);
        sc.close();
    }
}
/*
Interview Explanation
    Approach
    Traverse the array:
        If current element is 1
            → increment count
    Update maximum answer
        If 0
            → reset count to 0
 */