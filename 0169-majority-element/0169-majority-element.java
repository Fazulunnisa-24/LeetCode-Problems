class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>();
       int n=nums.length;
       for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       } 
       n=n/2;
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>n){
                return entry.getKey();
            }
       }
       return 0;
    }
}