class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result=new ArrayList<Integer>();
        int det1=tomatoSlices-(cheeseSlices<<1);
        int det2=-tomatoSlices+(cheeseSlices<<2);
        if(det1>=0 && (det1&1)==0 && det2>=0 && (det2&1)==0){
            result.add(det1>>1);
            result.add(det2>>1);
        }
        return result;
    }
}
