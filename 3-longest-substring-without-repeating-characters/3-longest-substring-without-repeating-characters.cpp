int cnt[256];
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        for(int i = 0; i < 256; ++i) cnt[i] = 0;
        int not_unique = 0;
        int n = s.size();
        int i = 0,j = 0;
        int res = 0;
        for(; j < s.size(); ++j){
            while(i < j && not_unique){
                cnt[s[i]]--;
                if(cnt[s[i]] == 1) not_unique = 0;
                ++i;
            }
            res = max(res, j-i);
            if(cnt[s[j]] == 1) not_unique = 1;
            cnt[s[j]]++;
        }
        while(i < j && not_unique){
            cnt[s[i]]--;
            if(cnt[s[i]] == 1) not_unique = 0;
            ++i;
        }
        res = max(res, j-i);
        return res;
    }
};