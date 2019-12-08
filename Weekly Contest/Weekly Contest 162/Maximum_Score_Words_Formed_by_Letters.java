class Solution {
    int[] count;
    int[][] wordcount;
    int[] visited;
    int result;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        count = new int[26];
        wordcount = new int[words.length][26];
        
        for(int i=0; i<26; i++) count[i]=0;
        for(int i=0; i<letters.length; i++) ++count[letters[i]-'a'];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<26; j++) wordcount[i][j]=0;
            for(int j=0; j<words[i].length(); j++) ++wordcount[i][words[i].charAt(j)-'a'];
        }
        
        visited = new int[26];
        for(int i=0; i<26; i++) visited[i]=count[i];
        
        rec(0, words, score);
        return result;
    }
    
    void rec(int cur, String[] words, int[] score)
    {
        boolean flag = true;  
        for(int i=cur; i<words.length; i++){
            flag=true;
            for(int j=0; j<26; j++){
                if(visited[j]-wordcount[i][j]<0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                for(int j=0; j<26; j++) visited[j]-=wordcount[i][j];
                rec(i+1, words, score);
                for(int j=0; j<26; j++) visited[j]+=wordcount[i][j];
            }
        }
        
        int sum=0;
        for(int i=0; i<26; i++){
            sum += (score[i]*(count[i]-visited[i]));
        }
        result=Math.max(result, sum);
    }
}
