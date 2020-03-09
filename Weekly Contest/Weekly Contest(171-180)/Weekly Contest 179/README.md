## [Weekly Contest 179](https://leetcode.com/contest/weekly-contest-179)

### Generate a String With Characters That Have Odd Counts (Easy)

    Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

    The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.  

**Example 1:**
    
    Input: n = 4
    Output: "bccc"

**Example 2:**

    Input: n = 2
    Output: "bc"

**Example 3:**
  
    Input: n = 7
    Output: "abcbcbc"

**Constraints:**

- 1 <= n <= 500

---

### Bulb Switcher III (Medium)

    There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.

    At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. 
    A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.

    Return the number of moments in which all turned on bulbs are blue.

**Example 1:**
    
    Input: light = [2,1,3,5,4]
    Output: 3
    Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.

**Example 2:**

    Input: light = [3,2,4,1,5]
    Output: 2
    Explanation: All bulbs turned on, are blue at the moment 3, and 4 (index-0).

**Example 3:**

    Input: light = [1,2,3,4,5,6]
    Output: 6

**Constraints:**
- n == light.length
- 1 <= n <= 5 * 10^4
- light is a permutation of  [1, 2, ..., n]
 
 ---
 
 ### Time Needed to Inform All Employees (Medium)
 
    A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.

    Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, 
    manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.

    The head of the company wants to inform all the employees of the company of an urgent piece of news.
    He will inform his direct subordinates and they will inform their subordinates and 
    so on until all employees know about the urgent news.

    The i-th employee needs informTime[i] minutes to inform all of his direct subordinates 
    (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).

    Return the number of minutes needed to inform all the employees about the urgent news.
 
 **Example 1:**

    Input: n = 1, headID = 0, manager = [-1], informTime = [0]
    Output: 0
    Explanation: The head of the company is the only employee in the company.

**Example 2:**

    Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
    Output: 1
    
**Example 3:**
    Input: n = 10, headID = 3, manager = [8,9,8,-1,7,1,2,0,3,0], informTime = [224,943,160,909,0,0,0,643,867,722]
    Output: 3665

**Constraints:*8

- 1 <= n <= 10^5
- 0 <= headID < n
- manager.length == n
- 0 <= manager[i] < n
- manager[headID] == -1
- informTime.length == n
- 0 <= informTime[i] <= 1000
- informTime[i] == 0 if employee i has no subordinates.
- It is guaranteed that all the employees can be informed.

---

### Frog Position After T Seconds (Hard)

    Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from the vertex 1. 
    In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. 
    The frog can not jump back to a visited vertex. In case the frog can jump to several vertices it jumps randomly to 
    one of them with the same probability, otherwise, when the frog can not jump to any unvisited vertex it jumps forever 
    on the same vertex. 

    The edges of the undirected tree are given in the array edges, 
    where edges[i] = [fromi, toi] means that exists an edge connecting directly the vertices fromi and toi.

    Return the probability that after t seconds the frog is on the vertex target.
