# [ 最长公共前缀 ][title]

## 描述
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

说明:
所有输入只包含小写字母 a-z 。

**示例:**
```
1:
输入: ["flower","flow","flight"]
输出: "fl"

2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

```


**标签:** 字符串


## 思路
+ 解法1：逐个比较
  首先将最短的字符串找出，再根据最短的子串，比对得到公共前缀
  
+ 解法2:  水平扫描
  从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符
  （即不同字符串相同下标的字符）然后再进行对下一列的比较

+ 解法3:  分治
  从头到尾挨个比较 lcpLeft 与 lcpRight 中的字符，直到不能再匹配为止

+ 解法4:  二分查找
  每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个
  
 
## 结语
   熟悉常见的解题思路。
    
  [参考][reference]
  
[title]: https://leetcode-cn.com/problems/longest-common-prefix/
[reference]: https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/