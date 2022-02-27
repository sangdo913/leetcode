int chk[81*32+1];
int cnt[81*32+1];
int square[10] = {0, 1, 4, 9, 16, 25, 36,49, 64, 81};
bool nfirst = 0;
class Solution {
public:
    bool isHappy(int n) {
        if(!nfirst){
           nfirst = true; 
            chk[0] = -1;
            chk[1] = 1;
            for(int i = 0; i <= 81*32; ++i) {
                int n = i;
                if(chk[n]) continue;
                for(int j = 0; j <= 81*32;++j) cnt[j] = 0;
                while(!chk[n] && cnt[n] < 82*31 ) {
                    cnt[n]++;
                    int b = 0;
                    while(n){
                        b += square[n%10];
                        n/=10;
                    }
                    n = b;
                }
                if(cnt[n] == 82*31) chk[n] = -1;
                for(int j = 0; j <= 81*32; ++j) if(cnt[j]) chk[j] = chk[n];  
            }
        }
        int b = 0;
        while(n) {
            b += square[n%10];
            n/=10;
        }
            
        return chk[b] == 1;
    }
};