class Solution {
    public boolean isValid(String s) {
        Stack<Character> temp = new Stack<Character>();
        char temp1;
        for(int i=0; i<s.length(); i++){
            temp1=s.charAt(i);
            switch(temp1){
                case ')':
                    if(temp.empty()) return false;
                    else if(temp.peek()!='(') return false;
                    temp.pop();
                    break;
                case '}':
                    if(temp.empty()) return false;
                    else if(temp.peek()!='{') return false;
                    temp.pop();
                    break;
                case ']':
                    if(temp.empty()) return false;
                    else if(temp.peek()!='[') return false;
                    temp.pop();
                    break;
                case '(':
                    temp.push('(');
                    break;
                case '[':
                    temp.push('[');
                    break;
                case '{':
                    temp.push('{');
                    break;
            }
        }
        if(!temp.empty()) return false;
        return true;
    }
}