class Solution {
    public int numTeams(int[] rating) {
        int result=0;
        int total=rating.length;
        for(int i=0; i<total-2; i++) {
            for(int j=i+1; j<total-1; j++){
                for(int k=j+1; k<total; k++){
                    if(rating[i]<rating[j] && rating[j]<rating[k] || rating[i]>rating[j] && rating[j]>rating[k])
                        ++result;
                }
            }
        }
        
        return result;
    }
    
}
