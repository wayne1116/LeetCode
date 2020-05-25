class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] word=sentence.split(" ");
        for(int i=0; i<word.length; i++) {
            if(searchWord.length()<=word[i].length()){
                int j=0;
                for(j=0; j<searchWord.length(); j++){
                    if(searchWord.charAt(j)!=word[i].charAt(j))
                        break;
                }
                if(j>=searchWord.length())
                    return i+1;
            }
        }
        
        return -1;
    }
}
