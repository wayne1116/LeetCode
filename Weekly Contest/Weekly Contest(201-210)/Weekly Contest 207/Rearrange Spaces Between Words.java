// 1592. Rearrange Spaces Between Words
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-207/problems/rearrange-spaces-between-words/

class Solution {
    public String reorderSpaces(String text) {
        int count=0;
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i)==' ')
                ++count;
        }
        
        int wordCount=0;
        String[] word=text.split(" ");
        for(int i=0; i<word.length; i++) {
            if(word[i].length()>0)
                ++wordCount;
        }
        
        StringBuilder st=new StringBuilder();
        int divide=1;
        if(wordCount>1) 
            divide=count/(wordCount-1);
        boolean flag=false;
        StringBuilder space=new StringBuilder();
        for(int i=0; i<divide; i++)
            space.append(" ");
        for(int i=0; i<word.length; i++) {
            if(word[i].length()>0) {
                if(flag){
                    st.append(space.toString());
                    count-=divide;
                }
                st.append(word[i]);
                flag=true;
            }
        }
        
        while(count-->0)
            st.append(" ");
        
        return st.toString();
    }
}
