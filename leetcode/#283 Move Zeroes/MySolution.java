class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int swapIndex = 0;
        for(int i = 0 ; i < length ; i ++){
            if(nums[i] != 0){
                swap(nums, i , swapIndex);
                swapIndex++;
            }
        }
    }
    void swap(int[] nums , int index , int swapIndex){
        int temp  = nums[index];
        nums[index] = nums[swapIndex];
        nums[swapIndex] = temp;
    }
}
