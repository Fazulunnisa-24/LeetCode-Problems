class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int totalwater=0;
        int lMax=0;
        int rMax=0;
        int start=0;
        int end=n-1;
        while(start<end){
            lMax=Math.max(lMax,height[start]);
            rMax=Math.max(rMax,height[end]);
            if(lMax<rMax){
                totalwater += lMax-height[start];
                start++;
            }
            else{
                totalwater+=rMax-height[end];
                end--;
            }
        }
        return totalwater;
    }
}