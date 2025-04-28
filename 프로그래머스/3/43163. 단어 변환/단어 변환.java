class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(begin, target, words, visited, 0);
        return answer==Integer.MAX_VALUE ? 0: answer;
    }
        
    private void dfs (String curr, String target, String[] words, boolean[] visited, int depth){
        if (curr.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }

        for(int i = 0; i < words.length ; i ++){
            if (!visited[i] && letterDiff(curr, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, visited, depth+1);
                // 실패한 경우 취소: 백트래킹
                visited[i] = false;
            }
        }
    }

    private boolean letterDiff(String a, String b){
        int cnt = 0;
        for (int i = 0; i<a.length(); i++){
            if (a.charAt(i) != b.charAt(i)) cnt ++;
        }
        return cnt == 1;
    }
}
        
