class Solution {
    public String[] getFolderNames(String[] names) {
        String[] result=new String[names.length];
        Map<String, Integer> map=new HashMap<String, Integer>();
        for(int i=0; i<names.length; i++) {
            if(map.containsKey(names[i])) {
                StringBuilder st=new StringBuilder(names[i]);
                int val=map.get(names[i]);
                while(true) {
                    if(map.get(st.toString()+'('+Integer.toString(val)+')')==null){
                        break;
                    }
                    ++val;
                }
                st.append('('+Integer.toString(val)+')');
                map.put(names[i], val+1);
                map.put(st.toString(), 1);
                result[i]=st.toString();
            } else{
                result[i]=names[i];
                map.put(names[i], 1);
            }
        }   
        
        return result;
    }
}
