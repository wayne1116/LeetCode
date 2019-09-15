class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<Character>();
        Queue<Character> temp = new LinkedList<Character>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=')') st.push(s.charAt(i));
            else{
                while(st.peek()!='('){
                    temp.offer(st.pop());
                }
                st.pop();
                while(temp.peek()!=null) st.push(temp.poll());
            }
        }
        Stack<Character> result = new Stack<Character>();
        while(!st.empty()){
            result.push(st.pop());
        }
        StringBuilder re = new StringBuilder();
        while(!result.empty()) re.append(result.pop());
        return re.toString();
    }
}
