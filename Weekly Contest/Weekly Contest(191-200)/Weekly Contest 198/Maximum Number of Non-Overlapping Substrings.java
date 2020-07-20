class Solution {
	public List<String> maxNumOfSubstrings(String s) {
		int[][] range=new int[26][3];
		int[] group=new int[26];
		boolean[][] overlap=new boolean[26][26];
		for(int i=0; i<26; i++) {
			range[i][0]=1000000;
			range[i][1]=1000000;
			range[i][2]=i;
			group[i]=-1;
			Arrays.fill(overlap[i], false);
		}
    
		for(int i=0; i<s.length(); i++) {
			int c=s.charAt(i)-'a';
			if(range[c][0]==1000000) {
				range[c][0]=i;
				range[c][1]=i;
			}
			range[c][1]=i;
			for(int j=0; j<26; j++) {
				if(range[j][0]<=range[c][0] && range[c][0]<=range[j][1] && range[c][1]>=range[j][1] || 
				   range[c][1]<=range[j][1] && range[c][0]<=range[j][0] && range[c][1]>=range[j][0]){
					overlap[c][j]=true;
					overlap[j][c]=true;
				}
			}
		}
    
		Queue<Integer> queue=new LinkedList<Integer>();
		int groupid=0;
		for(int i=0; i<26; i++) {
			if(group[i]==-1 && range[i][0]<1000000) {
				int start=range[i][0];
				int end=range[i][1];
				queue.offer(i);
				group[i]=groupid;
				while(queue.size()>0) {
					int node=queue.poll();
					for(int j=0; j<26; j++) {
						if(group[j]==-1 && overlap[j][node]) {
							group[j]=groupid;
							start=Math.min(start, range[j][0]);
							end=Math.max(end, range[j][1]);
							queue.offer(j);
						}
					}
				}
				for(int j=0; j<26; j++) {
					if(group[j]==groupid) {
						range[j][0]=start;
						range[j][1]=end;
					}
				}
				++groupid;
			}
		}
    
		Arrays.sort(range, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if(a[1]==b[1])
					return a[0]-b[0];
				return a[1]-b[1];
			}
		});
    
		int[][] dp=new int[26][3];
		int max=1;
		for(int i=0; i<26; i++) {
			if(range[i][0]==1000000)
				break;
			int len=range[i][1]-range[i][0]+1;
			dp[i][0]=1;
			dp[i][1]=len;
			dp[i][2]=-1;
			for(int j=i-1; j>=0; j--) {
				if(range[i][0]>range[j][1]) {
					if(dp[i][0]<dp[j][0]+1) {
						dp[i][0]=dp[j][0]+1;
						dp[i][1]=dp[j][1]+len;
						dp[i][2]=j;
					}
					else if(dp[i][0]==dp[j][0]+1 && dp[i][1]>dp[j][1]+len) {
						dp[i][1]=dp[j][1]+len;
						dp[i][2]=j;
					}
					max=Math.max(max, dp[i][0]);
				}
			}
		}
    
		int index=-1;
		int len=1000000;
		for(int i=0; i<26; i++) {
			if(range[i][0]==1000000)
				break;
			if(max==dp[i][0] && len>dp[i][1]) {
				len=dp[i][1];
				index=i;
			}
		}
    
		List<String> result=new ArrayList<String>();
		while(index>=0) {
			result.add(s.substring(range[index][0], range[index][1]+1));
			index=dp[index][2];
		}
    
		return result;
	}
}
