class MajorityChecker {
    
    private int[] number;
    public MajorityChecker(int[] arr) {
        number = new int[arr.length];
        for(int i=0; i<arr.length; i++) number[i] = arr[i];
    }
    
    public int query(int left, int right, int threshold) {
        int voter =-1;
        int count=0;
        for(int i=left; i<=right; i++){
            if(count==0) voter=number[i];
            if(voter==number[i]) ++count;
            else --count;
        }
        
        count = 0;
        for(int i=left; i<=right; i++){
            if(voter==number[i]) ++count;
        }
        return count>=threshold?voter:-1;
    }
}
