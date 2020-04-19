package leetBank._007;

class Solution {
    // 解法： 通过 / % 运算依次取出整数的最后一位，拼接成字符串，最后转化为整数即可
    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        if (x < 0) {
            x = -x;
            sb.append("-");
        }
        for (; x >= 10; x /= 10) {
            sb.append(x % 10);
        }
        sb.append(x);

        int res = 0 ;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int res = so.reverse(1534236469);
        System.out.println(res);
    }
}