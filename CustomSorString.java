// Time Complexity : O(m+n) m is length of order and n is length of s
// Space Complexity : O(n) for map and string builder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        if(s == null || s.length() == 0) return sb.toString();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i = 0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                while(cnt > 0){
                    sb.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(char c: map.keySet()) {
            if(map.containsKey(c)) {
                int cnt = map.get(c);
                while(cnt > 0){
                    sb.append(c);
                    cnt--;
                }
            }
        }

        return sb.toString();
    }
}