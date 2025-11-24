import java.util.*;

class Solution {

    static class Plan {
        String name;
        int start;      // 시작 시각(분)
        int remain;     // 남은 시간(분)

        Plan(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {
        int n = plans.length;
        List<Plan> list = new ArrayList<>();

        // 1) 문자열 plans -> Plan 객체 리스트로 변환
        for (String[] p : plans) {
            String name = p[0];
            int start = timeToMinute(p[1]);
            int play = Integer.parseInt(p[2]);
            list.add(new Plan(name, start, play));
        }

        // 2) 시작 시각 기준 정렬
        list.sort(Comparator.comparingInt(o -> o.start));

        Stack<Plan> stack = new Stack<>();
        List<String> finished = new ArrayList<>();

        // 첫 과제부터 처리
        stack.push(new Plan(list.get(0).name, list.get(0).start, list.get(0).remain));
        int currentTime = list.get(0).start;

        for (int i = 1; i < n; i++) {
            Plan next = list.get(i);
            int nextStart = next.start;

            // 현재 시간부터 다음 과제 시작 전까지 할 수 있는 만큼 처리
            while (!stack.isEmpty() && currentTime < nextStart) {
                Plan cur = stack.peek();

                int canWork = nextStart - currentTime;
                if (cur.remain <= canWork) {
                    // 현재 과제를 다 끝낼 수 있음
                    currentTime += cur.remain;
                    finished.add(cur.name);
                    stack.pop();
                } else {
                    // 다음 과제 시작 전에 다 못 끝냄 → 남은 시간 줄이고 종료
                    cur.remain -= canWork;
                    currentTime = nextStart;
                }
            }

            // 새로운 과제 시작
            stack.push(new Plan(next.name, next.start, next.remain));
            currentTime = nextStart;
        }

        // 남은 과제들: 최근에 멈춘 순서대로 마저 수행
        while (!stack.isEmpty()) {
            Plan cur = stack.pop();
            finished.add(cur.name);
        }

        return finished.toArray(new String[0]);
    }

    private int timeToMinute(String t) {
        String[] parts = t.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}