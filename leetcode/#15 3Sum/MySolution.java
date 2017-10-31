class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        mergeSort(nums);
        List<Integer> integers = null;
        int index = -1;
        int first = -1;
        int second = -1;
        int third = -1;
        
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 ){
                if(nums[i] == nums[i-1]){ // 如果與前一個元素一樣，那不用再重複找
                    continue;
                }
            }
            for (int j = i + 1; j < nums.length -1; j++) {
                index = binarySearch(nums,j+1,-(nums[i]+nums[j]) );
                if(index != -1 && (nums[j] != second ||  nums[index] != third)){ //找出來的值，不能與前一個結果相同
                    integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[j]);
                    integers.add(nums[index]);
                    list.add(integers);
                    
                    first = nums[i];
                    second = nums[j];
                    third = nums[index];
                }
            }
        }

        return list;
    }
    private int binarySearch(int[] nums, int start , int value ){
        int middle = (start + nums.length) / 2 ;
        int low = start ;
        int high = nums.length - 1;

        do{
            if(nums[middle] == value){
                return middle;
            }
            else if(nums[middle] > value){
                high = middle - 1;
            }else{
                low = middle + 1;
            }
            middle = (low + high) / 2 ;
        }while (low <= high);

        return  - 1;
    }
    private void mergeSort(int[] nums){
        int[] tempArray = new int[nums.length];
        sort(nums,tempArray, 0 , nums.length);
    }
    private void sort(int[] nums, int[] tempArray , int start , int count){
        if(count < 2){
            return;
        }
        sort(nums,tempArray, start , count / 2);//
        sort(nums,tempArray, start + count / 2 , count - count/2);
        merge(nums,tempArray, start , count / 2, start + count / 2 , count - count/2);
    }
    private void merge(int[] nums, int[] tempArray , int leftStart, int leftCount, int rightStart, int rightCount){
        int index = leftStart; // 不是從0開始
        int leftBound = leftStart + leftCount;
        int rightBound = rightStart + rightCount;
        int left = leftStart , right = rightStart;// 不是從0開始
        while(left < leftBound || right < rightBound){
            if(left < leftBound && right < rightBound){
                if(nums[left] < nums[right]){
                    tempArray[index] = nums[left];
                    left++;
                }else{
                    tempArray[index] = nums[right];
                    right++;
                }
            }
            else if(left < leftBound){
                tempArray[index] = nums[left];
                left++;
            }
            else if(right < rightBound){
                tempArray[index] = nums[right];
                right++;
            }
            index++;
        }
        for (int i = leftStart; i < index; i++) {
            nums[i] = tempArray[i];
        }
    }
}