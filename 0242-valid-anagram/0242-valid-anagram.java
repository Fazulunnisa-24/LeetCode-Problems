class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] c=new int[26];
        for(int i=0;i<s.length();i++){
            int in=s.charAt(i)-'a';
            c[in]++;
        }
        for(int i=0;i<t.length();i++){
            int in=t.charAt(i)-'a';
            c[in]--;
        }
        for(int i=0;i<26;i++){
            if(c[i]!=0){
                return false;
            }
        }
        return true;
    }
}