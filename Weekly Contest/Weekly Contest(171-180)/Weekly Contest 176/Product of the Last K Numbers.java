class ProductOfNumbers {
    List<Integer> conseq;
    int zeroindex=-1;
    public ProductOfNumbers() {
        conseq=new ArrayList<Integer>();
        zeroindex=-1;
    }
    
    public void add(int num) {
        if(num!=1){
            for(int i=conseq.size()-1; i>zeroindex; i--)
                conseq.set(i, conseq.get(i)*num);
        }
        if(num==0)
            zeroindex=conseq.size();
        
        conseq.add(num);
    }
    
    public int getProduct(int k) {
        int len=conseq.size();
        if(len-k<=zeroindex)
            return 0;
        return conseq.get(len-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
