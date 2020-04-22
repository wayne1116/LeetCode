class Solution {
    public String reformat(String s) {
        Queue<Character> digits=new LinkedList<Character>();
        Queue<Character> alphas=new LinkedList<Character>();
        StringBuilder st=new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9')
                digits.offer(c);
            else
                alphas.offer(c);
        }
        
        if(Math.abs(digits.size()-alphas.size())>1)
            return "";
        
        int curr=0;
        if(digits.size()==alphas.size() && s.charAt(0)>='0' && s.charAt(0)<='9' || alphas.size()>digits.size())
            curr=1;
        
        for(int i=0; i<s.length(); i++){
            if(curr==0){
                curr=1;
                st.append(digits.poll()+"");
            } else{
                curr=0;
                st.append(alphas.poll()+"");
            }
        }
        
        return st.toString();
    }
}
