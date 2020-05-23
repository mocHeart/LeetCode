# [ 串联所有单词的子串 ][title]

## 描述
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。


**示例:**
```
1:
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

2:
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

```


**标签:**  哈希表 & 双指针 & 字符串


## 思路
解法1： 哈希表
   单词长度固定，将单词放在一个哈希表中，截取字符串也放在哈希表，比较他们是否相等
   
解法2： 滑动窗口 （哈希表 + 双指针）
   采用左右指针指向子串的截取的始末，每次增加都有单词长度为基数

## 结语
   熟悉哈希表的用法。
   
  [参考][reference]
     
[title]: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
[reference]: https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-powcai/