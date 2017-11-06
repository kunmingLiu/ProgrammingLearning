Link : https://leetcode.com/problems/two-sum/description/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

----------------------------------------------------
Note : 

1.這題要找出陣列元素中，兩者相加等於target的元素，所以換一個方向來思考，如果元素B等於target-元素A，那麼元素A跟元素B就是我們要找的元素。

2.因為要能夠快速地找出陣列值跟index的對應關係，因此使用HashMap。hashMap => key : 元素的值 ; value : 元素的index。這樣我們才能直接透過值，來得到該元素的index。
