class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Integer, Integer> count=new HashMap<Integer, Integer>();
        int result=0;
        int curfrog=0;
        for(int i=0; i<4; i++)
            count.put(i, 0);
        
        for(int i=0; i<croakOfFrogs.length(); i++){
            char c=croakOfFrogs.charAt(i);
            int curr=0;
            switch(c){
                case 'r':
                    curr=1;
                    break;
                case 'o':
                    curr=2;
                    break;
                case 'a':
                    curr=3;
                    break;
                case 'k':
                    curr=4;
                    break;
            }
            if(curr==0){
                count.put(curr, count.get(curr)+1);
                curfrog++;
            }
            else{
                if(count.get(curr-1)==0)
                    return -1;
                count.put(curr-1, count.get(curr-1)-1);
                if(curr==4)
                    --curfrog;
                else
                    count.put(curr, count.get(curr)+1);
            }
            result=Math.max(result, curfrog);
        }
        
        for(int i=0; i<4; i++){
            if(count.get(i)>0)
                return -1;
        }
        
        return result;
    }
}
