package leetBank._003;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int leftIndex = 0;
        int len = 0;
        int lenMax = 0;
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charSet[c]) {  // 不包含
                charSet[c] = true;
                len++;
            } else {
                while (s.charAt(leftIndex) != c) {
                    charSet[s.charAt(leftIndex)] = false;
                    leftIndex++;
                    len--;
                }
                leftIndex++;
            }
            if (len > lenMax) {
                lenMax = len;
            }
        }
        return lenMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }
}
