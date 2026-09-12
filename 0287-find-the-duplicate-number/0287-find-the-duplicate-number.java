class Solution {
    public int findDuplicate(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int[] freq=new int[max+1];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
            if(freq[nums[i]]==2){
                return nums[i];
            }
        }
        return -1;
    }
}