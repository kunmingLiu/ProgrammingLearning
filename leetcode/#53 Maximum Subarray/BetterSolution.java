class Solution {
    public int maxSubArray(int[] nums) {
        
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            int curr = nums[i - 1] + (prev > 0 ? prev : 0);
            max = Math.max(max, curr);
            prev = curr;
        }
        
        return max;
    }
}
