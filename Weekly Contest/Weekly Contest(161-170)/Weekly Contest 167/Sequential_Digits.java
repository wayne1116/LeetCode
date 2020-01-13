class Solution {
    List<Integer> sol;
    void rec(int a, int number, int index){
        if(a>9) return;
        sol.add(number*10+a);
        rec(a+1, number*10+a, index+1);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        sol = new ArrayList<Integer>();
        for(int i=1; i<=9; i++){
            rec(i, 0, 0);
        }
        Collections.sort(sol);
        int start = sol.size();
        for(int i=0; i<sol.size(); i++){
            if(sol.get(i)>=low){
                start=i;
                break;
            }
        }
        int end = sol.size();
        for(int i=0; i<sol.size(); i++){
            if(sol.get(i)>high){
                end=i;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=start; i<end; i++){
            result.add(sol.get(i));
        }
        return result;
    }
}
