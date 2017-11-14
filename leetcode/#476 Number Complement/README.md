Link : https://leetcode.com/problems/number-complement/description/

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.

-------------------------------
#### My Solution
##### 1.透過~(not)就可以將某個變數的bit由1轉成0或由0轉成1。
    int x = 8; //1000(前面有28個0)
    int y = ~x; //11111111111111111111111111110111

##### 2.再透過Integer.toBinaryString將int轉成二進位的字串
    String xBits = Integer.toBinaryString(x); //"1000" (只有四位，不會有前面的0)
    String yBits = Integer.toBinaryString(y); //"11111111111111111111111111110111"
    
##### 3.因為不考慮input前面的那些0，所以透過擷取字串的方式，讓轉換的補數字串的長度與input的二進位字串相同。
    yBits = yBits.substring(yBits.length() - xBits.length() , yBits.length());
    
##### 4.再將3的字串，轉成整數
    int value = Integer.parseInt(yBits, 2);
