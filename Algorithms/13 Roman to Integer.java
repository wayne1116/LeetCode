class Solution {
    public int romanToInt(String s) {
        int[] value = new int[26];
        for(int i=0; i<26; i++) value[i]=0;
        value['I'-'A'] = 1;
        value['V'-'A'] = 5;
        value['X'-'A'] = 10;
        value['L'-'A'] = 50;
        value['C'-'A'] = 100;
        value['D'-'A'] = 500;
        value['M'-'A'] = 1000;
        
        int cur = s.charAt(0);
        int result = 0;
        for(int i=1; i<s.length(); i++){
            result+=value[cur-'A'];
            if(value[s.charAt(i)-'A']>value[cur-'A']) result-=2*value[cur-'A']; 
            cur = s.charAt(i);
        }
        result+=value[cur-'A'];
        return result;
    }
}