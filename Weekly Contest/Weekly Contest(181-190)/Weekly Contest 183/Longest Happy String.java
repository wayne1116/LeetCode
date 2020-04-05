class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result=new StringBuilder();
        int total=a+b+c;
        int Acount=0;
        int Bcount=0;
        int Ccount=0;
        
        for(int i=0; i<total; i++) {
            if((a>=b && a>=c && Acount<2) || ((Bcount==2 || Ccount==2) && a>0)){
                result.append("a");
                ++Acount;
                --a;
                Bcount=0;
                Ccount=0;
            }
            else if((b>=c && b>=a && Bcount<2) || ((Acount==2 || Ccount==2) && b>0)){
                result.append("b");
                ++Bcount;
                --b;
                Acount=0;
                Ccount=0;
            }
            else if((c>=a && c>=b && Ccount<2) || ((Acount==2 || Bcount==2) && c>0)){
                result.append("c");
                ++Ccount;
                --c;
                Acount=0;
                Bcount=0;
            }
        }
        
        return result.toString();
    }
}
