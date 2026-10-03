class Solution {
    public int maximumWealth(int[][] accounts) {
        int r=0;
        for(int[] i:accounts){
            int s=0;
            for(int m:i){
                s+=m;
            }
            r=Math.max(r,s);
        }
        return r;
    }
}