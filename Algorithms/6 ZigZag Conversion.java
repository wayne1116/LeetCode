class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int dis = (numRows-1)<<1;
        int plus = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i+=dis) result.append(s.charAt(i));
        for(int i=1; i<numRows>>1; i++){
            int j=i;
            dis-=2;
            plus+=2;
            while(j<s.length()){
                result.append(s.charAt(j));
                j+=dis;
                if(j>=s.length()) break;
                result.append(s.charAt(j));
                j+=plus;
            }
        }
        if(numRows%2==1){
            int j=numRows>>1;
            dis-=2;
            for(int i=j; i<s.length(); i+=dis) result.append(s.charAt(i));
            dis+=2;
        }
        
        for(int i=(numRows+1)>>1; i<numRows-1; i++){
            int j=i;
            while(j<s.length()){
                result.append(s.charAt(j));
                j+=plus;
                if(j>=s.length()) break;
                result.append(s.charAt(j));
                j+=dis;
            }
            dis+=2;
            plus-=2;
        }
        for(int i=numRows-1; i<s.length(); i+=dis) result.append(s.charAt(i));
        return result.toString();
    }
}