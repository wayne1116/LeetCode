class Solution {
    public String countAndSay(int n) {
        String line ="1";
        
        for(int i=2; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            int j=1;
            int count = 1;
            
            while(j<line.length()){
                if(line.charAt(j-1)!=line.charAt(j)){
                    sb.append(Integer.toString(count));
                    sb.append(line.charAt(j-1));
                    count = 1;
                }
                else ++count;
                ++j;
            }
            sb.append(Integer.toString(count));
            sb.append(line.charAt(j-1));
            line=sb.toString();
        }
        return line;
    }
}