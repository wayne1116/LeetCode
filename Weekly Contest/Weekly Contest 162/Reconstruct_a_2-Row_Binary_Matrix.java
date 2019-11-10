class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //if(upper<lower) return result;
        
        int[] Upper = new int[colsum.length]; 
        int[] Lower = new int[colsum.length];
        
        for(int i=0; i<colsum.length; i++) Upper[i]=Lower[i]=0;
        
        for(int i=0; i<colsum.length; i++){
            if(colsum[i]==2){
                --upper;
                --lower;
                Upper[i]=1;
                Lower[i]=1;
            }
        }
        if(upper<0 || lower<0) return result;
        
        for(int i=0; i<colsum.length; i++){
            if(colsum[i]==1){
                if(upper>0){
                    --upper;
                    Upper[i]=1;
                }
                else if(lower>0){
                    --lower;
                    Lower[i]=1;
                }
                else return result;
            }
        }
        
        if(upper>0 || lower>0) return result;
        List<Integer> temp1 = new ArrayList<Integer>();
        List<Integer> temp2 = new ArrayList<Integer>();
        
        for(int i=0; i<colsum.length; i++){
            temp1.add(Upper[i]);
            temp2.add(Lower[i]);
        }
        
        result.add(temp1);
        result.add(temp2);
        return result;
    }
}
