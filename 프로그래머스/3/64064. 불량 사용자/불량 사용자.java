import java.util.*;

class Solution {
    private HashSet<String> visited;
    private HashSet<String> ans;
    public int solution(String[] user_id, String[] banned_id) {
        
        List<String>[] ban_user = new ArrayList[banned_id.length];
        visited = new HashSet<>();
        ans = new HashSet<>();
        
        for(int i=0; i< banned_id.length; i++){
            ban_user[i] = new ArrayList<>();
        }
        
        int answer = 1;
        
        // find all possible id
        for(int i=0; i<banned_id.length; i++){
            for(int j=0; j<user_id.length; j++){
                if(isEqual(user_id[j], banned_id[i])) {
                    ban_user[i].add(user_id[j]);
                }
            }
        }
        
        // count Combination
        comb(0, ban_user, new ArrayList<>());
        
        
        
        return ans.size();
    }
    
    public boolean isEqual(String user, String ban){
        // check size
        if(user.length() != ban.length()) return false;
        
        // check each char
        for(int i=0; i<user.length(); i++){
            char u = user.charAt(i);
            char b = ban.charAt(i);
            if(b =='*') continue;
            if(u != b) return false;
        }
        return true;
    }
    
    public void comb(int idx, List<String>[] adj, List<String> pass){
        
        if(pass.size() == adj.length){
            // set에서 중복처리를 위해 정렬해서 문자열 생성
            List<String> sorted = new ArrayList<>(pass);
            Collections.sort(sorted);
            ans.add(sorted.toString());
            return;
        }

            for(String nxt : adj[idx]){
                if(visited.contains(nxt)) continue;
                
                visited.add(nxt);
                pass.add(nxt);
                comb(idx+1, adj, pass);
                pass.remove(pass.size()-1);
                visited.remove(nxt);                
        }
        
    }
    
}