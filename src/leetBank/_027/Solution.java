package leetBank._027;

public class Solution {
    // 解法1： 双指针
    // 快慢指针，快指针每次迭代移动，慢指针满足要求在移动
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    // 解法2： 双指针 -- 删除少
    // 遇到一个重复的数值，将最后一个未判断的数放在此位置继续判断 （赋值更少）
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int n = so.removeElement(nums, 2);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
