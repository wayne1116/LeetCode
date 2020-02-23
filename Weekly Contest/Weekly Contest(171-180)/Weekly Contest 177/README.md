## [Weekly Contest 177](https://leetcode.com/contest/weekly-contest-177)

### Number of Days Between Two Dates(Easy)
Write a program to count the number of days between two dates.

The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.

**Example1:**

    Input: date1 = "2019-06-29", date2 = "2019-06-30"
    Output: 1

**Example2:**

    Input: date1 = "2020-01-15", date2 = "2019-12-31"
    Output: 15

**Constraints:**

- The given dates are valid dates between the years 1971 and 2100.

---

### Validate Binary Tree Nodes(Medium)

You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

**Constraints:**

- 1 <= n <= 10^4
- leftChild.length == rightChild.length == n
- -1 <= leftChild[i], rightChild[i] <= n - 1

---

### Closest Divisors(Medium)

Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.

Return the two integers in any order.

**Example1:**

    Input: num = 8
    Output: [3,3]
    Explanation: For num+1=9, the closest divisors are 3 & 3, for num+2=10, 
    the closest divisors are 2 & 5, hence 3 & 3 is chosen.

**Example2:**

    Input: num = 123
    Output: [5,25]
    
**Example3:**

    Input: num = 999
    Output: [40,25]
    
**Constraints:**

- 1 <= num <= 10^9

---

### Largest Multiple of Three(Hard)

Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.

Since the answer may not fit in an integer data type, return the answer as a string.

If there is no answer return an empty string.

**Example1:**

    Input: digits=[8,6,7,1,0]
    Output: "8760"

**Example2:**

    Input: digits=[2,1,1,1]
    Output: "111"

**Example3:**

    Input: digits=[2,2,1,1,1]
    Output: "2211"
    
**Example4:**

    Input: digits=[1]
    Output: ""
    
**Example5:**

    Input: digits=[0,0,0,0,0,0]
    Output: "0"

**Constraints:**

- 1 <= digits.length <= 10^4
- 0 <= digits[i] <= 9
- The returning answer must not contain unnecessary leading zeros.
