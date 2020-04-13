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
