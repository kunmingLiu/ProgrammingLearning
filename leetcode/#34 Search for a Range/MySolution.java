public class MySolution {
    public int[] searchRange(int[] nums, int target) {
        boolean[] ranges = new boolean[nums.length]; //用一個boolean陣列來記錄哪個index的值等於target
        int low = 0;
        int high = nums.length - 1;

        int[] result = new int[]{-1,-1}; // 初始result = [-1,-1]

        binarySearch(nums,ranges,low,high,target);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ranges.length; i++) {
            if(ranges[i]){
                min = Math.min(min,i);//取得值等於target的最小index
                max = Math.max(max,i);//取得值等於target的最大index
            }
        }
        if(min == Integer.MAX_VALUE){//代表沒有任何的值等於target
            return result;
        }else{
            result[0] = min;
            result[1] = max;
        }
        return result;
    }

    private void binarySearch(int[] nums, boolean[] ranges, int low, int high, int target) {
        if (low < 0 || high >= nums.length ||low > high) {
            return;
        }
        int middle = (low + high) / 2;
        if (nums[middle] == target) { //若中間的值剛好等於target，但是middle的左右邊也有可能是等於target的
            ranges[middle] = true;
            binarySearch(nums, ranges, low, middle - 1, target);
            binarySearch(nums, ranges, middle + 1, high, target);
        } else if (nums[middle] > target) {//若middle的值大於target，那target只會出現在左邊
            ranges[middle] = false;
            binarySearch(nums, ranges, low, middle - 1, target);
        } else {//若middle的值小於target，那target只會出現在右邊
            ranges[middle] = false;
            binarySearch(nums, ranges, middle + 1, high, target);
        }
    }
}
