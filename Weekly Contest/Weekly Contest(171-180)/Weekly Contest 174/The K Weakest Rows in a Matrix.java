class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Node[] lnode=new Node[mat.length];
        for(int i=0; i<mat.length; i++){
            int sum=0;
            for(int j=0; j<mat[i].length; j++) sum+=mat[i][j];
            lnode[i]=new Node(i, sum);
        }
        Arrays.sort(lnode);
        
        int[] result=new int[k];
        for(int j=0; j<k; j++)
            result[j]=lnode[j].row;
        return result;
    }
}

class Node implements Comparable<Node>{
    int row;
    int count;
    public Node(int r, int v){
        row=r;
        count=v;
    }
    @Override
    public int compareTo(Node x){
        if(this.count==x.count)
            return this.row-x.row;
        return this.count-x.count;
    }
}
