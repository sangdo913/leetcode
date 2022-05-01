const int di[] = {0,1,0,-1};
const int dj[] = {1,0,-1,0};
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int d = 0;
        int cnt[2] = {(int)matrix[0].size(), (int)matrix.size()-1};
        int nc = 0;
        int ni =0, nj = 0;
        vector<int> res;
        int c = cnt[0];
        while(c) {
            while(c--){
                res.push_back(matrix[ni][nj]);
                ni += di[d];
                nj += dj[d];
            }
            ni -= di[d];
            nj -= dj[d];
            d = (d+1)%4;
            ni += di[d];
            nj += dj[d];
            cnt[nc]--;
            nc^=1;
            c = cnt[nc];
        }
        
        return res;
    }
};