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

/*
class Solution {
    public int minSetSize(int[] arr) {
        int[] count=new int[100001];
        int[] ocur=new int[100001];
        Arrays.fill(count, 0);
        Arrays.fill(ocur, 0);
        for(int i=0; i<arr.length; i++)
            ++count[arr[i]];
        for(int i=0; i<100001; i++)
            ++ocur[count[i]];
        
        int result=0;
        int limit=arr.length>>1;
        int total=arr.length;
        for(int i=100000; i>=0; i--){
            if(ocur[i]>0){
                while(ocur[i]>0 && limit<total){
                    ++result;
                    total-=i;
                    --ocur[i];
                }
            }
        }
        return result;
    }
}
*/
