class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }
}
----------------------------------------------
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}