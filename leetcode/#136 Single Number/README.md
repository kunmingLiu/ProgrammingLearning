Link : https://leetcode.com/problems/single-number/

Given an array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

------------------------------------
## Solution
#### 1.這題只想得到用兩個迴圈去完成，但是很明顯的這種暴力方式一定不是題目要的。(時間複雜度:o(n^2))

#### 2.最後參考了別人的做法，才知道是要用nor的方式來處理。
    0^0=0
    1^0=1
    0^1=1
    1^1=0
    
    [x1,x2,x3,x1,x2] 把每個元素都做nor => x1^x2^x3^x1^x2
    nor是可以交換位置而不影響結果的，因此把位置交換一下 => x1^x1^x2^x2^x3
    兩個相同的元素作nor，會變成0 => 0^0^x3
    而0跟其他非0的元素作nor，會等於該元素本身 => x3    
