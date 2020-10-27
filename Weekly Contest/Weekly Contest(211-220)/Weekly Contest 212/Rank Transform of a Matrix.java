// 1632. Rank Transform of a Matrix
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-212/problems/rank-transform-of-a-matrix/
// keypoint: sort and union-find

class Solution {
    int find(int node, int[] parent) {
        while(parent[node]!=node && parent[node]>=0 && node!=parent.length-1)
            node=parent[node];
        return node;
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] temp=new int[row*col][2];
        int[] parent=new int[row*col+1];
        int[][] rowRank=new int[row][2];
        int[][] colRank=new int[col][2];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                temp[i*col+j][0]=matrix[i][j];
                temp[i*col+j][1]=i*col+j;
            }
        }
        for(int i=0; i<parent.length; i++)
            parent[i]=i;
        parent[row*col]=0;
        for(int i=0; i<row; i++){
            rowRank[i][0]=Integer.MIN_VALUE;
            rowRank[i][1]=row*col;
        }
        for(int i=0; i<col; i++) {
            colRank[i][0]=Integer.MIN_VALUE;
            colRank[i][1]=row*col;
        }
        Arrays.sort(temp, (a,b)->a[0]-b[0]);
        
        for(int i=0; i<temp.length; i++) {
            int[] t=temp[i];
            int r=t[1]/col;
            int c=t[1]%col;
            int u=find(rowRank[r][1], parent);
            int v=find(colRank[c][1], parent);
            if(rowRank[r][0]==t[0] || colRank[c][0]==t[0]) {
                if(rowRank[r][0]==t[0] && colRank[c][0]==t[0]) {
                    if(u!=v){
                        if(parent[u]<parent[v]) 
                            parent[t[1]]=parent[v]=u;
                        else
                            parent[t[1]]=parent[u]=v;
                    }
                    else
                        parent[t[1]]=u;
                }
                else if(rowRank[r][0]==t[0]) {
                    parent[t[1]]=u;
                    if(-parent[u]<=-parent[v])
                        parent[u]=parent[v]-1;
                }
                else{
                    parent[t[1]]=v;
                    if(-parent[v]<=-parent[u])
                        parent[v]=parent[u]-1;
                }
            }
            else
                parent[t[1]]=-(Math.max(-parent[u], -parent[v])+1);
            
            rowRank[r][0]=colRank[c][0]=t[0];
            rowRank[r][1]=colRank[c][1]=t[1];
        }
        
        int[][] result=new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++)
                result[i][j]=-parent[find(i*col+j, parent)];
        }
        
        return result;
    }
}
