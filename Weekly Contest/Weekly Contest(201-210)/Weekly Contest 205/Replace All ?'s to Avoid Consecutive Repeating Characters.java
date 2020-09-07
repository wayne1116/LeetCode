// 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
// difficulty: Easy
// website: https://leetcode.com/contest/weekly-contest-205/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

class Solution {
    public String modifyString(String s) {
        StringBuilder st=new StringBuilder();
        int index=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='?') {
                if(st.length()>0 && i+1<s.length()) {
                    int c1=st.charAt(st.length()-1)-'a';
                    int c2=s.charAt(i+1)-'a';
                    while(index==c1 || index==c2)
                        index=(index+1)%26;
                    
                    char c=(char)(index+'a');
                    st.append(c+"");
                    index=(index+1)%26;
                }
                else if(st.length()>0) {
                    char c=(char)((st.charAt(st.length()-1)-'a'+1)%26+'a');
                    st.append(c+"");
                }
                else if(i+1<s.length() && s.charAt(i+1)!='?') {
                    char c=(char)((s.charAt(i+1)-'a'+1)%26+'a');
                    System.out.println((int)c);
                    st.append(c+"");
                }
                else{
                    char c=(char)(index+'a');
                    st.append(c+"");
                    index=(index+1)%26;
                }
            }
            else
                st.append(s.charAt(i)+"");
        }
        
        return st.toString();
    }
}
