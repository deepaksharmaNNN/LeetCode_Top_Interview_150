class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(q.size() > 0){
            int curr = q.poll();
            topo.add(curr);
            for(int nbr : graph.get(curr)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0) q.offer(nbr);
            }
        }
        if(topo.size() < n) return new int[0];
        return topo.stream().mapToInt(Integer::intValue).toArray();
    }
}