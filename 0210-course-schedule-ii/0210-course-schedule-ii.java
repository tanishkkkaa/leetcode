class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            list.get(edge[1]).add(edge[0]);
        }
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[numCourses];
        int[] path = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0 && path[i] == 0){
                if(dfs(visited,path,i,list,result)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(result);
        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public boolean dfs(int[] visited, int[] path, int i, List<List<Integer>> list, 
    List<Integer> result){
        visited[i] = 1;
        path[i] = 1;
        for(int neighbour : list.get(i)){
            if(visited[neighbour] == 0){
                if(dfs(visited, path, neighbour, list, result)) return true;
            }else if(path[neighbour] == 1){
                return true;
            }
        }
        path[i] = 0;
        result.add(i);
        return false;
    }
}