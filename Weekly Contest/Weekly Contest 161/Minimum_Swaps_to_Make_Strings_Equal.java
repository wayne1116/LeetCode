class Solution {
    public int minimumSwap(String s1, String s2) {
        int len=s1.length();
        int same=0;
        int xcount=0;
        int ycount=0;
        int totalx=0;
        int totaly=0;
        
        for(int i=0; i<len; i++){
            if(s1.charAt(i)=='x') ++totalx;
            else ++totaly;
            if(s2.charAt(i)=='x') ++totalx;
            else ++totaly;
            
            if(s1.charAt(i)==s2.charAt(i)) ++same;
            else{
                if(s1.charAt(i)=='x') ++xcount;
                else ++ycount;
            }
        }
        int remain=len-same;
        if(remain%2==1 || totalx%2!=0 || totaly%2!=0) return -1;
        
        if(xcount%2==0) return remain>>1;
        return (remain>>1)+1;
    }
}
