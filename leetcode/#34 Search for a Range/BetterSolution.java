class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if(nums == null || nums.length == 0) {  return res;}
        int n = nums.length;
        int lo = 0;
        int hi = nums.length-1;
        int mid = 0;
        //find left
        while(lo < hi) {
            mid = (hi-lo)/2 + lo;
            if(target <= nums[mid] ) {
                hi = mid;
            }else {
                lo = mid+1;
            }
        }
        if(nums[lo] != target) {
            return res;
        }else {
            res[0] = lo;
        }
        if( hi+1<n && nums[hi+1] != target) {
            res[1] = hi;
            return res;
        }
        
        hi = n-1;
        // find right
        while(lo < hi) {
            mid = (hi-lo)/2 + lo + 1;
            if( nums[mid] <= target) {
                lo = mid;
            }else {
                hi = mid -1;
            }
        }
        res[1] = hi;
        return res;
        
    }
}
