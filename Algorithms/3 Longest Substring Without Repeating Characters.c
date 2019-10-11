
int lengthOfLongestSubstring(char * s){
    int len=strlen(s);
    int location[256];
    int i;
	int Max = 0;
	int flag = 0;
	int dis;
	int temp;
	int pre=-1;

    for(i=0; i<256; i++) location[i]=-1;
	for(i=0; i<len; i++){
		temp = s[i];
		if(location[temp]!=-1){
			pre=max(pre,location[temp]);
			dis=i-pre;
			Max=max(Max,dis);
			flag=1;
		}
		else{
			if(flag){
				dis=i-pre;
				Max=max(Max,dis);
			}
			else Max=i+1;    // no repeat numbers
		}
		
		location[temp]=i;
	}
    return Max;
}

int max(int a, int b)
{
	return a>b?a:b;	
}