class Solution {
    // Tic_Tac_Toe
    //  1 2 3      1   2   4 
    //  4 5 6  ->  8  16  32
    //  7 8 9     64 128 256
    
    // Win: 
    // 1+8+64=73
    // 2+26+128=146
    // 4+32+256=292
    // 1+2+4=7
    // 8+16+32=56
    // 64+128+256=448
    // 1+16+256=273
    // 4+16+64=84
    
    int[] winner={73,146,292,7,56,448,273,84};
    boolean check(int value){
        for(int i=0; i<8; i++){
            if((value&winner[i])==winner[i]) return true;
        }        
        return false;
    }
    public String tictactoe(int[][] moves) {
        int A=0;
        int B=0;
        int[] value=new int[9];
        
        value[0]=1;
        for(int i=1; i<9; i++) value[i]=value[i-1]<<1;
        for(int i=0; i<moves.length; i++){
            int location=moves[i][0]*3+moves[i][1];
            if(i%2==0){
                A|=value[location];
                if(check(A)) return "A";
            }
            else{
                B|=value[location];
                if(check(B)) return "B";
            }
            
        }
        if(moves.length==9) return "Draw";
        return "Pending";
    }
}
