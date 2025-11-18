import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int play = timeToSec(play_time);
        int adv = timeToSec(adv_time);
        
        long[] times = new long[play+2];
        
        
        // 로그 누적
        for (String log : logs) {
            String[] parts = log.split("-");
            int start = timeToSec(parts[0]);
            int end = timeToSec(parts[1]);
            times[start] += 1;
            // 시간에 보고있는 사람수 누적합
            // times[i] += time[i-1] 로 더해지므로 
            // 1명이 더해져 있던 걸 마지막 시간에서는 -1로 빼줘야함
            times[end] -= 1;
        }
        
        // 해당 시간에 영상을 보고 있는 사람의 누적합
        for(int i=1; i<=play; i++){
            times[i] += times[i-1];
        }
        
        long[] sum = new long[play+2];
        sum[0] = times[0];
        
        // 0부터 i까지 누적된 시청시간의 합:한 초당 times[i]만큼 증가
        for(int i=1; i<=play; i++){
            sum[i] = sum[i-1] + times[i];
        }
        
        

        // 초기 구간 [0, adv) 합
        long maxWatch = sum[adv - 1];
        int bestStart = 0;

        // [start, start+adv) = sum[start+adv-1] - sum[start-1]
        for (int start = 1; start + adv - 1 <= play; start++) {
            int end = start + adv - 1;
            long watch = sum[end] - sum[start - 1];
            if (watch > maxWatch) {
                maxWatch = watch;
                bestStart = start;
            }
        }

        return secToTime(bestStart);
    }
    
        // "hh:mm:ss" -> 초(int)
    private int timeToSec(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        int s = Integer.parseInt(t[2]);
        return h * 3600 + m * 60 + s;
    }
    
    public String secToTime(int sec){
	int h = sec/3600 ;
	int m = (sec % 3600) / 60;
  int s = sec % 60;
  
  return String.format("%02d:%02d:%02d", h, m ,s);
    }
    
}