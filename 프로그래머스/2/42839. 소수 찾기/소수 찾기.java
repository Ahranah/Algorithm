import java.util.*;

class Solution {
    
    public HashSet<Integer> ans;
    public int N;
    public int solution(String numbers) {
        
        ans = new HashSet<>();
        N = numbers.length();
        int answer = 0;
       
        boolean[] v = new boolean[N];
        dfs(new StringBuilder(), numbers, v);

        for(int i: ans){
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    void dfs(StringBuilder current, String numbers, boolean[] v){
        
        if(current.length() != 0){
            ans.add(Integer.parseInt(current.toString()));
        }
        
        for(int i=0; i< N; i++){
            if(v[i]) continue;
            v[i] = true;
            dfs(current.append(numbers.charAt(i)), numbers, v);
            current.deleteCharAt(current.length()-1);
            v[i] = false;
        
        }
    }
    
    
    boolean isPrime(int n){
        if(n<2) return false;
         if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}