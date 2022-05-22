bool ispelin(const string&str){
    int l = 0, r= str.size()-1;
    while(l < r){
        if(str[l++] != str[r--]) return false;
    }
    return true;
}
vector<vector<string>> res;

void dfs(const string& str, int idx, vector<string>& v){
    if(idx == str.size()){
        res.push_back(v);
        return;
    }
    string s;
    for(int i = idx; i < str.size(); ++i){
        s.push_back(str[i]);
        if(ispelin(s)){
            v.push_back(s);
            dfs(str,i+1,v);
            v.pop_back();
        }
    }
}
class Solution {
public:
    vector<vector<string>> partition(string s) {
        res.clear();
        vector<string> v;
        dfs(s,0,v);
        
        return res;
    }
};