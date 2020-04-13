class Solution {
    public int numOfWays(int n) {
        long color1=6;
        long color2=6;
        long mod=1000000007;
        for(int i=1; i<n; i++) {
            long c1=color1;
            long c2=color2;
            color1=(2*c1+2*c2)%mod;
            color2=(2*c1+3*c2)%mod;
        }
        
        return (int)(((color1%mod)+(color2%mod))%mod);
    }
}
