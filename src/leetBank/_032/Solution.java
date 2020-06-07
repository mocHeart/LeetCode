package leetBank._032;

import java.util.Map;
import java.util.Stack;

class Solution {
    // 解法1: BF
    // 逐个考虑所有的非空偶数长度字符串
    // 栈 -- 判断字符串是否有效
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }


    // 解法2： 动态规划
    // 存储定义：  dp[i]  ==>  第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度
    // 形如： ...(  ==>  dp[i] = 0
    // 形如： ...()  ==>  dp[i] = dp[i-2] + 2
    // 形如： ...)) 且 倒数第二个 ) 有效 且 和最后一个 ) 匹配的为 ( ==> dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
    public int longestValidParentheses2(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length()];    // 默认初始化为0
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {   //  形如： ...()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {  //  形如： ...))
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }


    // 解法3： 栈
    // 栈的自回溯特性
    // 初始 ==>  -1 入栈
    // （  ==>   对应下标入栈
    //  )  ==>  出栈后，当前下标 - 栈顶下标 为当前最大有效括号长度
    public int longestValidParentheses3(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }


    // 解法4： 两次扫描，无需额外空间
    // 由左至有右扫描：
    // 计数器 left = right = 0
    // (  ==>  left++ 或  )  ==>  right++
    // left == right ==> 当前最大有效括号长度为 2*right
    // right > left  ==> 无效，left = right = 0
    // 由左至有右扫描：方法一样
    // 原因： (() 会扫描不到
    public int longestValidParentheses4(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLen = Math.max(maxLen, 2 * right);
            else if (right > left)
                left = right = 0;
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxLen = Math.max(maxLen, 2 * right);
            else if (left > right)
                left = right = 0;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.longestValidParentheses2("()(())"));
    }
}