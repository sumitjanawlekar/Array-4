// Time Complexity : O(n), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. Place 2 pointer left and right at 0th index.
//2. add the value at right pointer to the runningSum and update the new max.
//3. if left and right are not at the same place, check the cuurent number at right is greater than the runningSum, If yes reset left
        //to the right pointer's place and reset runningSum to 0 (basically starting a new window)
        //If not, then increase the current window, by just moving the right one step forward

// Your code here along with comments explaining your approach

class Solution {
    public int maxSubArray(int[] nums) {
        //global max
        int max = Integer.MIN_VALUE;
        int runningSum = 0;
        //array size
        int n = nums.length;
        //maintain 2 pointer left and right
        int l = 0;
        int r = 0;
        
        while(l<n && r<n){
            runningSum += nums[r];
            //update max
            max = Math.max(max, runningSum);
            //if value at r is greater than the runningSum, then reset l to r And reset the runningSum to 0
            if(l != r && nums[r] > runningSum){
                l = r;
                runningSum =0;
            }else{//if not, then continue to add incoming number in the existing window
                 r++;
            }
        }
        return max;
    }
}