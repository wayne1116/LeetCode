class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int[] index = new int[s.length()];
        Arrays.fill(index,-1);
        int count=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                st.push('(');
                index[count++]=i;
            }
            else if(s.charAt(i)==')'){
                if(st.empty()){
                    st.push(')');
                    index[count++]=i;
                }
                else if(st.peek()=='('){
                    st.pop();
                    index[--count]=-1;
                }
                else{
                    st.push(')');
                    index[count++]=i;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        int j=0;
        for(int i=0; i<s.length(); i++){
            if(i==index[j]) ++j;
            else result.append(s.charAt(i));
        }
        
        return result.toString();
    }
}
