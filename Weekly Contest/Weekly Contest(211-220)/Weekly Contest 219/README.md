### [Weekly Contest 219](https://leetcode.com/contest/weekly-contest-219)

- Count of Matches in Tournament(Easy)

- Partitioning Into Minimum Number Of Deci-Binary Numbers(Medium)

- Stone Game VII(Medium)

- Maximum Height by Stacking Cuboids(Hard)

## 1688. Count of Matches in Tournament
To solve this problem, just follow the description in the problem and write down the code.

## 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
The simple idea solving this problem is to find the largest digit number in the string.

## 1690. Stone Game VII

In this problem, I use the dynamic programming method to solve this problem.<br>
According to the description, we have to satisfy the following condition:
- remove either the leftmost stone or the rightmost stone
- when it's Bob turn, minimize the score's difference
- when it's Alice turn, maximize the difference in the score

so


## 1691. Maximum Height by Stacking Cuboids
To solve this problem, firstly sort individual cuboid, so sides are in increasing order.<br>
Secondly sort cuboids again so cuboids[i] may be possible to put on top of cuboids[j] if i < j.<br>
After that, just use the dynamic programming methods to record the cuboids[i] how height it can be.
