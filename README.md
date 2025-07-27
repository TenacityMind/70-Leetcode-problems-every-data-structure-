## [YT Video Reference](https://www.youtube.com/watch?v=lvO88XxNAzs)
# 70 Leetcode problems with every data structure

## Arrays

### [1. Contains Duplicate (Problem 217):](https://leetcode.com/problems/contains-duplicate/description/)
### Problem: 
Given an integer array **nums**, the goal is to determine if any value appears at least twice. The function should return **true** if a duplicate exists, and **false** if every element is distinct.

### Solution Explained

This approach uses a HashSet to efficiently keep track of the numbers encountered while iterating through the input array. A HashSet is an ideal choice here because it only stores unique values and provides very fast (average O(1) time) lookups.

### The logic works as follows:

**Initialize a Set:** An empty HashSet<Integer> called set is created. This set will store the unique numbers we've seen so far.

**Iterate and Check:** The code loops through each num in the input array nums. Inside the loop, set.contains(num) checks if the current number is already in our set. If set.contains(num) is true, it means we have seen this number before. We have found a duplicate, so the function immediately returns true and stops executing.

**Store Unique Numbers:** If the number is not a duplicate (i.e., set.contains(num) was false), it gets added to the set via set.add(num). This ensures we can check for it in future iterations.

**No Duplicates Found:** If the loop finishes without ever finding a duplicate, it means every element in the array was unique. In this case, the function returns false.

### Complexity Analysis

**Time Complexity: O(N)**
    The code iterates through the array of N elements once. Both set.contains() and set.add() operations take, on average, constant time (O(1)). Therefore, the total time complexity is linear.

**Space Complexity: O(N)**
    In the worst-case scenario where all elements in the array are unique, the HashSet will grow to a size of N. Therefore, the space required is proportional to the number of elements in the input array.