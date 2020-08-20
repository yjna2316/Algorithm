/** 
 * 비선형 데이터의 모든 경우를 탐색해야 함
 * 이전 데이터에서 새로운 분기가 쳐지고 한 분기 탐색이 끝나면 이전 분기점으로 돌아가서 다음 분기로 가는 패턴
 **/
import java.util.*;
class Solution {
    class S {
        int count; // 지금까지 더해진 숫자의 갯수
        int sum; // 누적 합
        
        S(int count, int sum) {
            this.count = count; 
            this.sum = sum;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<S> stack = new Stack<>();
        stack.push(new S(0, 0)); // 초깃값으로 0 넣고 시작
       
        while(!stack.isEmpty()) {
            S s = stack.pop(); 
            if (s.count == numbers.length && s.sum == target) {
                answer++;
                continue;
            }
            if (s.count + 1 > numbers.length) continue;
            stack.push(new S(s.count + 1, s.sum + numbers[s.count])); // 양수를 더한다. -> 더한 숫자 갯수 1증가, 합도 증가
            stack.push(new S(s.count + 1, s.sum - numbers[s.count])); // 음수를 더한다. 
        }
        
        return answer;
    }
}