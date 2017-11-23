class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int majority = length / 2 +1;
        int count = 1;
        int value = nums[0];
        
        for(int i = 1 ; i < length ; i++){
            if(value == nums[i]){
                count++;
                if(count == majority){
                    return value;
                }
            }
            else{
                value = nums[i];
                count = 1;
            }
        }
        return value;
    }
}
