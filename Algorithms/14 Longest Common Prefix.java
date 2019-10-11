class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int len = strs[0].length();
        int index = 0;
        for(int i=1; i<strs.length; i++){
            if(len>strs[i].length()){
                len = strs[i].length();
                index = i;
            }
        }
        
        String temp = strs[index];
        strs[index] = strs[0];
        strs[0] = temp;
        boolean flag=false;
        index=-1;
        
        for(int i=0; i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i)!=strs[0].charAt(i)){
                    flag=true;;
                    break;
                }
            }
            if(flag) break;
            index = i;
        }
        String result;
        if(index!=-1)result=strs[0].substring(0,index+1);
        else result="";
        
        return result;
    }
}