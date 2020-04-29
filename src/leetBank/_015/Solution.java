package leetBank._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 解法： 定1再双指针
    // 先排序，便于处理重复的组合，再定一个数，剩下两个数有两个指针分别指向两端的最大和最小值
    // 两指针指向数的和如果等于零，指针都向里移动，注意重复数字的处理
    // 如果大于0，移动右侧的指针，如果小于0，移动左侧的指针，直到两指针相遇
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left + 1 < right && nums[left] == nums[left + 1])
                        left++;
                    while (right - 1 > left && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = so.threeSum(nums);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }
}
