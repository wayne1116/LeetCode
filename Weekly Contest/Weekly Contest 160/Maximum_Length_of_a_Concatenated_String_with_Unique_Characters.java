class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        
        for(int i=0; i<arr.size(); i++){
            rec(arr, new HashSet<Character>(), i);
        }
        return max;
    }
    
    void rec(List<String> arr, Set<Character> set, int start){
        if(arr.size()==0) return;
        
        boolean flag=true;
        for(int i=start; i<arr.size(); i++){
            String temp = arr.get(i);
            for(int j=0; j<temp.length(); j++){
                if(set.contains(temp.charAt(j))){
                    flag=false;
                    for(int k=0; k<j; k++) set.remove(temp.charAt(k));
                    break;
                }
                set.add(temp.charAt(j));
            }
            max = Math.max(max,set.size());
            if(flag){
                rec(arr,set,i+1);
                for(int k=0; k<temp.length(); k++) set.remove(temp.charAt(k));
            }
            flag=true;
        }
    }
}
