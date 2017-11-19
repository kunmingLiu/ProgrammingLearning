
Link : https://leetcode.com/problems/reverse-words-in-a-string-iii/description/

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"

Output: "s'teL ekat edoCteeL tsetnoc"

Note: In the string, each word is separated by single space and there will not be any extra space in the string.

---------------------------------------
## My Solution
##### 1.用個迴圈一個字一個字判斷，當目前字元是' '，開始對此字元的左半邊做反轉。
    for (int i = 0; i < length; i++) {
        if(s.charAt(i) == ' '){
        
        }
    }
    
##### 2.將空白字元的左邊字串擷取出來，並將字串轉成字元陣列後，用倒序的方式一個一個字元放進StringBuilder。因為空白還是要保留，因此字元陣列放完之後，後面要再補一個空白。
    temp = s.substring(spaceIndex,i);
    char[] chars = temp.toCharArray();
    for (int j = temp.length() - 1 ; j >= 0; j--) {
        builder.append(chars[j]);
    }
    builder.append(' ');
    
##### 3.因為每次要擷取的子字串範圍是上一個空白字元的下一個到此空白字元，因此每次處理完子字串的時候，要更新spaceIndex。
    spaceIndex = i+1;
    
    string = "123 456 789"; spaceIndex = 0;
    當index=3時，發現' '，因此要擷取該空白字元的左半邊，而因為spaceIndex=0，所以第一次擷取的字串範圍：substring(0,3);
    而下次要擷取的字串要由此空白字元的右邊開始，因此spaceIndex=3+1=4;
    
    當index=7時，發現' '，因此要擷取該空白字元的左半邊，而現在的spaceIndex=4，因此擷取的字串範圍：substring(4,7);
    而下次要擷取的字串要由此空白字元的右邊開始，因此spaceIndex=7+1=8;
    
##### 4.因為字串的結尾不會是空白字元，因此當1的迴圈跑完之後，還要從3最後的spaceIndex開始擷取到最後一個字，然後再將此子字串加進StringBuilder。
    
    
    
    
    
