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
--------------------------------
## Better Solution
#### 1.不斷的將字元陣列的頭尾元素對調
    int i =0;
     int j = s.length() -1;
     while(i < j){
         char temp = word[i];
         word[i] = word[j];
         word[j] = temp;
         i++;
         j--;
     }
#### 2.之後再將字元陣列轉成字串即可
    return new String(word);
