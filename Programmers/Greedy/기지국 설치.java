class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 0; 
        int position = 1;
        
        while (position <= n) {
            if (index < stations.length && stations[index] - w <= position) {
                position = stations[index] + w + 1;
                index += 1;
            } else {
                answer += 1;
                position += 2 * w + 1;
            }
        }
        return answer;
    }
}