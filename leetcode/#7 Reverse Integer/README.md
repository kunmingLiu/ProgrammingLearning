Link : https://leetcode.com/problems/reverse-integer/description/

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

----------------------------------------------

## My Solution
#### 1.因為是要將整數倒轉過來再return，因此一開始的想法是將整數轉成字串，之後再將字串轉成字元陣列，這樣就很容易倒轉過來。
    String intStr = String.valueOf(x);
    char[] chars = intStr.toCharArray();
    
#### 2.但是要考慮到前面如果帶有+或是-時的情況，若帶有符號的話，則符合還是要保留在最前面的位置，因此字元陣列就要從index=1的位置開始處理;
    if(chars[0] == '-' || chars[0] =='+'){
        for (int i = chars.length - 1; i >= 1 ; i--) {
        
        }
    }
    
#### 3.將字元陣列從最後面一個一個取出來後，轉成數字;但是轉成數字後，並需要乘上10^x (如果是個位數，則就乘上10^1;如果是十位數，則就乘上10^1)。
###### 最大的次方數就是字串長度-1(如123，會發現最高位數是百位，那最大的次方就是10^(3-1));每次算完一個位數後，就要將radix/10。
    radix = Math.pow(10,length-1);
###### 如果前面帶有符號的話，因為index=0的位置是符號，因此必須要多減掉1位。 
    radix = Math.pow(10,length-2);
    reverse += (Character.digit(chars[i],10) * radix);
    radix /= 10;

#### 4.最後數字累加完後，若本來前面帶有符號的話，則必須要把符號加回去給數字。
    if(chars[0] == '-'){
        reverse  = -reverse;
    }
    if(chars[0] =='+'){
        reverse  = +reverse;
    }


#### 5.題目中有提到說如果有overflow的話，則就直接給0。若處理的時候，發現數值已經大於等於了Integer.MAX_VALUE或是小於等於nteger.MIN_VALUE，則不用再算下去了，直接return 0。
    if(reverse >= Integer.MAX_VALUE) {
        reverse = 0;
        break;
    }
    if(reverse <= Integer.MIN_VALUE){
        reverse =  0;
        break;
    }





