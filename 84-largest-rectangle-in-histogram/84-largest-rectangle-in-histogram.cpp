struct INFO{
  int h, idx;  
};

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<INFO> st;
        int res = 0;
        INFO now;
        for(int i = 0; i < heights.size(); ++i){
            if(!st.empty()) now = st.top();
            int rmin = i;
            while(!st.empty() && now.h > heights[i]){
                st.pop();
                int idx = now.idx;
                int h = now.h;
                int s = (i - idx)*h;
                rmin = idx;
                if(res < s) res = s;
                if(!st.empty()) now = st.top();
            }
            st.push({heights[i], rmin});
        }
        while(!st.empty()){
            now = st.top(); st.pop();
            int h = now.h;
            int idx = now.idx;
            int s = (heights.size()-idx)*h;
            if(res < s) res = s;
        }
        return res;
    }
};