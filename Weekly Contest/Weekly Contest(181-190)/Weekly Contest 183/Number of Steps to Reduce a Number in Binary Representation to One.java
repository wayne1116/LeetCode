class Solution {
    public int numSteps(String s) {
        int carry=0;
        int result=0;
        for(int i=s.length()-1; i>0; i--) {
            if(carry==0){
                if(s.charAt(i)=='1'){
                    carry=1;
                    result+=2;
                } else{
                    result+=1;
                }
            }
            else{
                if(s.charAt(i)=='0')
                    result+=2;
                else
                    result+=1;
            }
        }
        if(s.charAt(0)=='1' && carry==1)
            result+=1;
        
        return result;
    }
}
