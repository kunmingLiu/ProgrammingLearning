Link : https://leetcode.com/problems/valid-number/description/

Validate if a given string is numeric.

Some examples:
"0" => true

" 0.1 " => true

"abc" => false

"1 a" => false

"2e10" => true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

--------------------------------
## My Solution
#### 1.看到這題的第一個就是想到用正規式的方式來處理。
    \\d* : 任意個數字(0~)
    \\d+ : 1個或多個數字(1~)
    [+-]?：+或是-其中一個或是都沒有
    \\d+$：以1個或多個數字(1~)結尾
    ^[+-]：以+或是-其中一個開始
    (A|B)：A或是B其中一個
    
#### 2.但是要考慮到一些特別的case。
    .1 => true
    2. => true
    2e => false
    e2 => false
       
 
