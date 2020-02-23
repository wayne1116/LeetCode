class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] need=new int[10];
        int[] count=new int[10];
        Queue<Integer> mod2=new LinkedList<Integer>();
        Queue<Integer> mod1=new LinkedList<Integer>();
        Arrays.fill(need, 0);
        Arrays.fill(count, 0);
        
        for(int i=0; i<digits.length; i++)
            ++count[digits[i]];
        
        for(int i=9; i>=0; i--) {
            if(i%3==0)
                need[i]=count[i];
            else if(i%3==2){
                for(int j=0; j<count[i]; j++)
                    mod2.offer(i);
            }
            else{
                for(int j=0; j<count[i]; j++)
                    mod1.offer(i);
            }
        }
        
        step1(mod1, need);
        step1(mod2, need);
        
        if(mod1.size()>mod2.size())
            step2(mod1, mod2, need);
        else
            step2(mod2, mod1, need);
        
        StringBuilder result=new StringBuilder();
        for(int i=9; i>0; i--) {
            String temp=Integer.toString(i);
            for(int j=0; j<need[i]; j++)
                result.append(temp);
        }
        if(result.length()==0){
            if(need[0]>0)
                return "0";
            return "";
        }
        for(int i=0; i<need[0]; i++)
            result.append("0");
        return result.toString();
    }
    
    void step1(Queue<Integer> queue, int[] need) {
        int len=queue.size();
        for(int i=0; i+3<len; i+=3){
            ++need[queue.poll()];
            ++need[queue.poll()];
            ++need[queue.poll()];
        }
    }
    
    void step2(Queue<Integer> qu1, Queue<Integer> qu2, int[] need) {
        int len1=0;
        int len2=0;
        if(qu1.size()==qu2.size())
            len1=len2=qu1.size();
        else if(qu1.size()==3 && qu2.size()<2){
            len1=3;
            len2=0;
        }
        else if(qu1.size()==3 && qu2.size()==2){
            len1=2;
            len2=2;
        }
        else if(qu1.size()==2 && qu2.size()==1){
            len1=1;
            len2=1;
        }
        for(int i=0; i<len1; i++)
            ++need[qu1.poll()];
        for(int i=0; i<len2; i++)
            ++need[qu2.poll()];
    }
}
