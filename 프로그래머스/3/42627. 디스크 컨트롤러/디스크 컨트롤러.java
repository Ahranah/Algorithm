import java.util.*;

class Solution {
    // PCB 클래스는 굳이 필요 없다. 메모리만 먹는다. 
    // int[] 배열 그대로 쓰거나 필요하면 쓰되, 여기선 간단히직관적으로 간다.

    public int solution(int[][] jobs) {
        // 1. 요청 시간 오름차순 정렬 (기본)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 2. 수행 시간 짧은 순 우선순위 큐 (SJF 핵심)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int answer = 0;
        int count = 0; // 처리된 작업 개수
        int jobIdx = 0; // jobs 배열 인덱스
        int now = 0; // 현재 시간

        // 모든 작업이 처리될 때까지 반복
        while (count < jobs.length) {

            // 1. 현재 시간(now)까지 도착한 모든 작업을 큐에 넣음
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= now) {
                pq.add(jobs[jobIdx]);
                jobIdx++;
            }

            // 2. 큐가 비어있다면? (공백기 발생) -> 시간을 다음 작업 도착 시간으로 점프
            if (pq.isEmpty()) {
                now = jobs[jobIdx][0];
            } 
            // 3. 작업 수행 (하나만 꺼내서 수행!)
            else {
                int[] cur = pq.poll();
                answer += (now + cur[1]) - cur[0]; // (대기+수행) - 요청시간 = 반환시간
                now += cur[1]; // 시간 흐름
                count++; // 작업 완료 카운트
            }
        }

        return answer / jobs.length;
    }
}