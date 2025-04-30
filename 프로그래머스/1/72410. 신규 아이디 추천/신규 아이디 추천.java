import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // 1
       new_id = new_id.toLowerCase();
       
        //2 
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");
        
        //3 
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        //4
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()){
            sb.append(c);
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.'){
            sb.deleteCharAt(sb.length()-1);
        } 
         
        //5
        if (sb.length() == 0){
            sb.append("a");
        }
            
        
        //6
        if (sb.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }
        
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length()-1));
        }

        
        return sb.toString();
    }
}