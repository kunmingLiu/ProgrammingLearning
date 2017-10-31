public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>>res=new LinkedList<List<Integer>>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int negate=-nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==negate){
                    List<Integer> tmp=new LinkedList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                        
                }
                else if(nums[left]+nums[right]<negate){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;

    }
}
