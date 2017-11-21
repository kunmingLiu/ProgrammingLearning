class Solution {
    private static final String[] LETTERS = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        return (digits.length() == 0) ? new ArrayList<String>() : recursiveCombine(new ArrayList<String>(), new StringBuilder() , digits , 0);
    }
    private List<String> recursiveCombine(List<String> results , StringBuilder builder , String digits , int index){
        if(index == digits.length()){
            results.add(builder.toString());
            return  results;
        }

        for (char c : LETTERS[Character.digit(digits.charAt(index),10)].toCharArray()) {
            builder.append(c);
            recursiveCombine(results , builder, digits , index + 1);
            builder.deleteCharAt(builder.length()-1);

        }
        return  results;
    }
}
