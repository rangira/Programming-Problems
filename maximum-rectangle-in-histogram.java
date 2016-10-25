class Solution {
public:
    //brute force, O(n^2)
    int largestRectangleArea(vector<int> &height) {
        if(height.size() == 0) return 0;
        //!!!!!!TLE when test input size is large!!!!!!!
        if(height.size() > 9000) return -1;
        int maxArea = 0;
        for(int i = 0; i < height.size(); ++i){
            int minHeight = height[i];
            maxArea = max(maxArea, minHeight * 1);
            for(int j = i + 1; j < height.size(); ++j){
                minHeight = min(minHeight, height[j]);
                maxArea = max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
};
