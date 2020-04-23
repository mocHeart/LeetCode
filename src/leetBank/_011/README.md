# [ 盛最多水的容器 ][title]

## 描述
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

**示例:**
```
1:
输入：[1,8,6,2,5,4,8,3,7]
输出：49

```


**标签:** 数组 & 双指针


## 思路
+ 解法1： BF法
    计算出每个有效范围的值，取出最大的
    时间复杂度:O(N^2)  空间复杂度:O(1)
    
+ 解法2： 双指针
    将两个指针指向数组的两端，以后每次数字较小的那个指针向中间移动直到两指针重叠
    在上述过程中，最大的一次即为可容纳的最大水量
    时间复杂度:O(N)  空间复杂度:O(1)
 
## 结语
    弄懂可以这样求解的原因。


[参考][reference]
  
[title]: https://leetcode-cn.com/problems/container-with-most-water/
[reference]: https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/