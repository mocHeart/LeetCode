package leetBank._014;

public class Solution {
    // 解法1：
    // 首先将最短的字符串找出，再根据最短的子串，比对得到公共前缀
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len < 1)
            return "";
        if (len == 1)
            return strs[0];

        // 找出最短的字符串
        int shortIndex = 0;
        int shortLen = strs[0].length();
        for (int i = 1; i < len; i++) {
            if (strs[i].length() < shortLen) {
                shortIndex = i;
                shortLen = strs[i].length();
            }
        }
        if (shortLen == 0)
            return "";

        // 寻找公共前缀子串
        int com = 0;
        boolean flag = true;
        while (flag && com < shortLen) {
            char c = strs[shortIndex].charAt(com);
            for (int i = 0; i < len; i++) {
                if (c != strs[i].charAt(com)) {
                    flag = false;
                    com--;
                    break;
                }
            }
            com++;
        }
        return strs[0].substring(0, com);
    }

    // 解法2： 水平扫描
    // 从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符
    // （即不同字符串相同下标的字符）然后再进行对下一列的比较
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // 解法3: 分治
    // 从头到尾挨个比较 lcpLeft 与 lcpRight 中的字符，直到不能再匹配为止。
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // 解法4：二分查找
    // 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        String[] strs = {"c", "c", "c"};
        String s = so.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
