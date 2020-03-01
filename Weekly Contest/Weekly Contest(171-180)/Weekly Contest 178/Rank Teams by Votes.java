class Solution {
    public String rankTeams(String[] votes) {
        int[][] alpha=new int[26][28];
        
        for(int i=0; i<26; i++){
            alpha[i][0]=i;
            for(int j=1; j<28; j++)
                alpha[i][j]=0;
        }
        
        int len=votes[0].length();
        for(int i=0; i<votes.length; i++) {
            for(int j=0; j<len; j++) {
                ++alpha[votes[i].charAt(j)-'A'][j+1];
                alpha[votes[i].charAt(j)-'A'][27]=1;
            }
        }
        
        Arrays.sort(alpha, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               for(int i=1; i<27; i++){
                   if(a[i]!=b[i])
                       return b[i]-a[i];
               }
               return a[0]-b[0];
           } 
        });
        
        StringBuilder st=new StringBuilder();
        for(int i=0; i<26; i++){
            if(alpha[i][27]==1){
                char c=(char)('A'+alpha[i][0]);
                st.append(c);
            }
        }
        return st.toString();
    }
}
