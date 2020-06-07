# [ 最长有效括号 ][title]

## 描述
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。


**示例:**
```
1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

```

**标签:**  数组


## 思路
解法1: BF
  逐个考虑所有的非空偶数长度字符串
  栈 -- 判断字符串是否有效
  时间复杂度: O(n^2)  空间复杂度: O(n)
  
解法2: 动态规划
  存储定义：  dp[i]  ==>  第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度
  形如： ...(  ==>  dp[i] = 0
  形如： ...()  ==>  dp[i] = dp[i-2] + 2
  形如： ...)) 且 倒数第二个 ) 有效 且 和最后一个 ) 匹配的为 ( ==> dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
  时间复杂度: O(n)  空间复杂度: O(n)
  
解法3: 栈
  栈的自回溯特性
  初始 ==>  -1 入栈
 （  ==>   对应下标入栈
  )  ==>  出栈后，当前下标 - 栈顶下标 为当前最大有效括号长度
  时间复杂度: O(n)  空间复杂度: O(n)

解法4： 两次扫描，无需额外空间
  由左至有右扫描：
  计数器 left = right = 0
  (  ==>  left++ 或  )  ==>  right++
  left == right ==> 当前最大有效括号长度为 2*right
  right > left  ==> 无效，left = right = 0
  由左至有右扫描：方法一样
  原因： (() 会扫描不到
  时间复杂度: O(n)  空间复杂度: O(1)

## 结语
  典型的一道题，多加练习。
   
  [参考][reference]
     
[title]: https://leetcode-cn.com/problems/longest-valid-parentheses/
[reference]: https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/