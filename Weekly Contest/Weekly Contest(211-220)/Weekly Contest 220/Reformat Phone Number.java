// 1694. Reformat Phone Number
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-220/problems/reformat-phone-number/

class Solution {
    public String reformatNumber(String number) {
        StringBuilder st = new StringBuilder();
        for(int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            if(c>='0' && c<='9')
                st.append(c+"");
        }
        
        StringBuilder result = new StringBuilder();
        int i=0;
        while(i+4<st.length()) {
            result.append(st.charAt(i)+""+st.charAt(i+1)+""+st.charAt(i+2)+"-");
            i+=3;
        }
        if(i+2>=st.length())
            result.append(st.charAt(i)+""+st.charAt(i+1));
        else if(i+3>=st.length())
            result.append(st.charAt(i)+""+st.charAt(i+1)+""+st.charAt(i+2));
        else
            result.append(st.charAt(i)+""+st.charAt(i+1)+"-"+st.charAt(i+2)+""+st.charAt(i+3));
        
        return result.toString();
    }
}
