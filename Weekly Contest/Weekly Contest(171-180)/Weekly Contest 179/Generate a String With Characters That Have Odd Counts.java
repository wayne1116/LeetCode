class Solution {
    public String generateTheString(int n) {
        StringBuilder st=new StringBuilder();
        if(n%2==1)
            st.append("a");
        if(n==1)
            return st.toString();
        
        int div=n>>1;
        if(div%2==1){
            for(int i=0; i<div; i++)
                st.append("bc");
        }
        else{
            for(int i=0; i<div-1; i++)
                st.append("bc");
            st.append("cc");
        }
        
        return st.toString();
    }
}
