## [Weekly Contest 178](https://leetcode.com/contest/weekly-contest-178)

### How Many Numbers Are Smaller Than the Current Number(Easy)

    Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
    That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

    Return the answer in an array.

**Example 1:**

    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    Explanation: 
                For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
                For nums[1]=1 does not exist any smaller number than it.
                For nums[2]=2 there exist one smaller number than it (1). 
                For nums[3]=2 there exist one smaller number than it (1). 
                For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
    
**Example 2:**

    Input: nums = [7,7,7,7]
    Output: [0,0,0,0]
 
**Constraints:**

- 2 <= nums.length <= 500
- 0 <= nums[i] <= 100

---

### Rank Teams by Votes(Medium)

    In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.

    The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, 
    we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. 
    If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

    Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the 
    ranking system described above.

    Return a string of all teams sorted by the ranking system.

**Example 1:**

    Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
    Output: "ACB"
    Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
                 Team B was ranked second by 2 voters and was ranked third by 3 voters.
                 Team C was ranked second by 3 voters and was ranked third by 2 voters.
                 As most of the voters ranked C second, team C is the second team and team B is the third.

**Example 2:**

    Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
    Output: "ABC"
    Explanation: 
                 Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
                 Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
                 Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
                 There is a tie and we rank teams ascending by their IDs.
                 
---

### Linked List in Binary Tree(Medium)

---

### Minimum Cost to Make at Least One Valid Path in a Grid(Hard)
