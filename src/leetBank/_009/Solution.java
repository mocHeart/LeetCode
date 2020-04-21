package leetBank._009;

public class Solution {
    // 解法1：将整数转化为字符串，逆序后进行比较
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        StringBuffer sb = new StringBuffer();
        int y = x;
        while (y >= 10) {
            sb.append(y % 10);
            y /= 10;
        }
        sb.append(y);
        return String.valueOf(x).equals(sb.toString());
    }

    // 解法2：反转一半数字
    // 数字的后半部分进行反转再与前半部分比较
    // 如何得知已经进行了一半：原数字/10(依次) < 反转数字*10 ==> 已处理一半
    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {  // 特殊情况
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.isPalindrome2(2147483647));
    }
}
