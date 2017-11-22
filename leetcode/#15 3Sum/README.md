Link : https://leetcode.com/problems/3sum/description/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

--------------------------------------------
## My Solution
#### 1.先用Merge Sort 將陣列進行排序

#### 2.由第0個元素開始找，然後一個一個往右邊找；因為要讓a + b + c = 0，因此可以推論出 c = -(a+b)，所以目的就是找陣列中元素等於-(a+b)

#### 3.透過Binary Search來做找尋
    //nums[i] = a
    //nums[j] = b
    //要找j右邊有等於-(a＋b)    
    index = binarySearch(nums,j+1,-(nums[i]+nums[j]) );
    
#### 4.因為已經排序過了，因此若下一個元素等於上一個元素，那就不用重複尋找了

#### 5.每一組a,b,c都是唯一的，因此用兩個變數去紀錄b與c的值，因為排序過的關係，因此只要檢查目前的元素是不是等於上一個元素即可

--------------------------------------------
## Better Solution
#### 1.Java有提供陣列的排序函式，不用自己寫Merge Sort
    Arrays.sort(nums);

#### 2.不是要找出c=-(a+b)，而是要找出b+c=-a ; 並且一邊從左邊開始找，另一邊從右邊開始找
    int negate=-nums[i];
    int left=i+1;
    int right=nums.length-1;
    while(left<right){
        if(nums[left]+nums[right]==negate){
        
        }
    }

#### 3.當找到left及right時，還要將相同的元素作排除
    if(nums[left]+nums[right]==negate){
        left++;
        right--;
        while(left<right && nums[left]==nums[left-1]){
            left++;
        }
        while(left<right && nums[right]==nums[right+1]){
            right--;
        }
    } 
    
#### 4.如果發現left+right < negate時，則讓left++ ;反之，則right--
    if(nums[left]+nums[right]<negate){
        left++;
    }
    else{
        right--;
    }
    
