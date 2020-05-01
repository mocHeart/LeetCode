package leetBank._017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<Integer, String> map;
    private final List<String> lists;

    public Solution() {
        map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        lists = new ArrayList<>();
    }

    // 解法： 递归 （回溯 无剪枝）
    // 每次取出一个数字排列，依次类推
    public List<String> letterCombinations(String digits) {
        combine("", digits);
        if (lists.size() == 1)
            lists.clear();
        return lists;
    }

    private void combine(String str, String digits) {
        if (digits.length() == 0) {
            lists.add(str);
            return;
        }
        int number = digits.charAt(0) - 48;
        String comStr = map.get(number);
        for (int i = 0; i < comStr.length(); i++) {
            // 注意状态保存
            combine(str + comStr.charAt(i), digits.substring(1));
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        List<String> res = so.letterCombinations("");
        for (String str : res) {
            System.out.print(str + ", ");
        }
    }
}
