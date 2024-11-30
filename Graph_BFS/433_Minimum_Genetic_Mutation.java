class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for(String st : bank) bankSet.add(st);

        Set<String> visSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        visSet.add(startGene);

        int level = 0;
        String choice = new String("ACGT");
        while(q.size() > 0){
            int size = q.size();
            while(size-->0){
                String curr = q.poll();
                if(curr.equals(endGene)) return level;
                for(char ch : choice.toCharArray()){
                    for(int i = 0; i < curr.length(); i++){
                        StringBuilder nbr = new StringBuilder(curr);
                        nbr.setCharAt(i, ch); // starts from A -> C -> G -> T
                        String newWord = nbr.toString();
                        if(!(visSet.contains(newWord)) && (bankSet.contains(newWord))){
                            visSet.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return -1;

    }
}