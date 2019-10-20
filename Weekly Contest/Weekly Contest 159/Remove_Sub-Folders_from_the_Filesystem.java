class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        String standard = folder[0];
        List result = new ArrayList<String>();
        result.add(standard);
        
        for(int i=1; i<folder.length; i++){
            int len = standard.length() > folder[i].length() ? folder[i].length() : standard.length();
            String temp = folder[i].substring(0,len);
            if(!standard.equals(temp)){
                result.add(folder[i]);
                standard=folder[i];
            }
            else{
                if(folder[i].charAt(standard.length())!='/'){
                    result.add(folder[i]);
                    standard=folder[i];
                }
            }
        }
        return result;
    }
}
