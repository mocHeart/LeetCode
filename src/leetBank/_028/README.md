# [ 实现 strStr() ][title]

## 描述
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中
找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。


**示例:**
```
1:
输入: haystack = "hello", needle = "ll"
输出: 2

2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1

```

说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。
这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

**标签:**  字符串 & 双指针


## 思路
解法1： 逐个对比
    needle逐个字符比对，注意部分匹配时需要回溯
    时间复杂度:O(N*L)  空间复杂度:O(1)
    
解法2： 子串逐一对比
    沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较
    时间复杂度:O((N-L)*L)  空间复杂度:O(1)

解法3： 双指针
    结合解法1和解法2，在首字符匹配的情况下在进行子串的匹配
    时间复杂度:O((N-L)*L)  空间复杂度:O(N)

 解法4： Rabin Karp算法
     先生成窗口内子串的哈希码，然后再跟 needle 字符串的哈希码做比较
     时间复杂度:O((N)  空间复杂度:O(1)   
    
## 结语
   
   
  [参考][reference]
     
[title]: https://leetcode-cn.com/problems/implement-strstr/
[reference]: https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/