class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        int result=0;
        for(int i=0; i<k; i++){
            char c=s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                ++count;
            result=Math.max(result, count);
        }
        
        int start=0;
        for(int i=k; i<s.length(); i++) {
            char t1=s.charAt(i);
            char t2=s.charAt(start++);
            if(t1=='a'||t1=='e'||t1=='i'||t1=='o'||t1=='u')
                ++count;
            if(t2=='a'||t2=='e'||t2=='i'||t2=='o'||t2=='u')
                --count;
            result=Math.max(result, count);
        }
    
        return result;
    }
}
