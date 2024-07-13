class Solution {
    class Pair{
        String word;
        int level;
        Pair(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for(String words : wordList){
            set.add(words);
        }
        set.remove(beginWord);
        while(q.size() > 0){
            Pair pair = q.poll();
            
            String word = pair.word;
            int level = pair.level;
            
            if(word.equals(endWord)) return level;
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}