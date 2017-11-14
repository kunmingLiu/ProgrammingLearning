class Solution {
    public int reverse(int x) {
        String intStr = String.valueOf(x);
        int length = intStr.length();
        
        if(length == 1){
            return x;
        }else{
            char[] chars = intStr.toCharArray();
            double radix = 0 ;
            int reverse = 0;
            if(chars[0] == '-' || chars[0] =='+'){
                radix = Math.pow(10,length-2);
                for (int i = chars.length - 1; i >= 1 ; i--) {
                    reverse += (Character.digit(chars[i],10) * radix);
                    radix /= 10;
                    if(reverse >= Integer.MAX_VALUE) {
                        reverse = 0;
                        break;
                    }
                    if(reverse <= Integer.MIN_VALUE){
                        reverse =  0;
                        break;
                    }
                }
                if(chars[0] == '-'){
                    reverse  = -reverse;
                }
                if(chars[0] =='+'){
                    reverse  = +reverse;
                }
            }else{
                radix = Math.pow(10,length-1);
                for (int i = chars.length - 1; i >= 0 ; i--) {
                    reverse += (Character.digit(chars[i],10) * radix);
                    radix /= 10;
                    if(reverse >= Integer.MAX_VALUE) {
                        reverse = 0;
                        break;
                    }
                    if(reverse <= Integer.MIN_VALUE){
                        reverse =  0;
                        break;
                    }
                }
            }
            return reverse;
        }
        
    }
}
