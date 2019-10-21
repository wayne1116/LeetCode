class Solution {
    public int balancedStringSplit(String s) {
        int Rnumber = 0;
        int Lnumber = 0;
        int result = 0;
        
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'R':
                    ++Rnumber;
                    break;
                case 'L':
                    ++Lnumber;
                    break;
            }
            if(Rnumber==Lnumber){
                ++result;
                Rnumber=Lnumber=0;
            }
        }
        return result;
    }
}
