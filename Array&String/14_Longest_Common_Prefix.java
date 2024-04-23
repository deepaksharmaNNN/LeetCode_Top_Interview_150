class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< first.length(); i++){
            char a = first.charAt(i);
            char b = last.charAt(i);
            if(a == b) sb.append(a);
            else break;
        }
        return sb.toString();
    }
}