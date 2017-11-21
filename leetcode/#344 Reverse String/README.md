Link : https://leetcode.com/problems/reverse-string/description/

Write a function that takes a string as input and returns the string reversed.

Example:

Given s = "hello", return "olleh".

--------------------------------
## My Solution
#### 1.先將字串轉成字元陣列
    char[] chars = s.toCharArray();
#### 2.從最後一個一個取出來塞進到StringBuilder
    builder.append(chars[i]);
