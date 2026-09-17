class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> m1=new HashMap<>();
        for(char ch:magazine.toCharArray()){
            m1.put(ch,m1.getOrDefault(ch,0)+1);
        }
        for(char ch:ransomNote.toCharArray()){
            if(!m1.containsKey(ch)||m1.get(ch)==0){
                return false;
            }
            m1.put(ch,m1.get(ch)-1);
        }
        return true;
    }
}