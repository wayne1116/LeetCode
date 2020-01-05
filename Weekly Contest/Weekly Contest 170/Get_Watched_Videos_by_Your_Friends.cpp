class Solution {
public:
    typedef pair<string, int> PAIR;
    static bool cmp_by_value(const PAIR& lhs, const PAIR& rhs) {
        if(lhs.second==rhs.second){
            if(lhs.first.compare(rhs.first)>0) return false;
            return true;
        }
        return lhs.second < rhs.second;
    }
    vector<string> watchedVideosByFriends(vector<vector<string>>& watchedVideos, vector<vector<int>>& friends, int id, int level) {
        
        int len=friends.size();       
        int lev[128];
        int index=1;
        for(int i=0; i<len; i++) lev[i]=-1;
        queue<int> qu;
        lev[id]=0;
        for(int i=0; i<friends[id].size(); i++){
            qu.push(friends[id][i]);
            lev[friends[id][i]]=index;
        }
        while(!qu.empty()){
            if(index==level) break;
            int l=qu.size();
            ++index;
            while(l-->0){
                int v=qu.front();
                qu.pop();
                for(int i=0; i<friends[v].size(); i++){
                    if(lev[friends[v][i]]==-1){
                        qu.push(friends[v][i]);
                        lev[friends[v][i]]=index;
                    }
                }
            }
        }
        unordered_map<string, int> mmap;
        for(int i=0; i<len; i++){
            if(lev[i]==level){
                vector<string> tmp=watchedVideos[i];
                for(int j=0; j<tmp.size(); j++){
                    if(mmap.find(tmp[j])!=mmap.end()) ++mmap[tmp[j]];
                    else mmap[tmp[j]]=1;
                }
            }
        }
        
        vector<string> result;
        vector<PAIR> temp(mmap.begin(), mmap.end());
        sort(temp.begin(), temp.end(), cmp_by_value);
        for(int i=0; i<temp.size(); i++) result.push_back(temp[i].first);
        return result;
    }
};
