/*
53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

import java.util.*;

public class MaximumSubarray {
    // Time complexity : O(N^2)
    //Space complexity : O(1)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int countSubArray = 0;
            for (int j = i; j < n; j++) {
                countSubArray += nums[j];
                ans = Math.max(ans, countSubArray);
            }
        }
        return ans;
    }

    //Kadane’s Algorithm
    //Time complexity   : O(N)
    //Space complexity  : O(1)
    public int maxSubArrayKadane(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a array size :");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter a array elements :");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        MaximumSubarray obj = new MaximumSubarray();
        int ans = obj.maxSubArrayKadane(nums);
        System.out.println("Maximum subarray sum is: " + ans);
        sc.close();

    }
}

/*
Interview Explanation
Kadane’s Algorithm works by maintaining a running subarray sum.

At every index:
- if extending the current subarray increases the sum, continue it
- otherwise start a new subarray from current element

We continuously track the maximum sum seen so far.
 */