class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result=new ArrayList<List<String>>();
        Arrays.sort(products);
        int left=0;
        int right=products.length;
        for(int i=0; i<searchWord.length(); i++){
            char search=searchWord.charAt(i);
            int releft=-1;
            int reright=-1;
            for(int j=left; j<right; j++){
                if(products[j].length()>i){
                    if(search==products[j].charAt(i)){
                        releft=j;
                        break;
                    }
                }
            }
            
            List<String> temp=new ArrayList<String>();
            if(releft>-1){
                reright=right;
                for(int j=releft; j<right; j++){
                    if(search!=products[j].charAt(i)){
                        reright=j;
                        break;
                    }
                }
                
                int limit=(reright-releft>3)?3:(reright-releft);
                for(int j=releft; j<releft+limit; j++)
                    temp.add(products[j]);
            }
            left=releft;
            right=reright;
            result.add(temp);
        }
        return result;
    }
}
