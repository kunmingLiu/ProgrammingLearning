Link : https://leetcode.com/problems/search-for-a-range/description/

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

------------------------------------------------
Note :

1.利用Binary Search的方式，先找找看中間的那個是不是等於target; 如果中間的值剛好等於target，但是中間值的左右半間可能也都是等於target，因此還是需要針對左右半邊再進行Binary Search。

2.若發現target是大於middle值的，那只需要針對middle的右半邊進行Binary Search。

3.若發現target是小於middle值的，那只需要針對middle的左半邊進行Binary Search。
