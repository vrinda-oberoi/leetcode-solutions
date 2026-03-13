/*Problem: Find the Duplicate Number
Platform: LeetCode  287
Difficulty: Medium
Date: 13 March 2026
Topic: Arrays / Two Pointer/ Binary Search / Bit Mnipulation */

import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int slow=nums[0];
        int fast=nums[0];

        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];

            if(slow==fast){
                break;
            }
        }

        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }
}