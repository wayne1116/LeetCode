class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent=new int[n];
        Arrays.fill(parent, -1);
        
        for(int i=0; i<n; i++) {
            if(leftChild[i]!=-1) {
                if(parent[leftChild[i]]<0 && parent[i]!=leftChild[i])
                    parent[leftChild[i]]=i;
                else 
                    return false;
            }
        }
        
        for(int i=0; i<n; i++) {
            if(rightChild[i]!=-1) {
                if(parent[rightChild[i]]<0 && parent[i]!=rightChild[i]) 
                    parent[rightChild[i]]=i;
                else 
                    return false;
            }
        }
        
        int count=0;
        for(int i=0; i<n; i++) {
            if(parent[i]<0)
                ++count;
        }
        if(count!=1)
            return false;
        return true;
    }
}
