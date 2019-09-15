class Solution {
public:
    int maxRepOpt1(string text) {
        int *number = new int[text.size()];
	    vector<pair<int,int> > vect[26];
	    int i;
	
	    number[0]=1;
	    for(i=0; i<26; i++) vect[i].clear(); 
	    for(i=1; i<text.size(); i++){
		    if(text[i]==text[i-1]) number[i]=number[i-1]+1;
		    else{
			    vect[text[i-1]-'a'].push_back(pair<int,int>(i,number[i-1]));
			    number[i]=1;
		    }
	    } 
	    vect[text[i-1]-'a'].push_back(pair<int,int>(i,number[i-1]));
	
	    int location;
	    int len;
	    int result = 0;
	    pair<int,int> temp;
	    int plus = 0;
	
	    for(i=0; i<26; i++){
		    if(!vect[i].empty()){
			    temp = vect[i][0];
			    location = temp.first;
			    len = temp.second;
			    result=max(result,len);
			    plus=0;
			    if(vect[i].size()>2) plus=1;
			
			    for(int j=1; j<vect[i].size(); j++){
				    temp = vect[i][j];
				    if(temp.first-temp.second-location==1){
					    result=max(result,len+temp.second+plus);
				    }
				    else result=max(result,len+1);
				    location = temp.first;
				    len = temp.second;
                    result=max(result,len+1);
			    }
		    }
	    }
        return result;
    }
};
