class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        
        for(int i = 0 ; i < nums.length ; i++){
            int findValue = target - nums[i];   
            if(hashmap.containsKey(findValue)){
                return new int[]{hashmap.get(findValue) , i};
            }
            hashmap.put(nums[i] , i );
        }
        return null;
    }
}
