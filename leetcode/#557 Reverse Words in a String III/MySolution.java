class Solution {
    public String reverseWords(String s) {
        int length = s.length();
        int spaceIndex = 0;
        String temp;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == ' '){
                temp = s.substring(spaceIndex,i);
                char[] chars = temp.toCharArray();
                for (int j = temp.length() - 1 ; j >= 0; j--) {
                    builder.append(chars[j]);
                }
                builder.append(' ');
                spaceIndex = i+1;
            }
        }
        temp = s.substring(spaceIndex , length);
        char[] chars = temp.toCharArray();
        for (int j = temp.length() - 1 ; j >= 0; j--) {
            builder.append(chars[j]);
        }
        return builder.toString();
    }
}
