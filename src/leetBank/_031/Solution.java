package leetBank._031;

public class Solution {
    // 解法： 二次扫描法
    // 尾部开始扫描，找出第一个比后一个小的数nums[i]
    // 再尾部开始扫描，找出第一个比数nums[i]大的数nums[j]
    // 最后倒序nums[i]后面的数即可
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {1, 3, 2};
        so.nextPermutation(nums);
        for (int i : nums)
            System.out.print(i + " ");
    }
}
