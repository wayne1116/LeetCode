class Solution {
    public String minInteger(String num, int k) {
        List<Integer>[] list=new List[10];
        for(int i=0; i<10; i++)
            list[i]=new ArrayList<Integer>();
        
        for(int i=0; i<num.length(); i++) {
            int c=num.charAt(i)-'0';
            list[c].add(i);
        }
        
        StringBuilder st=new StringBuilder();
        int[] count=new int[10];
        boolean flag=true;
        Arrays.fill(count, 0);
        
        while(k>0 && flag) {
            flag=false;
            for(int i=0; i<10; i++) {
                if(count[i]<list[i].size()){
                    int c=list[i].get(count[i]);
                    int move=0;
                    for(int j=0; j<10; j++) {
                        int left=0;
                        int right=count[j]-1;
                        while(left<=right) {
                            int middle=(left+right)>>1;
                            int v=list[j].get(middle);
                            if(c<v)
                                right=middle-1;
                            else
                                left=middle+1;
                        }
                        move+=left;
                    }
                    if(k-(c-move)>=0) {
                        k-=(c-move);
                        st.append(num.charAt(c)+"");
                        ++count[i];
                        flag=true;
                        break;
                    }
                }
            }
        }
        
        for(int i=0; i<num.length(); i++) {
            int c=num.charAt(i)-'0';
            if(count[c]<list[c].size() && i==list[c].get(count[c])) {
                st.append(num.charAt(i)+"");
                ++count[c];
            }
        }
        
        return st.toString();
    }
}
