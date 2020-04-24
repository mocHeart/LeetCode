package leetBank._012;

public class Solution {
    // 解法1：字典集
    // 列举出个、整十、整百、整千个字典表，然后将数字的每位拆分对应
    public String intToRoman(int num) {
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hun = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thu = {"", "M", "MM", "MMM"};
        return thu[num / 1000] + hun[num / 100 % 10] + ten[num / 10 % 10] + one[num % 10];
    }

    // 解法2：贪心算法
    // 把13中基本组合列出，然后根据由大到小从这个列表中依次获取（贪心思想）
    public String intToRoman2(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        String str = so.intToRoman2(1994);
        System.out.println(str);
    }
}
