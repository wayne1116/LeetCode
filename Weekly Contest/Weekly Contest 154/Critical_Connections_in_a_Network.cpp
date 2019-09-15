class Solution {
private:
    vector<int> vect[100001];
    bool check[100001];
    int index[100001];
    int low[100001];
    int timestamp;
    vector<vector<int>> ans;
    
public:
    void dfs(int v, int parent){
        check[v]=true;
        index[v]=timestamp;
        low[v]=timestamp;
        ++timestamp;
        
        for(int i=0; i<vect[v].size(); i++){   
            int w=vect[v][i];
            if(w==parent) continue;
            
            if(check[w]==false){
                dfs(w, v);
                low[v]=min(low[v],low[w]);
                if(low[w]>index[v]) ans.push_back({v,w});
            }
            else low[v]=min(low[v],index[w]);
        }
    }
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        for(int i=0; i<connections.size(); i++){
            vect[connections[i][0]].push_back(connections[i][1]);
            vect[connections[i][1]].push_back(connections[i][0]);
        }
        for(int i=0; i<n; i++) check[i]=false;
        
        timestamp=1;
        for(int i=0; i<n; i++){
            if(check[i]==false) dfs(i,-1);
        }
        return ans;
    }
    
    
};
