class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashmap = new HashMap();
        for(int i = 0 ; i < nums.length ; i++){
            hashmap.put(nums[i], i);
        }
        for(int i = 0 ; i < nums.length ; i++){
            int findValue = target - nums[i];   
            if(hashmap.get(findValue) != null && hashmap.get(findValue) > i ){
                return new int[]{i,hashmap.get(findValue)};
            }
        }
        return null;
    }
}