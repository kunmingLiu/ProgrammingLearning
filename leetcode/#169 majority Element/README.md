Link : https://leetcode.com/problems/majority-element/description/

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

-------------------------------
## My Solution
#### 1.因為要找出在這集合中出現次數超過半數的元素，所以要先算出說倒底超過幾次叫半數。
    int length = nums.length;
    int majority = length / 2 +1;

#### 2.先將此集合做排序，這樣方便統計次數。
    Arrays.sort(nums);
    
#### 3.用個迴圈檢查每個元素，若元素相同則一直＋＋;若發現有不同的，則就將count還原成1。若count大於等於半數的話，就是我們要找的值。
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

