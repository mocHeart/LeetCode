# [ 正则表达式匹配 ][title]

## 描述
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
+ '.' 匹配任意单个字符
+ '*' 匹配零个或多个前面的那一个元素

所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
**说明**:
+ s 可能为空，且只包含从 a-z 的小写字母。
+ p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

**示例:**
```
1:
输入:  s = "aa"   p = "a"
输出:  false
解释: "a" 无法匹配 "aa" 整个字符串。

2:
输入:  s = "aa"   p = "a*"
输出:  true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。
因此，字符串 "aa" 可被视为 'a' 重复了一次。

3:
输入:  s = "ab"   p = ".*"
输出:  true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

4:
输入:  s = "aab"   p = "c*a*b"
输出:  true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。
因此可以匹配字符串 "aab"。

5:
输入:  s = "mississippi"   p = "mis*is*p*."
输出:  false

```


**标签:** 字符串 & 动态规划 & 回溯算法


## 思路
+ 解法1： 回溯法
    每次都对一个字符进行匹配，同时考虑下一个字符是否为*,再回溯(递归)
    
+ 解法2： 
    该问题存在最优子结构，可将中间结构存储
    采用 dp(i, j) 表示 s[i:] 和 p[j:] 是否匹配
 
## 结语
    动态规划是难点，要发现问题中的重复子问题，在考虑如何重复利用存在的中间结果


[参考][reference]
  
[title]: https://leetcode-cn.com/problems/regular-expression-matching/
[reference]: https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/