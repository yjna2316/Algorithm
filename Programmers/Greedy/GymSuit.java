// https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
// Array <= Best
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        int answer = n;

        for (int l : lost) 
            students[l]--;
        for (int r : reserve) 
            students[r]++;

        for (int i = 1; i < students.length; i++) {
            if(students[i] == -1) {
                if(students[i-1] == 1) {
                    students[i]++;
                    students[i-1]--;
                }else if(i+1 < students.length && students[i+1] == 1) {
                    students[i]++;
                    students[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}

// ArrayList
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int fail = 0; // 체육복 없는 학생 수
        int left = 0, right = 0;
        int value = 0;
        List<Integer> reserve_arr = new ArrayList<>();  
        for (int val: reserve) 
        {
            reserve_arr.add(val);
        }
        
        for (int i = 0; i < lost.length; ++i) 
        {
            if (reserve_arr.contains(Integer.valueOf(lost[i]))) 
            {
                reserve_arr.remove(Integer.valueOf(lost[i]));
                lost[i] = -1;  
            } 
        }
        
        for (int num : lost) 
        {
            if (num == -1) {
                continue;
            }

            left = num - 1;  
            right = num + 1;   

            if (!reserve_arr.isEmpty() && reserve_arr.contains(left)) 
            {
                value = left; 
            } else if (!reserve_arr.isEmpty() && reserve_arr.contains(right)) 
            { 
                value = right;                
            } else 
            {
                fail += 1;
                continue;
            }
            reserve_arr.remove(Integer.valueOf(value));
        }

        return n - fail;
    }
}