Link : https://leetcode.com/problems/maximum-subarray/description/

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

-------------------------------------
## My Solution
#### 1.這題目前只想到用暴力的方式來解決，開兩個Loop去加，從第一個元素一直加到最後一個(下一次則由第二個元素加到最後一個)，另外在計算過程時，把最大值給記下來。
  
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
    
-------------------------------------
## Better Solution
#### 1.如果發現前一個和小於0的話，則直接忽略此值，因為若小於0的話，也只會越加越小而已。
    int curr = nums[i - 1] + (prev > 0 ? prev : 0);

  
