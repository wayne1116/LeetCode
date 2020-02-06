class Solution {
    public int minSetSize(int[] arr) {
        Node[] lnode=new Node[100001];
        for(int i=0; i<100001; i++)
            lnode[i]=new Node(i);
        
        for(int i=0; i<arr.length; i++){
            ++lnode[arr[i]].count;
        }
        
        Arrays.sort(lnode);
        int total=arr.length;
        int limit=arr.length>>1;
        int index=0;
        while(total>limit){
            total-=lnode[index++].count;
        }
        return index;
    }
}
class Node implements Comparable<Node>{
    int number;
    int count;
    public Node(int num){
        number=num;
        count=0;
    }
    @Override
    public int compareTo(Node x){
        return x.count-this.count;
    }
}
