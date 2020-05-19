package leetBank._026;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int preValue = nums[0];
        int pre = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (preValue != nums[i]) {
                nums[pre] = nums[i];
                pre++;
                preValue = nums[i];
            }
        }
        return pre;
    }

    // 解法： 双指针法
    // 数组索引相当于指针
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];  // 一旦存在重复就有 i!=j
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int n = so.removeDuplicates2(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + "  ");
        }
    }
}
