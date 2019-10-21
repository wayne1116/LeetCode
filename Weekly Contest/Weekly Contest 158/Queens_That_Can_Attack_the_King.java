class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] temp = new int[queens.length][3];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<queens.length; i++){
            temp[i][0]=king[0]-queens[i][0];
            temp[i][1]=king[1]-queens[i][1];
            temp[i][2]=(int)Math.pow(temp[i][0],2)+(int)Math.pow(temp[i][1],2);
        }
        
        int[] compar = new int[8];
        int[] index = new int[8];
        Arrays.fill(index,-1);
        compar[0]=-1000;
        compar[1]=1000;
        compar[2]=-1000;
        compar[3]=1000;
        compar[4]=1000;
        compar[5]=1000;
        compar[6]=1000;
        compar[7]=1000;
        
        for(int i=0; i<queens.length; i++){
            if(temp[i][1]==0){
                if(compar[0]<temp[i][0] && temp[i][0]<0){
                    compar[0]=temp[i][0];
                    index[0]=i;
                }
                if(compar[1]>temp[i][0] && temp[i][0]>0){
                    compar[1]=temp[i][0];
                    index[1]=i;
                }
            }
            else if(temp[i][0]==0){
                if(compar[2]<temp[i][1] && temp[i][1]<0){
                    compar[2]=temp[i][1];
                    index[2]=i;
                }
                if(compar[3]>temp[i][1] && temp[i][1]>0){
                    compar[3]=temp[i][1];
                    index[3]=i;
                }   
            }
            else if((float)temp[i][1]/(float)temp[i][0]==1){
                if(compar[4]>temp[i][2] && temp[i][0]<0){
                    compar[4]=temp[i][2];
                    index[4]=i;
                }
                if(compar[5]>temp[i][2] && temp[i][0]>0){
                    compar[5]=temp[i][2];
                    index[5]=i;
                }
            }
            else if((float)temp[i][1]/(float)temp[i][0]==-1){
                if(compar[6]>temp[i][2] && temp[i][0]<0){
                    compar[6]=temp[i][2];
                    index[6]=i;
                }
                if(compar[7]>temp[i][2] && temp[i][0]>0){
                    compar[7]=temp[i][2];
                    index[7]=i;
                }
            }
        }
        
        for(int i=0; i<8; i++){
            if(index[i]!=-1){
                List<Integer> temp1 = new ArrayList<Integer>();
                temp1.add(queens[index[i]][0]);
                temp1.add(queens[index[i]][1]);
                result.add(temp1);
            }
        }
        return result;
    }
}
