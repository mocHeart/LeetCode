package leetBank._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 解法1： 定2双指指针
    // 和之前三数之和类似，固定两个数，再将两个指针分别指向剩余数字的首尾，具体步骤类似
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {  // 不需检测相等
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int res = nums[i] + nums[j] + nums[left] + nums[right];
                    if (res == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left + 1 < right && nums[left] == nums[left + 1])
                            left++;
                        while (right - 1 > left && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (res < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return lists;
    }

    // 解法1优化： 增加判断，进行修枝
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;

        // 定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值
        for (int k = 0; k < length - 3; k++) {
            // 当k的值与前面的值相等时忽略
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            // 第二层循环i，初始值指向k+1
            for (int i = k + 1; i < length - 2; i++) {
                // 当i的值与前面的值相等时忽略
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 定义指针j指向i+1
                int j = i + 1;
                // 定义指针h指向数组末尾
                int h = length - 1;
                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                // 开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，
                // 当当前和大于目标值时h--，当当前和小于目标值时j++
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        List<List<Integer>> lists = so.fourSum(new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
