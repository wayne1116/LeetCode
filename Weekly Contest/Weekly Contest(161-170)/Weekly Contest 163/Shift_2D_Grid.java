class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row=grid.length;
        int col=grid[0].length;
        int total=row*col;
        int shift=k%total;
        int[] arr=new int[total];
        int curr=0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) arr[curr++]=grid[i][j];
        }
        
        shift=(total-shift)%total;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> temp;
        for(int i=0; i<row; i++){
            temp=new ArrayList<Integer>();
            for(int j=0; j<col; j++){
                temp.add(arr[shift]);
                shift=(shift+1)%total;
            }
            result.add(temp);
        }
        return result;
    }
}
