/**
* 접근
* 괄호의 갯수로 문제를 접근한다.
* 열린 괄호 갯수와 닫힌 괄호 갯수를 추적
*
* 조건
* 열리는 괄호를 먼저 배치한다.
* 그 이후에 닫히는 괄호를 배치한다.
*
* 종료조건
* 괄호는 N개 이상 사용할 수 없다.
* 닫히는 괄호의 개수가 열리는 괄호 개수보다 클 수 없다. ex. ( ) )
* 열린 괄호 + 닫힌 괄호의 합이 2*N일 때 갯수 카운트한다.
**/

import java.util.*;
class Solution {
    // 열.닫 괄호 갯수를 동시에 담을 수 있는 class 생성
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