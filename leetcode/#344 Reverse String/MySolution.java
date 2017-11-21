class Solution {
    public String reverseString(String s) {
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = length - 1 ; i >=0 ; i--){
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
