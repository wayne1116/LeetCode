class Solution {
    public String arrangeWords(String text) {
        StringBuilder st=new StringBuilder(text);
        char c=(char)(st.charAt(0)-'A'+'a');
        st.setCharAt(0, c);
        String[] word=st.toString().split(" ");
        Arrays.sort(word, (a,b)->a.length()-b.length());
        st=new StringBuilder();
        st.append(word[0]);
        c=(char)(st.charAt(0)-'a'+'A');
        st.setCharAt(0, c);

        for(int i=1; i<word.length; i++)
            st.append(" "+word[i]);
        return st.toString();
    }
}
