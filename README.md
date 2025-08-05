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

### [5. How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/)
### Problem:
Imagine you're given a list of numbers. Your goal is to create a new list of the exact same size.

For every number in the original list, you need to look through the entire list and count how many of the other numbers are smaller than it. The result of that count will be the new value at that same position.

### Solution Explained:
This method provides a significant improvement over the brute-force approach. The core idea is to sort a copy of the array. Once sorted, the index of a number tells you how many elements are smaller than or equal to it. We use a HashMap to efficiently store this information and handle duplicates.

**Create a Copy and Sort:** First, we create a copy of the original nums array. We need the original order for our final result, so we must sort the copy, not the input array itself.

**Map Numbers to Counts:** We create a HashMap to store each unique number and its corresponding count of smaller numbers. We iterate through the sorted array. The index i of a number in the sorted array is the count of how many numbers are smaller than it.

For example, in the sorted array [1, 2, 2, 3, 8]:

The first number is 1 at index 0, so 0 numbers are smaller than it.

The first 2 is at index 1, so 1 number is smaller than it.

The number 3 is at index 3, so 3 numbers are smaller than it.

We only put a number into the map the first time we see it. This correctly handles duplicates, ensuring that all instances of 2 are mapped to a count of 1 (the index of the first 2).

**Build the Final Result:** Finally, we iterate through the original nums array. For each number, we look up its pre-calculated count in our map and place it in the corresponding position in our result array.

### Complexity Analysis:
**Time Complexity:** $O(N \log N)$
The dominant operation is sorting the array, which takes $O(N \log N)$ time. Copying the array, building the map, and creating the final result array are all linear, $O(N), operations.

**Space Complexity:** $O(N)$
We use extra space for the copy of the array ($O(N)$) and for the HashMap, which in the worst case (all unique elements) will also store N entries ($O(N)).

### [6. Minimum Time Visiting All Points](https://leetcode.com/problems/minimum-time-visiting-all-points/description/)
### Problem:
On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

### Solution Explained:
This solution calculates the total travel time by breaking the journey down into smaller segments, moving from one point to the next in the specified order. It cleverly maintains the location of the "previous" point to calculate the time for each step.

**Initialization:** The code starts by initializing the total time (minTime) to 0 and setting the starting coordinates (x1, y1) to the very first point in the list (points[0]).

**Iterating Through Segments:** It then iterates through the rest of the points, from the second point (i = 1) to the end. In each step of the loop, it treats (x1, y1) as the starting point and points[i] as the destination for that segment.

**Calculating Segment Time:** As your own comments correctly derive, the minimum time to travel between any two points is the Chebyshev distance. This is the greater of the horizontal distance (dx) and the vertical distance (dy). The line minTime += Math.max( Math.abs( x2-x1 ), Math.abs( y2-y1 ) ); efficiently calculates this time and adds it to the running total.

**Updating State:** After calculating the time to get to the current point (x2, y2), the code updates the "previous" point by setting x1=x2 and y1=y2. This prepares for the next iteration, where the current point will become the starting point for the next segment.

This process continues until all segments have been traveled, resulting in the total minimum time.

### Complexity Analysis:
**Time Complexity:** $O(N)$
The algorithm involves a single for loop that iterates through the N points of the input array once. All operations inside the loop (subtraction, absolute value, finding the maximum, and addition) are constant-time operations. Therefore, the runtime grows linearly with the number of points.

**Space Complexity:** $O(1)$
The solution uses only a few variables (minTime, x1, y1, x2, y2, i) to store the state. The amount of memory used does not increase as the size of the input points array grows. This makes the space complexity constant.