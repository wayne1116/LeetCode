class Solution {
    boolean[] digit;
    Character[] alpha;
    String[] Words;
    String Result;
    int[] map;
    boolean ans;
    void alphamap(int index, int n){
        if(index==n){
            int sumleft=0;
            for(int i=0; i<Words.length; i++){
                int number=0;
                if(Words[i].length()>1 && map[Words[i].charAt(0)-'A']==0) return;
                for(int j=0; j<Words[i].length(); j++){
                    number=number*10+map[Words[i].charAt(j)-'A'];
                }
                sumleft+=number;
            }
            
            int sumright=0;
            if(Result.length()>1 && map[Result.charAt(0)-'A']==0) return;
            for(int i=0; i<Result.length(); i++){
                sumright=sumright*10+map[Result.charAt(i)-'A'];
            }
            if(sumleft==sumright) ans=true;
            return;
        }
        for(int i=0; i<=9; i++){
            if(!digit[i]){
                digit[i]=true;
                map[alpha[index]-'A']= i;
                alphamap(index+1, n);
                if(ans) return;
                digit[i]=false;
            }
        }
    }
    public boolean isSolvable(String[] words, String result) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++) set.add(words[i].charAt(j));
        }
        for(int i=0; i<result.length(); i++) set.add(result.charAt(i));
        if(set.size()>10) return false;
        
        alpha=new Character[set.size()];
        int count=0;
        Iterator<Character> it=set.iterator();
        while(it.hasNext()){
            alpha[count++]=it.next();
        }
        map=new int[26];
        for(int i=0; i<26; i++) map[i]=-1;
        digit=new boolean[10];
        Arrays.fill(digit, false);
        Words=words;
        Result=result;
        ans=false;
        alphamap(0, count);
        return ans;
    }
}
