package leetBank._013;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 解法：依次累加每个字符对应的数，如果当前字符比前一个大，则表明前一个字符是左侧的，需要减去其两倍
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1)))
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            else
                result += map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.romanToInt("IX"));
    }
}
