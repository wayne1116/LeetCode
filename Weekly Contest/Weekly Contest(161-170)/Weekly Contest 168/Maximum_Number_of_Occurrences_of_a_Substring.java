class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(minSize>s.length()) return 0;
        
        int start=0;
        StringBuilder word = new StringBuilder();
        Map<String, Integer> map=new HashMap<String, Integer>();
        Map<Character, Integer> alphcount=new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            if(alphcount.containsKey(s.charAt(i))){
                int v=alphcount.get(s.charAt(i));
                alphcount.put(s.charAt(i), v+1);
            }
            else alphcount.put(s.charAt(i), 1);
            
            if(i-start+1>minSize){
                int v=alphcount.get(s.charAt(start));
                alphcount.put(s.charAt(start), v-1);
                if(v-1==0) alphcount.remove(s.charAt(start));
                word.deleteCharAt(0);
                ++start;
            }
            word.append(s.charAt(i));
            if(i-start+1==minSize && alphcount.size()<=maxLetters){
                if(map.containsKey(word.toString())){
                    int v=map.get(word.toString());
                    map.put(word.toString(), v+1);
                }
                else map.put(word.toString(), 1);
            }
        }
        
        int result=0;
        for(String i:map.keySet()){
            result=Math.max(result,  map.get(i));
        }
        return result;
    }
}

/* the second implementation: hash method

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(minSize>s.length()) return 0;
        
        int MOD = 2147483647;
        int mul=(int)Math.pow(26, minSize-1);
        int start=0;
        int hash=0;
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        Map<Character, Integer> alphcount=new HashMap<Character, Integer>();
        
        for(int i=0; i<s.length(); i++){
            if(alphcount.containsKey(s.charAt(i))){
                int v=alphcount.get(s.charAt(i));
                alphcount.put(s.charAt(i), v+1);
            }
            else alphcount.put(s.charAt(i), 1);
            
            if(i-start+1>minSize){
                int v=alphcount.get(s.charAt(start));
                alphcount.put(s.charAt(start), v-1);
                hash-=(int)(s.charAt(start)-'a')*mul;
                if(v-1==0) alphcount.remove(s.charAt(start));
                ++start;
            }
            hash=(hash*26+s.charAt(i)-'a')%MOD;
            if(i-start+1==minSize && alphcount.size()<=maxLetters){
                if(map.containsKey(hash)){
                    int v=map.get(hash);
                    map.put(hash, v+1);
                }
                else map.put(hash, 1);
            }
        }
        
        int result=0;
        for(Integer i:map.keySet()){
            result=Math.max(result,  map.get(i));
        }
        return result;
    }
}*/
