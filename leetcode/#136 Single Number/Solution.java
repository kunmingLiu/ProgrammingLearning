class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int singleNumber = 0;
        for(int i = 0 ; i < length ; i++){
            singleNumber = singleNumber ^ nums[i];
        }
        return singleNumber;
    }
}
