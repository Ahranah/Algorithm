import java.util.*;

class Solution {
    static int N;
    
    class wordInfo {
        String w;
        int d;
        
        public wordInfo(String w, int d){
            this.w = w;
            this.d = d;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        N = begin.length();
        Deque<wordInfo> q = new ArrayDeque<>();
        Set<String> v = new HashSet<>();
        
        
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0;
        
        q.add(new wordInfo(begin, 0));
        v.add(begin);
        
        // BFS
        while (!q.isEmpty()){
            wordInfo cur = q.remove();
            if (cur.w.equals(target)) return cur.d;
            
            for (String nword : words) {
                if(check(cur.w, nword)) {
                    if(!v.contains(nword)){
                        v.add(nword);
                        q.add(new wordInfo(nword, cur.d+1));
                    }
                }
            }
        }
        
        return 0;
    }
    
    
    boolean check(String cur_word, String check_word){
        int cnt = 0;
        
        for (int i = 0; i < N; i++){
            if (cur_word.charAt(i) != check_word.charAt(i)){
                cnt ++;
                if (cnt > 1) return false;
            }
        }
        if (cnt == 1) return true;
        return false;
    }
}