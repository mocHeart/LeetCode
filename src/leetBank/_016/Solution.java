package leetBank._016;

import java.util.Arrays;

public class Solution {
    // 解法：定1双指针
    // 思路和上一题一致，通过固定一个数，然后使用两个指针指向两端向里搜索
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        int resDiff = target - res;
        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target - sum;
                if (diff == 0)
                    return target;
                if (Math.abs(diff) < Math.abs(resDiff)) {
                    res = sum;
                    resDiff = diff;
                }
                if (diff > 0)
                    left++;
                else
                    right--;
            }
        }
        return res;
    }

    // 优化 -- 学习别人的编码
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
