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

improvement : 

1.一開始的做法是會先把一個迴圈來塞值到hashMap中(MySolution.java)，但是其實不需要這麼做。

2.其實只需要一個迴圈，而每次都先檢查hashMap中是否已經有符合的值，若沒有才將這次迴圈得值塞進hashMap中。

ex. nums = [3,2,4] target = 6

loop 0 :  diff =  6 - 3 ; 因為hashMap現在連一個值都沒有，因此此次迴圈不會成立。之後將(陣列值,陣列索引)(3,0)塞進hashMap中。

loop 1 :  diff =  6 - 2 ; 因為hashMap現在裡面只有loop0塞進去的3，因此此次迴圈不會成立。之後將(陣列值,陣列索引)(2,1)塞進hashMap中。

loop 1 :  diff =  6 - 4 ; 因為hashMap現在裡面有loop1塞進去的2，因此此次迴圈成立。之後return (hashMap.get(diff) , i) = (1,2)
