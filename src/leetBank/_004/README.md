# [寻找两个有序数组的中位数][title]

## 描述
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
可以假设 nums1 和 nums2 不会同时为空。

**示例:**
```
1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0

2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
```

**标签:** 数组; 分治


## 思路
+ 解法1：
  合并数组，在根据新数组的个数的奇偶取得中位数
  时间复杂度:O(m+n)  空间复杂度:O(m+n)

+ 解法2：
  借鉴寻找第k小数的思想，找出中间位置的数，不必开辟空间存储数据
  时间复杂度:O(m+n)  空间复杂度:O(1)

+ 解法3：
  借寻找第k小数的思想，在有序数组中采用二分思想，加快查询速度
  时间复杂度:O(log(m+n))  空间复杂度:O(1)

+ 解法4：
  挖掘中位数的定义，采用二分思路在两数组间进行切分，充分考虑各种情况
  时间复杂度:O(log(min(m,n)))  空间复杂度:O(1)

## 结语
  要注意问题的转化和二分思想的应用，多多参考别人的代码，并勤加练习。
  
  [参考][reference]


[title]: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
[reference]: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/