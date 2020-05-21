package leetBank._028;

public class Solution {
    // 解法1：逐个对比
    // needle逐个字符比对，注意部分匹配时需要回溯
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int p = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(p)) {
                p++;
                if (p == needle.length())
                    return i - p + 1;
            } else {
                if (p != 0)   // p!=0时需要回溯
                    i -= p;
                p = 0;
            }
        }
        return -1;
    }

    // 解法2：子串逐一对比
    // 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较
    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }


    // 解法3：双指针
    // 结合解法1和解法2，在首字符匹配的情况下在进行子串的匹配
    public int strStr3(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // 在 haystack 字符串中找出 needle 首字符匹配的位置
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0))
                ++pn;

            // 计算在 haystack 字符串中的最大匹配长度
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }


            // 匹配长度等于 needle 的长度则确定完全匹配位置返回
            if (currLen == L) return pn - L;

            // 否则回溯
            pn = pn - currLen + 1;
        }
        return -1;
    }


    // 解法4：Rabin Karp算法
    /*
     *    先生成窗口内子串的哈希码，然后再跟 needle 字符串的哈希码做比较。
     * 1. 计算子字符串 haystack.substring(0, L) 和 needle.substring(0, L) 的哈希值。
     * 2. 从起始位置开始遍历：从第一个字符遍历到第 N - L 个字符。
     * 3. 根据前一个哈希值计算滚动哈希。
     * 4. 如果子字符串哈希值与 needle 字符串哈希值相等，返回滑动窗口起始位置。
     * 5. 返回 -1，这时候 haystack 字符串中不存在 needle 字符串。

     */
    public int strStr4(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long)Math.pow(2, 31);

        // compute the hash of strings haystack[:L], needle[:L]
        long h = 0, ref_h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h)
            return 0;

        // const value to be used often : a**L % modulus
        // 计算哈希值的上限
        long aL = 1;
        for (int i = 1; i <= L; ++i)
            aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + L - 1, haystack)) % modulus;
            if (h == ref_h)
                return start;
        }
        return -1;
    }

    private int charToInt(int idx, String s) {
        return (int) s.charAt(idx) - (int) 'a';

    }


    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.strStr("mississippi", "issip"));
    }
}
