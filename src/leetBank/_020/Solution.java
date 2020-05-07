package leetBank._020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // 解法： 栈
    // 利用栈先进先出的特点，确认括号的是否按正确闭合
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            else if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || map.get(c) != stack.pop())
                    return false;
            } else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isValid("]"));
    }
}
