Link : https://leetcode.com/problems/move-zeroes/description/

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

You must do this in-place without making a copy of the array.

Minimize the total number of operations.

--------------------------------------
## My Solution
#### 1.用一個整數來記錄不為零元素目前排到第幾個index了。
    int swapIndex = 0;
    
#### 2.從第0個元素開始檢查，若發現有不為零的元素，那就與現在swapIndex所指的元素交換位置。
    for(int i = 0 ; i < length ; i ++){
        if(nums[i] != 0){
            swap(nums, i , swapIndex);
            swapIndex++;
        }
    }
###### nums = [0, 1, 0, 3, 12]

    i = 0 => 因為nums[0] == 0，所以不作任何處理。
    
    i = 1 => 因為nums[1] != 0，所以將此元素與swapIndex所指的元素交換位置，而一開始的swapIndex=0，因此就是與第0個元素交換位置;
    所以nums就變成[1, 0, 0, 3, 12]。之後再將swapIndex++。
    
    i = 2 => 因為nums[2] == 0，所以不作任何處理。
    
    i = 3 => 因為nums[3] != 0，所以將此元素與swapIndex所指的元素交換位置，現在的swapIndex=1，因此與第1個元素交換位置;
    所以nums就變成[1, 3, 0, 0, 12]。之後再將swapIndex++。
    
    i = 4 => 因為nums[4] != 0，所以將此元素與swapIndex所指的元素交換位置，現在的swapIndex=2，因此與第2個元素交換位置;
    所以nums就變成[1, 3, 12, 0, 0]。
