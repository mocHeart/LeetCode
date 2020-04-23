package leetBank._011;

public class Solution {
    // 解法1： BF法
    // 计算出每个有效范围的值，取出最大的
    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2)
            return 0;

        int max = 0;
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = (j - i) * Math.min(height[i], height[j]);
                if (max < temp)
                    max = temp;
            }
        }
        return max;
    }

    // 解法2：双指针
    // 将两个指针指向数组的两端，以后每次数字较小的那个指针向中间移动直到两指针重叠
    // 在上述过程中，最大的一次即为可容纳的最大水量
    public int maxArea2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return ans;
    }

        public static void main(String[] args) {
        Solution so = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(so.maxArea2(height));
    }
}
