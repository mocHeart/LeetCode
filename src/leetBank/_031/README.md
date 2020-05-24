# [ 下一个排列 ][title]

## 描述
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。


**示例:**
```
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

```


**标签:**  数组


## 思路
解法： 二次扫描法
   尾部开始扫描，找出第一个比后一个小的数nums[i]
   再尾部开始扫描，找出第一个比数nums[i]大的数nums[j]
   最后倒序nums[i]后面的数即可

## 结语
   数学问题，多多积累
   
  [参考][reference]
     
[title]: https://leetcode-cn.com/problems/next-permutation/
[reference]: https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/