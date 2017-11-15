class Solution {
    public int maxSubArray(int[] nums) {
		int length = nums.length;
		int max = nums[0];
		int sum = 0;
		for(int i = 0 ; i < length ; i ++){
			sum = nums[i];
			if(sum > max){
				max = sum;
			}
			for(int j = i + 1 ; j < length ; j++){
				sum =  sum + nums[j];
				if(sum > max){
					max = sum;
				}
			}
		}
		return max;
    }
}
