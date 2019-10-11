class Solution {
    public int myAtoi(String str) {
        double result = 0;
        boolean flag = true;
        int i=0;
        str=str.trim();
        if(str.length()==0) return 0;
        
        if(str.charAt(i)=='-'||str.charAt(i)=='+') ++i;
        while(i<str.length()){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                result=result*10+str.charAt(i)-'0';
                flag=false;
                
            }
            else break;
            ++i;
        }
        if(str.charAt(0)=='-') result*=-1;
        if(result>2147483647) result=2147483647;
        else if(result<-2147483648) result=-2147483648;
        
        return (int)result;
    }
}