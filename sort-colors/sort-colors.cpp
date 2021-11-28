class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        int j = n-1;
        int end = n-1;
        int st = 0;
        while(st <= end){
            if(nums[end] == 2){
                nums[end--] = nums[j];
                nums[j--] = 2;
            }
            else if(nums[end]== 0){
                nums[end] = nums[st];
                nums[st++] = 0;
            }
            else{
                end--;
            }
        }
    }
};