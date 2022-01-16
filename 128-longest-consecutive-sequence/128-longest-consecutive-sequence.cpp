class Solution {
public:
    int pa[100001];
    int getParent(int i){
        if(pa[i] < 0) return i;
        return pa[i] = getParent(pa[i]);
    }
    void join(int a, int b) {
        int aa = getParent(a);
        int bb = getParent(b);
        if(aa == bb) return;
        if(pa[aa] < pa[bb]) {
            int t = aa;
            aa = bb;
            bb = t;
        }
        pa[bb] += pa[aa];
        pa[aa] = bb;
    }
    
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int,int> adj;
        int maxSize = 0;
        for(int i = 0; i < nums.size(); ++i){
            pa[i+1] = -1;
            adj[nums[i]] = i+1;
        }
        for(int i =0; i < nums.size(); ++i) {
            if(adj[nums[i]] != i+1) continue;
            int prev = nums[i]-1;
            int nxt = nums[i]+1;
            if(adj[prev]) join(adj[prev], i+1);
            if(adj[nxt]) join(adj[nxt], i+1);
        }
        
        for(int i = 0; i < nums.size(); ++i){
            if(pa[i+1] < 0) maxSize = max(maxSize, -pa[i+1]);    
        }
        return maxSize;
    }
};