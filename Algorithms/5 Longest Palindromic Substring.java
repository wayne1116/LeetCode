class Solution { //Manacher's Algorithm
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        Character[] line = new Character[2*s.length()+3];
        for(int i=0; i<line.length; i++) line[i]='#';
        line[0]='^';
        line[line.length-1]='$';
        for(int i=2, j=0; i<line.length-1; i+=2, j++) line[i]=s.charAt(j);
        
        int center = 0;
        int radius = 0;
        int imirror = 0;
        
        int[] p = new int[line.length];
        p[0]=p[1]=0;
        p[2]=1;
        for(int i=3; i<line.length-1; i++) {
        	imirror=2*center-i;
        	if(radius>imirror && imirror>0) p[i]=Math.min(radius-i,p[imirror]);
        	else p[i]=0;
        	
        	while(line[i+1+p[i]]==line[i-1-p[i]]) ++p[i];
        	if(i+p[i]>radius) {
        		center=i;
        		radius=i+p[i];   
        	}
        }
        
        int maxcenter = 0;
        int maxlen = p[0];
        for(int i=1; i<line.length-1; i++) {
        	if(maxlen<p[i]) {
        		maxlen=p[i];
        		maxcenter=i;
        	}
        }
        StringBuilder result = new StringBuilder();
        for(int i=maxcenter-maxlen; i<=maxcenter+maxlen; i++) {
        	if(line[i]!='#'&&line[i]!='^'&&line[i]!='$') result.append(line[i]);
        }
        
        return result.toString();
    }
}