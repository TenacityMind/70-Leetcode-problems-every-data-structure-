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

**Determine the Expected Sum:** If the array were complete, it would contain all integers from 0 to n (where n is nums.length). The sum of a sequence of numbers from 0 to n can be quickly calculated with the Gaussian sum formula: S_n= n(n+1)/2. This gives us the expectedSum.

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

### [ 3. Find All The Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)
### Problem 

Given an array nums of n integers where each element nums[i] is in the range [1, n], return a list of all the integers in the range [1, n] that do not appear in nums.

### Solution Explained

This solution uses a HashSet to easily keep track of which numbers are present in the input array.

**Store Present Numbers:** First, the code iterates through the input array nums and adds every number to a HashSet. A set is used because it automatically handles duplicates and provides very fast lookups (checking if an element exists).

**Find Missing Numbers:** After building the set of present numbers, the code starts a new loop that iterates through the complete range of numbers from 1 to n (where n is the length of the array).

**Collect Results:** In this second loop, it checks if each number i is in the HashSet. If presentNumbers.contains(i) returns false, it means the number i was missing from the original array, and it's added to the final result list.

### Complexity Analysis
**Time Complexity:** $O(N)$ The total time is linear with respect to the number of elements, N, in the array. This is because it takes O(N) time to build the set and another O(N) time to loop from 1 to N to check for missing numbers.

**Space Complexity:** $O(N)$ This solution requires extra space to store the HashSet. In the worst-case scenario (where all numbers in nums are unique), the set will store N elements, leading to a linear space requirement.

### [ 4. Two Sum](https://leetcode.com/problems/two-sum/description/)
### Problem:
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

### Solution Explained:

The core idea is that for each number x in the array, you're looking for a complement number y such that x + y = target. This means y = target - x.

By using a HashMap, you can check for this complement in constant time.

Initialize a HashMap: Create a HashMap to store (number, index) pairs.

Iterate Through the Array: Loop through the nums array one element at a time.

Check for a Solution: For each number nums[i]:

Calculate its required complement: complement = target - nums[i].

Check if the complement already exists as a key in the HashMap.

If it does, you've found the solution. Return the complement's index (which you get from the map) and the current number's index, i.

If it doesn't, add the current number nums[i] and its index i to the map. This stores it for future checks.

This one-pass approach is efficient because you're both checking for a solution and building up the map of potential complements at the same time.

### Complexity Analysis:
**Time Complexity:** $O(N)$ We iterate through the array of N elements only once. The HashMap lookups (containsKey) and insertions (put) take, on average, constant time (O(1)).

**Space Complexity:** $O(N)$ In the worst-case scenario, the HashMap could store up to N elements before the solution is found.