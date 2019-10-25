class Solution {
public:
    int maxEqualFreq(vector<int>& nums) {
        if(nums.size()<4) return nums.size();
        unordered_map<int,int> numb_freq;
        unordered_map<int,int> freq_count;
        
        int result=0;
        for(int i=0; i<nums.size(); i++){
            int n = ++numb_freq[nums[i]];
            --freq_count[n-1];
            ++freq_count[n];
            if(freq_count[n-1]<=0) freq_count.erase(n-1);
            
            if(freq_count.size()==1 && (freq_count.begin()->first==1 || freq_count.begin()->second==1))  // case situation: [1,2,3,4,5] 
                result = max(result,i+1);                                                                //             and [1,1,1,1,1]        
            else if(freq_count.size()==2){
                unordered_map<int,int>::iterator iter1 = freq_count.begin();
                unordered_map<int,int>::iterator iter2 = ++freq_count.begin();
                unordered_map<int,int>::iterator temp;
                
                if(iter1->first>iter2->first) {
                    temp=iter1;
                    iter1=iter2;
                    iter2=temp;
                }
                
                if((iter1->first==1 && iter1->second==1)||(iter2->first-iter1->first==1 && iter2->second==1)) //case situation: [1,1,2,2,3]
                    result = max(result,i+1);                                                                 //            and [1,1,2,2,2]   
            }   
            
        }
        return result;
    }
};
