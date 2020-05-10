package leetBank._022;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 解法1： 递归回溯
    // 字符串长度 == 2n  完成一个项, 然够用left、right记录左、右括号的数目，递归添加
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String str, int left, int right, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (left < max)
            backtrack(result, str + "(", left + 1, right , max);
        if (right < left)
            backtrack(result, str + ")", left, right + 1, max);
    }

    // 解法2：
    /*
    任何一个括号序列都一定是由 ( 开头，并且第一个 ( 一定有一个唯一与之对应的 )。
    这样每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）。
    那么，要生成所有长度为 2 * n 的括号序列，我们定义一个函数 generate(n) 来返回所有可能的括号序列。
    那么在函数 generate(n) 的过程中：
        我们需要枚举与第一个 ( 对应的 ) 的位置 2 * i + 1；
        递归调用 generate(i) 即可计算 a 的所有可能性；
        递归调用 generate(n - i - 1) 即可计算 b 的所有可能性；
        遍历 a 与 b 的所有可能性并拼接，即可得到所有长度为 2 * n 的括号序列。
    为了节省计算时间，我们在每次 generate(i) 函数返回之前，把返回值存储起来，
    下次再调用 generate(i) 时可以直接返回，不需要再递归计算。
    */
    private ArrayList[] cache = new ArrayList[100];
    public List<String> generateParenthesis2(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis2(c))
                    for (String right: generateParenthesis2(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }



    public static void main(String[] args) {
        Solution so = new Solution();
        List<String> list = so.generateParenthesis2(3);
        for (String s : list) {
            System.out.println(s);
        }
    }


}
