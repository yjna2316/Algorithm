//

import java.util.*;
class Solution {
    class P {
        int open;
        int close;
        
        P (int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
    public int solution(int n) {
        int answer = 0; 
        
        Stack<P> stack = new Stack<>();  
        stack.push(new P(0, 0));
        
        while(!stack.isEmpty()) {
            P p = stack.pop();
            
            if (p.open > n) continue;
            if (p.close > p.open) continue;
            if (p.open + p.close == 2*n) {
                answer ++;
            }
            stack.push(new P(p.open + 1, p.close)); // 현 지점에서 ( 추가한 괄호 집합을 넣는다.
            stack.push(new P(p.open, p.close + 1)); // 현 지점에서 ) 추가한 괄호 집합을 넣는다.
        }
        return answer;
    }
}