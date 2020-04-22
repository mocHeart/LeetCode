package leetBank._010;

class Solution {
    // 解法1: 回溯法
    // 每次都对一个字符进行匹配，同时考虑下一个字符是否为*,再回溯
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        // 检测头个字符是否相匹
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        // 下一个匹配字符为 * ，此时存在两种情况：
        // 1. 不管第一个是否匹配上，*都解释为前面的字符0次出现
        // 2. 第一个字符匹配上，*解释为前面字符至少出现1次，将原字符串去掉第一个字符再与p进行匹配
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        // 下一个字符不为*，正常推进匹配
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    // 解法2: 动态规划
    // 该问题存在最优子结构，可将中间结构存储
    // dp(i, j) 表示 s[i:] 和 p[j:] 是否匹配
    // 自顶向下
    enum Result {
        TRUE, FALSE
    }
    Result[][] memo;
    public boolean isMatch2(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }
    public boolean dp(int i, int j, String text, String pattern) {
        // 结束条件
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            // i j 对于的字符是否匹配
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));
            // 下一个字符为*时
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            // 下一个字符不为*时
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    // 自低向上
    public boolean isMatch3(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean first_match = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) ||
                                p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isMatch("aaa", "a*a"));
    }
}