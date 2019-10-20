
struct node{
	int start;
	int end;
	int profit;
};
struct node lnode[60000]; 
int cmp(const void *x, const void *y)
{
	if(((struct node*)x)->end>((struct node*)y)->end) return 1;
	else if(((struct node*)x)->end==((struct node*)y)->end){
		if(((struct node*)x)->start>((struct node*)y)->start) return 1;
		else if(((struct node*)x)->start==((struct node*)y)->start) 
				return ((struct node*)x)->profit-((struct node*)y)->profit;
	}
	return 0;
} 

int jobScheduling(int* startTime, int startTimeSize, int* endTime, int endTimeSize, int* profit, int profitSize){
    int a = startTimeSize;
	int i;
	int result[60000];
	int left, right, middle;
	int Max;
    
    
    for(i=0; i<a; i++){
        lnode[i].start=startTime[i];
        lnode[i].end=endTime[i];
        lnode[i].profit=profit[i];
    }
    qsort(lnode,a, sizeof(lnode[i]),cmp);
	
	for(i=0; i<a; i++) result[i]=0;
	result[0]=lnode[0].profit;
	
	for(i=1; i<a; i++){
			left=0;
			right=i-1;
			while(left<=right){
				middle=(left+right)>>1;
				if(lnode[middle].end>lnode[i].start) right=middle-1;
				else left=middle+1;
			}
			if(right==-1)
				result[i]=result[i-1]>lnode[i].profit?result[i-1]:lnode[i].profit;
            else
                result[i]=result[i-1]>lnode[i].profit+result[right]?result[i-1]:lnode[i].profit+result[right];
			//else
			//	result[i]=lnode[i].profit;
	}
    return result[a-1];
}
