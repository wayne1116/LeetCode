// 1640. Check Array Formation Through Concatenation
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-213/problems/check-array-formation-through-concatenation/
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i=0;
        while(i<arr.length) {
            boolean flag=true;
            for(int j=0; j<pieces.length; j++) {
                if(arr[i]==pieces[j][0]) {
                    flag=false;
                    for(int k=0; k<pieces[j].length; k++) {
                        if(i>=arr.length || arr[i]!=pieces[j][k])
                            return false;
                        ++i;
                    }
                    break;
                }
            }
            if(flag)
                return false;
        }
        
        return true;
    }
}
