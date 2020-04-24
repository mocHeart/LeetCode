# [ 回文数 ][title]

## 描述
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

**示例:**
```
1:
输入: 121
输出: true

2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

```

+ 进阶
你能不将整数转为字符串来解决这个问题吗？
    可以

**标签:** 数学


## 思路
+ 解法1： 转为字符串
    将整数转化为字符串，逆序后进行比较
    
+ 解法2： 反转一半数字
    数字的后半部分进行反转再与前半部分比较
    如何得知已经进行了一半：原数字/10(依次) < 反转数字*10(依次) ==> 已处理一半
  
## 结语
    注意从不的思路思考，找出优化解。
  
[title]: https://leetcode-cn.com/problems/palindrome-number/