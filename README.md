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

### [7. Spiral Matirx](https://leetcode.com/problems/spiral-matrix/description/)
### Problem:
Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [ [1,2,3],[4,5,6],[7,8,9] ]
Output: [1,2,3,6,9,8,7,4,5]

### Solution Explained:

code solves the problem by simulating a spiral traversal of the matrix. It "peels" the matrix layer by layer from the outside in, using four pointers to keep track of the boundaries of the current layer.

**Initialization:** top, bottom, left, right: You initialize four integer variables to define the boundaries of the matrix. top and left start at 0, while bottom and right start at the last row and column indices, respectively.

**result:** An ArrayList is created to store the numbers in their spiral order.

**Main Traversal Loop:** The while(top <= bottom && left <= right) loop is the core of the algorithm. It ensures that the process continues as long as there is a valid layer to traverse (i.e., the top boundary is not below the bottom, and the left is not past the right).

**The Four Traversal Steps:** Inside the while loop, one full spiral layer is traversed in four distinct steps:

* Step 1 (Go Right): The first for loop iterates from left to right along the top row, adding each element to the result list. Afterward, top is incremented, effectively moving the top boundary down.
* Step 2 (Go Down): The second for loop traverses down the right column from the new top to bottom. Afterward, right is decremented, shrinking the boundary inward.
* Step 3 (Go Left): Before traversing left, the crucial if (top <= bottom) check ensures there's still a valid row to traverse. This prevents errors on "thin" matrices (e.g., a single column). If valid, it traverses from right to left along the bottom row, and then bottom is decremented.
* Step 4 (Go Up): Similarly, the if (left <= right) check ensures a valid column exists before traversing up the left column. If valid, it traverses from bottom to top, and then left is incremented.
This cycle repeats, with the boundaries shrinking inward, until the while loop condition is no longer met, at which point every element has been visited.

### Complexity Analysis:
Time Complexity: $O(M \times N)$
This is because the algorithm visits each element in the M x N matrix exactly once. The nested loops might look complex, but they systematically process every cell without repetition.

Space Complexity: $O(1)
The space required by the algorithm itself is constant. The variables top, bottom, left, right, and the loop counters do not depend on the size of the input matrix.

(Note: If you consider the space required for the output result list, the space complexity would be $O(M \times N)$, as it needs to store all the elements from the matrix. However, in complexity analysis, the space for the output is often excluded from the calculation.)

### [8. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)
### Problem:
Given an `m x n` 2D binary grid, `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

### Solutions Explained:
### Solution 1: Depth-First Search (DFS)

The Depth-First Search strategy explores an island by going as deep as possible down one path before backtracking.

#### How It Works

**1. Main Loop:** The code iterates through every cell of the grid.

**2. Island Discovery:** If it finds a land cell ('1') that has not been previously visited, it knows it has found a new, distinct island. It increments the islandCount.

**3. Recursive Exploration:** It then calls a recursive dfs helper function starting from that cell.

* The dfs function first marks the current cell as visited.

* It then calls itself for all four of its neighbors (up, down, left, right).

* The recursion stops for a given path if it goes out of bounds, hits water, or reaches a cell that has already been visited.

**4. Completion:** This recursive process continues until every connected part of the newly discovered island has been marked as visited. The main loop then continues its scan, ignoring the now-visited cells, until it finds the next unvisited island.

### Solution 2: Breadth-First Search (BFS)

The Breadth-First Search strategy explores an island layer by layer, visiting all of a cell's immediate neighbors before moving on to the next level.

#### How It Works

**1. Main Loop:** The main loop is identical to the one in the DFS approach. It scans for an unvisited land cell ('1') and increments the islandCount upon finding one.

**2. Queue-Based Exploration:** Instead of using recursion, BFS uses a Queue data structure to manage the exploration.

* When a new island is discovered, its starting cell is added to the queue and immediately marked as visited.

* A while loop runs as long as the queue is not empty.

* Inside the loop, a cell is removed from the front of the queue. Its valid, unvisited land neighbors are then marked as visited and added to the back of the queue.

**3. Completion:** The while loop finishes once the queue is empty, which means every connected cell in the island has been visited. The main loop then continues its scan.

### Time and Space Complexity Analysis

For this problem, the complexity is the same for both the DFS and BFS solutions.

**Time Complexity:** $O(M \times N)$ 
Where M is the number of rows and N is the number of columns. This is because, in the worst-case scenario, every cell in the grid is visited exactly once by the main loop and then checked a constant number of times during the traversal process (DFS or BFS).

**Space Complexity:** $O(M \times N)$
This is dominated by the boolean[][] visited array, which requires space proportional to the size of the grid. In addition:

* DFS uses the call stack for recursion, which in the worst case (a long, snake-like island) could also be $O(M \times N)$.

* BFS uses a Queue, which in the worst case (a very wide island) could hold up to O(min(M,N)) elements.

* However, since the visited array is always required in this non-destructive approach, the overall space complexity is considered $O(M \times N)$.

## Arrays : Two Pointers

### [9. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

### Problem:
You are given an array `prices` where `prices[i]` is the price of a given stock on the `i^th` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day** in the future to sell that stock.

Return the _maximum profit_ you can achieve from this transaction. If you cannot achieve any profit, return `0`

### Solution Explained:

This algorithm efficiently finds the maximum profit in a single pass using a greedy, two-pointer approach. The strategy is to always make the locally optimal choice at each step, hoping it leads to the globally optimal solution.

**Initialization:**

* A left pointer is set to day 0, representing our initial "buy" day.

* A right pointer is set to day 1 to explore subsequent "sell" days.

* maxProfit is initialized to 0.

**Greedy Choice:**
The algorithm iterates with the right pointer. At each day, it makes a greedy choice:

* **Is it profitable now?** (`prices[right] > prices[left]`)

    If the current price is higher than our buy price, the locally optimal move is to see if this transaction yields the best profit so far. We calculate the profit and update `maxProfit` if necessary.


* **Is there a better buy price?** (`prices[right] <= prices[left]`)

  If the current price is lower than our buy price, it's impossible for our old buy day to ever be part of a better future profit. The greedy choice is to immediately abandon the old buy day and update our buy day to this new, lower price (`left = right`). We greedily take the lowest price we can get for a buy day, as this gives us the maximum potential for future profit.

By always keeping the `left` pointer at the lowest price seen so far, we ensure that any profit we calculate is always the maximum possible profit for that specific sell day.

### Complexity Analysis

* **Time Complexity:** $O(N)$
    The algorithm is greedy because it makes its decision based on the current best information without looking ahead or behind. Since the right pointer visits each element only once, the time complexity is linear.


* **Space Complexity:** $O(1)$
    The solution only uses a few constant variables (left, right, maxProfit). The memory usage does not grow with the size of the input array.

### [10. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/description/)

### Problem:
Given an integer array `nums` sorted in **non-decreasing** order, return an _array of the **squares of each number** sorted in non-decreasing order._

### Solution Explained 
### Approach 1: Two Pointers from the Ends (Optimal Solution)

The core insight is that after squaring, the **largest** values will always come from the numbers with the largest absolute values, which are at the **ends** of the sorted input array.

* **Initialize Pointers:** The algorithm sets up two pointers: `left` at the beginning of the array and `right` at the end. It also creates a `result` array of the same size.

* **Compare and Place:** It compares the square of the number at the `left` pointer with the square of the number at the `right` pointer.

* **Fill from the End:** Whichever square is larger is placed at the end of the `result` array. The corresponding pointer (`left` or `right`) is then moved inward.

* **Repeat:** This process repeats, filling the `result` array from right to left with progressively smaller squares until the pointers cross.

### Complexity Analysis

**Time Complexity:** $O(N)$
    The algorithm makes a single pass through the array as the `left` and `right` pointers move towards each other. This makes the runtime linear with respect to the size of the input array.

**Space Complexity:** $O(1)
    This solution is very memory-efficient. It only uses a few variables for the pointers, so the extra space is constant. (This excludes the `result` array, which is required for the output).

### Approach 2: Split, Square, and Merge (Commented-out Code)

This method manually separates the negative and positive numbers, squares them, and then merges them back together.

1. **Find Pivot:** It first finds the index of the first non-negative number, which acts as a "pivot" to split the array.

2. **Create Temporary Arrays:** It creates two new arrays:

   a: Stores the squares of the negative numbers. They are added in reverse to make this array sorted.

   b: Stores the squares of the non-negative numbers, which are already in sorted order.

3. **Merge:** It then performs a classic "merge" step, similar to merge sort. It iterates through both temporary arrays (a and b), picking the smaller element from the front of either array to place into the final result array.

### Complexity Analysis

**Time Complexity:** $O(N)$
    Although there are multiple loops, none are nested. Finding the pivot is $O(N)$, creating the two arrays is $O(N)$, and merging them is also $O(N). Therefore, the total time complexity is still linear.

**Space Complexity:** $O(N)$
    This is the main drawback. This approach requires creating two temporary arrays (a and b) whose combined size is equal to the original array. This leads to a linear space requirement, making it less memory-efficient than the two-pointer approach.

### [ 11. 3 Sum](https://leetcode.com/problems/3sum/description/)
### Problem:
Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

### Solution Explained:
The strategy is to iterate through the array with one pointer `(i)` and, for each element `nums[i]`, use two more pointers (`left` and `right`) to find two other numbers that sum up to `-nums[i]`.

1. Sort the Input Array: First, sort the `nums` array. This is essential. It makes finding pairs much faster and helps us handle duplicate triplets easily.

2. Iterate with the First Pointer: Loop through the sorted array with a pointer `i` from the beginning up to the third-to-last element. This `nums[i]` will be the first number in our potential triplet.

   * Skip Duplicates: To avoid duplicate triplets (like `[-1, 0, 1]` appearing twice), we add a check. If the current number `nums[i]` is the same as the previous one `nums[i-1]`, we skip it and continue to the next iteration.

3. Two-Pointer Scan: For each `nums[i]`, we set up two more pointers:

   * `left` starts right after `i` (at `i + 1`).

   * `right` starts at the very end of the array.

   * We then loop as long as `left < right`, looking for two numbers that, when added to `nums[i]`, equal zero.

4. Check the Sum: Inside this inner loop, we calculate `sum = nums[i] + nums[left] + nums[right]`.

   * If `sum == 0`: We've found a valid triplet! We add `[nums[i], nums[left], nums[right]]` to our result list. Then, we must move our pointers past any duplicates of the current `left` and `right` values to avoid adding the same triplet again. Finally, we move `left` forward and `right` backward to look for new pairs.

   * If `sum < 0`: The sum is too small, so we need a larger number. We move the `left` pointer to the right (`left++`).

   * If `sum > 0`: The sum is too large, so we need a smaller number. We move the `right` pointer to the left (`right--`).

This process continues until the main loop is finished.

### Complexity Analysis:
**Time Complexity:** $O(N^2)$
The algorithm's performance is dominated by its nested loop structure. After an initial sort of the array which takes $O(N \log N)$, the main for loop runs $O(N)$ times. For each iteration, the inner while loop with two pointers scans the rest of the array in $O(N)$ time. This results in a total time complexity of $O(N^2)$.

Space Complexity: $O(\log N)$
The space required does not depend on the input size, excluding the list for the final answer. The sorting algorithm in Java uses a Quicksort variation that requires $O(\log N)$ stack space for the recursion. The main algorithm itself only uses a few pointers, which is considered constant space ($O(1)$).

### [12. Longest Mountain in Array](https://leetcode.com/problems/longest-mountain-in-array/description/)
### Problem:
You may recall that an array `arr` is a mountain array if and only if:
* `arr.length >= 3`

There exists some index i (0-indexed) with `0 < i < arr.length - 1` such that:
* `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
* `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`

Given an integer array `arr`, return the length of the longest subarray, which is a mountain. Return `0` if there is no mountain subarray.

### Solution Explained:
This Solution uses a **"Find Peak and Expand"** strategy. It iterates through the array to identify every potential peak and then expands outwards from each one to measure the length of the mountain.

**Find a Peak:** The main `for` loop iterates through the array from the second element to the second-to-last element. The `if` statement `if(arr[i] > arr[i-1] && arr[i] > arr[i+1])` correctly identifies if the current element `arr[i]` is a peak (i.e., it's strictly greater than both of its neighbors).

**Expand Outwards:** Once a peak is found at index `i`, the code uses two `while` loops to find the full extent of the mountain:

* Expand Left: A `left` pointer, starting at the peak, moves backwards `(left--)` as long as it's part of an uphill slope `(arr[left] > arr[left-1])`. This finds the start of the mountain.

* Expand Right: A `right` pointer, also starting at the peak, moves forwards (right++) as long as it's part of a downhill slope `(arr[right] > arr[right+1])`. This finds the end of the mountain.

**Calculate and Update Max Length:** After finding the start (`left`) and end (`right`) of the mountain, the total length is calculated as `right - left + 1`. The code then updates the result with this length if it's the longest one found so far using `Math.max(result, ...)`.

**The Key Optimization - Skip Ahead:** The most clever part of your refined solution is the line `i = right;`.

* After a mountain has been fully measured, you already know that the elements on its downhill slope cannot be new peaks.

* By setting the main loop's counter `i` equal to `right`, you jump the search forward to the end of the mountain you just found.

* This ensures that each element in the array is processed only once, turning the algorithm into a highly efficient single-pass solution.

This process repeats for every possible peak in the array, ensuring the longest mountain is always found.

### Complexity Analysis:
**Time Complexity:** $O(N)$
Although you have `while` loops inside a `for` loop, the time complexity is still linear. This is because each element of the array is visited a constant number of times. The main pointer i visits each element once, and the `left` and `right` pointers also scan over each element at most once across all iterations. Therefore, the total work is proportional to the size of the array, `N`.

**Space Complexity:** $O(1)$
Your solution is very memory-efficient. It only uses a few variables (`result, i, left, right`) to store pointers and the maximum length. The amount of memory used does not grow with the size of the input array, so the space complexity is constant.

## Arrays : Sliding Window

### [13. Contains Duplicate](https://leetcode.com/problems/contains-duplicate-ii/description/)

### Problem 
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.

### Solution Explained
This solution uses a `HashSet` to maintain a **"sliding window"** of the most recent unique elements. This window is never larger than size `k`, which allows the algorithm to efficiently check for duplicates within the required distance.

**Initialize a HashSet:** The algorithm creates a `HashSet`, which will act as our sliding window. A `HashSet` is used because it only stores unique items and can check for an element's existence in constant time.

**Iterate and Check:** The code iterates through the `nums` array one element at a time. For each number, it tries to add it to the `HashSet`.

* **Find a Duplicate in the Window:** The `.add()` method of a `HashSet` returns `false` if the element already exists in the set. If this happens, it means we have found a duplicate of the current number within our window. Since the window's size is controlled to be no more than `k`, this duplicate is guaranteed to be nearby, so the function immediately returns `true`.

* **Maintain the Window:** After processing each element, the code ensures the window doesn't get too large. If the size of the `HashSet` exceeds `k`, the oldest element in the window `(nums[i - k])`is removed. This action effectively "slides" the window one position to the right, maintaining a constant size and ensuring it only contains recent elements.

If the loop completes without ever finding a duplicate within the sliding window, it means no nearby duplicate exists, and the function returns `false`.

### Complexity Analysis:
**Time Complexity:** `$O(N)$`

The algorithm iterates through the array of size `N` exactly once. The operations performed inside the loop—`add` and `remove` on the `HashSet`—both take constant `$O(1)$` time on average. This results in a linear time complexity.

**Space Complexity:** `$O(min(N, k))$`

The space is determined by the size of the `HashSet`. The set stores the elements within the "sliding window," which never contains more than `k` elements. If the total number of elements `N` is less than `k`, the set will only store up to `N` elements. Therefore, the space required is proportional to the smaller of the two values, `N` and `k`.

### [14. Minimum Absolute Difference](https://leetcode.com/problems/minimum-absolute-difference/description/)
### Problem:
Given an array of distinct integers `arr`, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair `[a, b]` follows

* `a, b` are from `arr`
* `a < b`
* `b - a` equals to the minimum absolute difference of any two elements in `arr`

### Solution Explained:
Your solution uses an efficient, two-pass approach that hinges on one key insight: after an array is sorted, the minimum difference between any two numbers will always be between adjacent elements.

**Sort the Array:** The first and most crucial step is `Arrays.sort(arr)`. This operation arranges the numbers in non-decreasing order, which guarantees that elements with the smallest possible differences are now next to each other. This avoids the need to compare every number with every other number.

**First Pass (Find the Minimum Difference):** The code then iterates through the sorted array once. Its only goal during this pass is to find the single smallest difference between any adjacent pair. It does this by comparing the difference of each pair `(arr[i+1] - arr[i])` to the `minDifference` found so far and updating it whenever a smaller one is found.

**Second Pass (Collect the Pairs):** Now that the smallest possible difference is known, the code iterates through the sorted array a second time. In this pass, it checks the difference of each adjacent pair again. If a pair's difference is exactly equal to the `minDifference`, that pair is added to the final result list.

### Complexity Analysis:

**Time Complexity:** $O(N \log N)$ 
The performance of the algorithm is dominated by the initial sorting step, which takes $O(N \log N)$ time. The two subsequent passes through the array are both linear ($O(N)$), which is less significant. Therefore, the overall time complexity is $O(N \log N)$.

**Space Complexity:** $O(\log N)$ or $O(1)$
The space complexity is determined by the sorting algorithm. Java's `Arrays.sort()`for primitives is a variation of Quicksort that requires $O(\log N)$ stack space. Excluding the space for the output list and the sorting implementation, the algorithm itself only uses a few variables, which is constant $O(1) space.

### [14. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
### Problem:
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray, return `0` instead.

### Solution Explained:
**Initialize Pointers and Sum:** We start with both a `left` and `right` pointer at the beginning of the array (`index 0`). We also initialize a `currentSum` to `0` and a `minLength` to a very large value (like `Integer.MAX_VALUE`).

**Expand the Window:** We iterate through the array with the `right` pointer, adding each new element to our `currentSum`. This expands our window to the right.

**Shrink the Window:** As soon as our `currentSum` becomes greater than or equal to the `target`, we've found a valid subarray. Now, we try to find the smallest possible valid subarray by shrinking the window from the left.

* We record the current window's length (`right - left + 1`) if it's smaller than our `minLength` so far.

* We then subtract the element at the `left` pointer from `currentSum` and move the `left` pointer one step to the right.

* We repeat this shrinking process until `currentSum` is no longer greater than or equal to the `target`.

**Continue:** The `right` pointer continues moving to the right, and the process of expanding and shrinking repeats until we've checked the entire array.

**Final Result:** If `minLength` was never updated, it means no valid subarray was found, so we return `0`. Otherwise, we return the `minLength` we found.

### Complexity Analysis:
**Time Complexity:** $O(N)$
Although there is a nested `while` loop, the algorithm is linear. Each element is visited at most twice—once by the `right` pointer and once by the `left` pointer.

**Space Complexity:** $O(1)$
The solution only uses a few variables to store the pointers and sums, so the space required is constant.