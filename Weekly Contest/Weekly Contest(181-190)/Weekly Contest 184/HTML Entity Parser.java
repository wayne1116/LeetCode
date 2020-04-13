class Solution {
    public String entityParser(String text) {
        String line=text+"      ";
        char[] c=new char[6];
        StringBuilder st=new StringBuilder();
        int i=0;
        int index=0;
        
        while(i<text.length()) {
            if(line.charAt(i)=='&'){
                ++i;
                for(int j=0; j<6; j++)
                    c[j]=line.charAt(j+i);
                if(c[0]=='q' && c[1]=='u' && c[2]=='o' && c[3]=='t' && c[4]==';'){
                    st.append("\"");
                    i+=5;
                }
                else if(c[0]=='a' && c[1]=='p' && c[2]=='o' && c[3]=='s' && c[4]==';'){
                    st.append("\'");
                    i+=5;
                }
                else if(c[0]=='a' && c[1]=='m' && c[2]=='p' && c[3]==';'){
                    st.append("&");
                    i+=4;
                }
                else if(c[0]=='g' && c[1]=='t' && c[2]==';'){
                    st.append(">");
                    i+=3;
                }
                else if(c[0]=='l' && c[1]=='t' && c[2]==';'){
                    st.append("<");
                    i+=3;
                }
                else if(c[0]=='f' && c[1]=='r' && c[2]=='a' && c[3]=='s' && c[4]=='l' && c[5]==';'){
                    st.append("/");
                    i+=6;
                }
                else
                    st.append("&");
                
            } else{
                st.append(text.charAt(i)+"");
                ++i;
            }
        }
        
        return st.toString();
    }
}
