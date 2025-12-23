import java.util.*;

class Solution {
    
    class Node {
        Map<Character, Node> child = new HashMap<>();
        // 이 노드를 경로로 가지는 단어의 수
        int count = 0;
    }
    
    class Trie {
        Node root = new Node();
        
        void insert(String str){
            Node cur = root;
            for (char c : str.toCharArray()){
                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
                // 해당 루트를 경로로 가지는 단어가 지나갈 때 마다 증가
                cur.count++;
            }
        }
        
        int search(String str){
            Node cur = root;
            int len = 0;
            for(char c : str.toCharArray()){
                cur = cur.child.get(c);
                len++;
                
                if (cur.count == 1) return len;
                // count 1이라는 건, 이 경로를 쓰는 단어가 나 하나뿐이라는 것이므로, 여기까지 입력하면 유일하게 식별됨
            }
            return len;
        }
    }
    public int solution(String[] words) {
        Trie trie = new Trie();
        for(String s: words) trie.insert(s);
        
        int answer = 0;
        for(String s: words) answer += trie.search(s);
        return answer;
    }
}