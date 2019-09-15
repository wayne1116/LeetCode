class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;
        
        for(int i=0; i<text.length(); i++){
            switch(text.charAt(i)){
                case 'b': ++b;
                          break;
                case 'a': ++a;
                          break;
                case 'l': ++l;
                          break;
                case 'o': ++o;
                          break;
                case 'n': ++n;
                          break;
            }    
        }
        return Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
    }
}
