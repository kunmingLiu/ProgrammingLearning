class Solution {
    public boolean isNumber(String s) {
        String number = s.trim();
        if(number.matches("^[+-]?((\\d*[.]((\\d+[e][+-]?\\d+$)|(\\d+$)))|(\\d+(([.]?[e][+-]?\\d+$)|([.]?\\d*))))")){
            return true;
        }
        return false;
    }
}
