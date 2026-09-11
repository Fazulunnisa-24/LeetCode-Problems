class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
            res[i]=nums[i];
        }
        Arrays.sort(res);
        return res;
    }
}