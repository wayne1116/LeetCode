class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            int c=s.charAt(i);
            if(stack.size()==0)
                stack.push((char)c);
            else if(stack.peek()==c-97+65 || stack.peek()==c-65+97)
                stack.pop();
            else
                stack.push((char)c);
        }
        
        StringBuilder st=new StringBuilder();
        while(stack.size()>0)
            st.append(stack.pop()+"");
        return st.reverse().toString();
    }
}
