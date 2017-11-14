class Solution {
    public int findComplement(int num) {
        int complement = ~num;
        String numBits = Integer.toBinaryString(num);
        String complementBits = Integer.toBinaryString(complement);
        complementBits = complementBits.substring(complementBits.length() - numBits.length() , complementBits.length());
        return Integer.parseInt(complementBits, 2);
    }
}