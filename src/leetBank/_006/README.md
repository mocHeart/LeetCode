# [最长回文子串][title]

## 描述
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    L   C   I   R
    E T O E S I I G
    E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
    string convert(string s, int numRows);

**示例:**
```
1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
```

**标签:** 字符串


## 思路
+ 解法： 
     寻找Z字形字符排列的规律，分析每行字符间隔出现的个数与行数的关系
     总结数学规律，依次计算出下个字符再原字符串中的位置
     对于 numRows = n ，z形排列有n行
     第一行是从第0个开始，索引加 (numRows - 1) * 2 (记为down1)依次取字符直到末尾
     第二行是从第1个开始，索引交替加 down1-2, 2 从原字符串中取字符直到末尾
     第三行是从第3个开始，索引交替加 down1-4, 4 从原字符串中取字符直到末尾
     ...
     第n-1行是从第n-1个开始，索引交替加 2, down1-2 从原字符串中取字符直到末尾
     第n行是从第n个开始，索引加 (numRows - 1) * 2 依次取字符直到末尾
  
     虽然程序中存在着两重循环，但每次循环都有着一个字符被记录，两重循环也只执行了n次
     时间复杂度:O(n)  空间复杂度:O(1)
    
## 结语
  从具体实例中总结规律，并强化练习加以实现，也要关心对特殊情况的处理。
  
[title]: https://leetcode-cn.com/problems/zigzag-conversion/
