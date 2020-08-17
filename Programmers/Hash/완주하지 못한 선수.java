// s1. ArrayList사용 -> 시간 초과 발생
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> list = new ArrayList<>();
        
        for (String p : participant) {
            list.add(p);
        }
    
        for (String c : completion) {
            list.remove(c);
        }
        

        return list.get(0);
    }
}