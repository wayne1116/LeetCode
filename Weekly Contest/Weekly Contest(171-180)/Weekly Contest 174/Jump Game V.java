class Solution {
    public int maxJumps(int[] arr, int d) {
        Node[] lnode=new Node[arr.length];
        for(int i=0; i<arr.length; i++){
            Node temp=new Node();
            temp.value=arr[i];
            temp.index=i;
            lnode[i]=temp;
        }
        
        int[] dp=new int[arr.length];
        Arrays.sort(lnode);
        Arrays.fill(dp, 1);
        for(int i=0; i<arr.length; i++){
            int value=lnode[i].value;
            int index=lnode[i].index;
            int limit=Math.max(0, index-d);
            
            //search the left 
            for(int j=index-1; j>=limit; j--){
                if(arr[index]>arr[j])
                    dp[index]=Math.max(dp[index], dp[j]+1);
                else 
                    break;
            }
            
            //search the right
            limit=Math.min(arr.length-1, index+d);
            for(int j=index+1; j<=limit; j++){
                if(arr[index]>arr[j])
                    dp[index]=Math.max(dp[index], dp[j]+1);
                else
                    break;
            }
        }
        
        int result=0;
        for(int i=0; i<arr.length; i++)
            result=Math.max(result, dp[i]);
        return result;
    }
}
class Node implements Comparable<Node>{
    public int value;
    public int index;
    @Override
    public int compareTo(Node x){
        return this.value-x.value;
    }
}
