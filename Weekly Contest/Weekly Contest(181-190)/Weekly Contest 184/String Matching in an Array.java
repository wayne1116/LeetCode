class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result=new ArrayList<String>();
        Arrays.sort(words, new Comparator<String>(){
           public int compare(String a, String b) {
               return a.length()-b.length();
           } 
        });
        
        for(int i=0; i<words.length; i++) {
            int len=words[i].length();
            for(int j=i+1; j<words.length; j++) {
                int flag=0;
                for(int k=0; k<words[j].length()-len+1; k++) {
                    flag=1;
                    for(int l=0; l<len; l++){
                        if(words[j].charAt(k+l)!=words[i].charAt(l)){
                            flag=2;
                            break;
                        }
                    }
                    if(flag==1)
                        break;
                }
                if(flag==1){
                    result.add(words[i]);            
                    break;
                }
            }
        }
        return result;
    }
}
