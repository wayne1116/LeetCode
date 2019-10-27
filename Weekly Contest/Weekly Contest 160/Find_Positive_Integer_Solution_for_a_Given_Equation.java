/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1;
        int y = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(customfunction.f(x,y)<z){
            y=1;
            while(customfunction.f(x,y)<z) ++y;
            if(customfunction.f(x,y)==z) break;
            ++x;
        }
        
        int j = y;
        int i = x;
        while(true){
            if(j<=0) break;
            while(customfunction.f(i,j)>z) --j;
            if(customfunction.f(i,j)==z && j>0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                result.add(temp);
            }
            ++i;
        }
        return result;
    }
}
