// https://programmers.co.kr/learn/courses/10302/lessons/62946

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0, start = 0, end = 0, dist = 0;
        int range = 2 * w + 1;
    
        
        for (int st : stations) {
            end = st - w;
            dist = end - (start + 1);
            answer += (int)Math.ceil((float)dist / (float)range);
            start = st + w;
        }
        
        if (start <= n) {
            dist = n - start;
            answer += (int)Math.ceil((float)dist / (float)range);
        }
    

        return answer;
    }
}