class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        int total=0;
        for(int i=0; i<favoriteCompanies.size(); i++){
            List<String> t=favoriteCompanies.get(i);
            for(int j=0; j<t.size(); j++){
                if(!map.containsKey(t.get(j)))
                    map.put(t.get(j), total++);
            }
        }
        
        
        boolean[][] favorite=new boolean[favoriteCompanies.size()][total];
        for(int i=0; i<favoriteCompanies.size(); i++) {
            List<String> t=favoriteCompanies.get(i);
            Arrays.fill(favorite[i], false);
            for(int j=0; j<t.size(); j++){
                favorite[i][map.get(t.get(j))]=true;
            }
        } 
    
        
        int person=favoriteCompanies.size();
        List<Integer> result=new ArrayList<Integer>();
        for(int i=0; i<person; i++){
            boolean flag1=true;
            for(int j=0; j<person; j++){
                if(i==j) continue;
                boolean flag=false;
                for(int k=0; k<total; k++){
                    if(favorite[i][k] && !favorite[j][k]){
                        flag=true;
                        break;
                    } 
                }
                if(!flag){
                    flag1=false;
                    break;
                }
            }
            if(flag1){
                result.add(i);
            }
        }
        
        return result;
    }
}
