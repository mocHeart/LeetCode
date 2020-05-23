package leetBank._030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 解法1:  哈希表
    // 单词长度固定，将单词放在一个哈希表中，截取字符串也放在哈希表，比较他们是否相等
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);  // 没有为1，有就+1
        }

        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();

            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }

            if (map.equals(tmp_map))  // map存放的数据是否完全一样
                res.add(i);
        }
        return res;
    }

    // 解法2: 滑动窗口 （哈希表 + 双指针）
    // 采用左右指针指向子串的截取的始末，每次增加都有单词长度为基数（哈希表 + 双指针）
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return res;

        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // < one_word ??   考虑单词截取的可能情况
        // 对于重复出现的有 不含置零 和 重复置零
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();

            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;

                if (!map.containsKey(w)) {  // 哈希表中不含该单词
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;

                    // 子串出现某单词的数目大于words中出现的次数
                    // 窗口左侧右移一个单词的长度（直到条件不满足）
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }

                    if (count == word_num)
                        res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        String[] words = {"foo","bar"};
        List<Integer> list = so.findSubstring2("barfoofoobarman", words);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

}
