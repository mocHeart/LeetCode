# [Two Sum][title]

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Tags:** Array, Hash Table


## 思路1
暴力解法，两轮for循环，找到满足条件的项就直接返回。复杂度O(n^2)
```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    throw new IllegalArgumentException("The parameter is invalid.");
}
```

## 思路2
散列表：空间换时间  复杂度O(n)
```java
public int[] twoSum2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{i, map.get(target - nums[i])};
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("The parameter is invalid.");
}
```

## Python

```python
def twoSum(self, nums, target) :
    if len(nums) < 1:
        return False
    buff_dict = {}
    for i in range(len(nums)):
        if nums[i] in buff_dict:
            return [buff_dict[nums[i]], i]
        else:
            buff_dict[target - nums[i]] = i

```


## 结语
重要思想：散列表做定向的存储。



[title]: https://leetcode.com/problems/two-sum/