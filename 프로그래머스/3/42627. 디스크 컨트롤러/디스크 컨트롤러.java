import java.util.*;

class Solution {
    private class PCB{
        int num;
        int req;
        int work;
        public PCB(int n, int r, int w){
            num = n;
            req = r;
            work = w;
        }
    }
    
    public int solution(int[][] jobs) {
        
        // 요청 시간 기준 정렬 필수
        Arrays.sort(jobs, (a, b)-> a[0] - b[0]);
        
        PriorityQueue<PCB> pq = new PriorityQueue<>((a,b)-> 
            a.work == b.work? a.req-b.req : a.work-b.work
        );
        
        int N = jobs.length;
        int time =0;
        int total = 0;
        int i=0;
        int count=0;
        
        while(count < N){
            // 지금시점까지 도착한 것만 pq에 넣어야함
            while(i<N && jobs[i][0] <= time){
                pq.add(new PCB(i, jobs[i][0], jobs[i][1]));
                i++;
            }
                
            if(pq.isEmpty()) {
                // 아직 들어온 작업이 없으면 시간을 앞으로 진행
                time = jobs[i][0];
            } else {
                PCB p = pq.poll();
                time += p.work;
                total += time - p.req;   
                count ++;
            }
        }
     
        return total/N;
    }
}
    