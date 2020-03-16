class CustomStack {
    int[] stack;
    int pointer;
    public CustomStack(int maxSize) {
        stack=new int[maxSize];
        pointer=0;
    }
    
    public void push(int x) {
        if(pointer<stack.length)
            stack[pointer++]=x;
        
    }
    
    public int pop() {
        if(pointer==0)
            return -1;
        
        return stack[--pointer];
    }
    
    public void increment(int k, int val) {
        int total=Math.min(k, pointer);
        for(int i=0; i<total; i++)
            stack[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
