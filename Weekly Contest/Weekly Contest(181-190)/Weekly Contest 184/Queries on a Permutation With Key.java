class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1; i<=m; i++)
            list.add(i);
        
        int[] result=new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            for(int j=0; j<list.size(); j++) {
                if(list.get(j)==queries[i]){
                    result[i]=j;
                    list.remove(j);
                    list.add(0, queries[i]);
                    break;
                }
            }
        }
        
        return result;
    }
}

/* Other version: Binary indexed tree solution

class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n=queries.length;
        int[] bits=new int[n+m+1];
        Arrays.fill(bits, 0);
        
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=1; i<=m; i++){
            update(bits, n+i, 1);
            map.put(i, n+i);
        }
        
        int[] result=new int[n];
        for(int i=0; i<n; i++) {
            int index=map.get(queries[i]);
            result[i]=prefixsum(bits, index)-1;
            update(bits, index, -1);
            update(bits, n-i, 1);
            map.put(queries[i], n-i);
        }
        return result;
    }
    
    void update(int[] bits, int index, int val) {
        while(index<bits.length) {
            bits[index]+=val;
            index+=(index&(-index));
        }
    }
    
    int prefixsum(int[] bits, int index) {
        int sum=0;
        while(index>0) {
            sum+=bits[index];
            index-=(index&(-index));
        }
        return sum;
    }
}

*/
