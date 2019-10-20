class Solution {
    public int balancedString(String s) {
        int[] count = new int[4];
        int len = s.length();
        int required = len>>2;
        
        Arrays.fill(count,0);
        
        for(int i=0; i<s.length(); i++){
            ++count[index(s.charAt(i))];
        }
        
        boolean flag=true;
        for(int i=0; i<4; i++){
            count[i]=Math.max(0,count[i]-required);
            if(count[i]>0) flag=false;
        }
        if(flag) return 0;
        
        int start=0;
        int result=len;
        
        for(int cur=0; cur<len; cur++){
            --count[index(s.charAt(cur))];
            while(allzero(count)){
                result=Math.min(cur-start+1,result);
                ++count[index(s.charAt(start))];
                ++start;
            }
        }
        return result;
    }
    private int index(char s){
        int i=0;
        switch(s){
            case 'Q': 
                i=0;
                break;
            case 'W':
                i=1;
                break;
            case 'E':
                i=2;
                break;
            case 'R':
                i=3;
                break;
        }
        return i;
    }
    private boolean allzero(int[] cnt){
        for(int i=0; i<4; i++){
            if(cnt[i]>0) return false;
        }
        return true;
    }
}
