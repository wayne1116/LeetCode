// 1649. Create Sorted Array through Instructions
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-214/problems/create-sorted-array-through-instructions/
// keypoint: segment tree

class Solution {
    int lValue, rValue;
    void find(int value, int[][] dp, int[][] temp, int index, int left, int right) {
        while(left<right) {
            int middle=(left+right)>>1;
            if(temp[middle][0]<value) {
                lValue+=dp[index][0];
                dp[index][1]-=1;
                index=index*2+2;
                left=middle+1;
            }
            else{
                rValue+=dp[index][1];
                dp[index][0]-=1;
                index=index*2+1;
                right=middle;
            }
        }
    }
    void build(int[][] dp, int[] totalCount, int[][] temp, int index, int left, int right) {
        if(right==left)
            return;
        int middle=(left+right)>>1;
        dp[index][0]=totalCount[middle]-totalCount[left]+temp[left][1];
        dp[index][1]=totalCount[right]-totalCount[middle];
        //System.out.println("----------"+dp[index][0]+" "+dp[index][1]);
        build(dp, totalCount, temp, index*2+1, left, middle);
        build(dp, totalCount, temp, index*2+2, middle+1, right);
    }
    public int createSortedArray(int[] instructions) {
        int[] count=new int[100001];
        int total=0;
        for(int i=0; i<instructions.length; i++) {
            count[instructions[i]]+=1;
            if(count[instructions[i]]==1)
                total+=1;
        }
        
        int[][] temp=new int[total][2];
        int index=0;
        for(int i=0; i<=100000; i++) {
            if(count[i]>0) {
                temp[index][0]=i;
                temp[index][1]=count[i];
                ++index;
            }
        }
        
        int[][] dp=new int[4*total][2];
        int[] totalCount=new int[total];
        totalCount[0]=temp[0][1];
        for(int i=1; i<total; i++)
            totalCount[i]=temp[i][1]+totalCount[i-1];
        build(dp, totalCount, temp, 0, 0, total-1);
        long result=0;
        for(int i=instructions.length-1; i>=0; i--) {
            lValue=rValue=0;
            find(instructions[i], dp, temp, 0, 0, total-1);
            //System.out.println(lValue+" "+rValue);
            result+=Math.min(lValue, rValue);
        }
        
        return (int)(result%1000000007);
    }
}
