class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result=new ArrayList<String>();
        int i=1;
        for(int j=0; j<target.length; j++){
            while(i<target[j]){
                result.add("Push");
                result.add("Pop");
                ++i;
            }
            result.add("Push");
            ++i;
        }
    
        
        return result;
    }
}
