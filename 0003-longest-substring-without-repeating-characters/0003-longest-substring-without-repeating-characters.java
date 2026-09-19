class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h=new HashSet<>();
        int l=0;
        int max=0;
        for(int r=0;r<s.length();r++){
            while(h.contains(s.charAt(r))){
                h.remove(s.charAt(l));
                l++;
            }
            h.add(s.charAt(r));
            max=Math.max(max,r-l+1);
        }
        return max;
    }

}