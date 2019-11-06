# [Longest Substring Without Repeating Characters][title]

## Description
Given a string, find the length of the longest substring without repeating characters.


**Example:**

```
Eg1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Eg2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Eg3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

```

**Tags:** String; Hash Table


## 思路
1. 有限字符记录值，不选择使用Map集合，而是考虑直接使用数组；
2. 滑动窗口(Sliding Window),操作左右两边的指针来控制条件。
```java
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    int leftIndex = 0;
    int len = 0;
    int lenMax = 0;
    boolean[] charSet = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!charSet[c]) {  // 不包含
            charSet[c] = true;
            len++;
        } else {
            while (s.charAt(leftIndex) != c) {
                charSet[s.charAt(leftIndex)] = false;
                leftIndex++;
                len--;
            }
            leftIndex++;
        }
        if (len > lenMax) {
            lenMax = len;
        }
    }
    return lenMax;
}
```

+ LeetCode Solution
采用int数组的方式，把每次当前遍历的这个字符的位置都记录下来，这样滑动窗口左指针，就不用循环排除啦。
Math.max() 函数的灵活使用。
```java
public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    int[] index = new int[128]; // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
        i = Math.max(index[s.charAt(j)], i);
        ans = Math.max(ans, j - i + 1);
        index[s.charAt(j)] = j + 1;
    }
    return ans;
}
```

+ Most Votes [from cbmbbz]
采用HashMap存储，思路一致。
```java
public int lengthOfLongestSubstring(String s) {
    if (s.length()==0) return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    for (int i=0, j=0; i<s.length(); ++i){
        if (map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
        }
        map.put(s.charAt(i),i);
        max = Math.max(max,i-j+1);
    }
    return max;
}
```

## 结语
重要思想：滑动窗口搜索方式，小集合的散列存储可以采用数组。


[title]: https://leetcode.com/problems/longest-substring-without-repeating-characters/