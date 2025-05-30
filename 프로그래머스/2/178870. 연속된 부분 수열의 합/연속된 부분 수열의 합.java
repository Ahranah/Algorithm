class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = sequence[0];
        
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left <= right && right < n) {
            if (sum == k) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left++];
            } else if (sum < k) {
                right++;
                if (right < n) sum += sequence[right];
            } else {
                sum -= sequence[left++];
            }
        }

        return answer;
    }
}