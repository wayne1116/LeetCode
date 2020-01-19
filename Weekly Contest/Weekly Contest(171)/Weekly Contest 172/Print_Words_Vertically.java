class Solution {
    public List<String> printVertically(String s) {
        List<String> result=new ArrayList<String>();
        String[] word=s.split(" ");
        int maxLen=word[0].length();
        for(int i=1; i<word.length; i++){
            maxLen=Math.max(maxLen, word[i].length());
        }
        
        for(int i=0; i<maxLen; i++){
            StringBuilder st=new StringBuilder();
            for(int j=0; j<word.length; j++){
                if(word[j].length()>i)
                    st.append(word[j].charAt(i)+"");
                else st.append(" ");
            }
            int k=st.length()-1;
            while(k>=0){
                if(st.charAt(k)==' ') st.delete(k, k+1);
                else break;
                --k;
            }
            result.add(st.toString());
        }
        return result;
    }
}
