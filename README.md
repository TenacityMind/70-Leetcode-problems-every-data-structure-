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
### [2. Missing Number](https://leetcode.com/problems/missing-number/)
### Problem :
Given an array **nums** containing n distinct numbers in the range **[0, n]**, return the only _number_ in the range that is missing from the array.
### Solution Explained
The solution is based on a classic mathematical trick. Since the input array contains n distinct numbers taken from the range [0, n], exactly one number is missing.

**Determine the Expected Sum:** If the array were complete, it would contain all integers from 0 to n (where n is nums.length). The sum of a sequence of numbers from 0 to n can be quickly calculated with the Gaussian sum formula: S_n=fracn(n+1)2. This gives us the expectedSum.

**Calculate the Actual Sum:** The code then iterates through the input array nums one time to calculate the actualSum of all the elements it contains.

**Find the Missing Number:** The difference between the expectedSum and the actualSum is precisely the number that is missing from the sequence. The function returns this difference.

For example, with nums = [3, 0, 1]:

n is 3.

Expected Sum = (3 * (3 + 1)) / 2 = (3 * 4) / 2 = 6. (The sum of 0+1+2+3)

Actual Sum = 3 + 0 + 1 = 4.

Missing Number = 6 - 4 = 2.
### Complexity Analysis

**Time Complexity: $O(N)$**
This is because we iterate through the input array of N elements exactly once to calculate the actualSum. The calculation for expectedSum is a constant time, O(1), operation.

**Space Complexity: $O(1)$**
The algorithm only uses a few variables (n, expectedSum, actualSum) to store intermediate values. The amount of memory used does not increase with the size of the input array, making the space complexity constant.