// S1. hashmap 이용
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> counts = new HashMap<>();
       
        for(String[] c : clothes) {
            String type = c[1];
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        
        // map.forEach((key, value) -> System.out.println(key + ":" + value));
        // System.out.println(counts.values());

        int answer = 1;
        for (int c : counts.values()) {
            answer *= c + 1; 
        }
        
        return answer - 1;
    }
}

// S2. stream 이용
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                     .map(c -> c[1])
                     .distinct()
                     .map(type -> (int)Arrays.stream(clothes).filter(c -> c[1].equals(type)).count())
                     .map(c -> c + 1)
                     .reduce(1, (c, n) -> c * n) - 1;
    }
}