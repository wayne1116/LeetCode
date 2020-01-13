class Solution {
    public String freqAlphabets(String s) {
        StringBuilder st = new StringBuilder();
        int i=0;
        int value=0, v;
        char tmp;
        while(i<s.length()){
            if(s.charAt(i)=='#'){
                v=value+'a'-1;
                tmp=(char)v;
                st.append(tmp);
                value=0;
            }
            else{
                value=value*10+s.charAt(i)-'0';
                if(i+1<s.length() && value>9){
                    if(s.charAt(i+1)!='#'){
                        v=value/10+'a'-1;
                        tmp=(char)v;
                        st.append(tmp);
                        value=value%10;
                    }
                }
            }
            ++i;
        }
        if(value>0 && value<10){
            v=value+'a'-1;
            tmp=(char)v;
            st.append(tmp);
        }
        else if(value>9){
            v=value/10+'a'-1;
            tmp=(char)v;
            st.append(tmp);
            v=value%10+'a'-1;
            tmp=(char)v;
            st.append(tmp);
        }     
        return st.toString();
    }
}
