import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> update = new HashMap<>();
        HashMap<String, Integer> rules = new HashMap<>();
        HashSet<String> isAdded = new HashSet<>();
        
        for(int i =0; i<terms.length; i++){
            String[] t = terms[i].split(" ");
            String key = t[0];
            int day = Integer.parseInt(t[1])*28;
            rules.put(key, rules.getOrDefault(key, 0)+day);
            
        }

        
        int todayDays = toDay(today);
        
        for(int i =0; i<privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String key = p[1];
            int prior = toDay(p[0]);
            int toAdd = rules.get(key);

            
            if ((prior + toAdd) <= todayDays) {
                result.add(i+1);   
            }
        } 
        
        
        return result.stream().mapToInt(i->i).toArray();
    }
    
    public int toDay(String date){
        int[] dateArray = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
       return dateArray[0]*12*28 + dateArray[1]*28+dateArray[2];
        
        
    }
}