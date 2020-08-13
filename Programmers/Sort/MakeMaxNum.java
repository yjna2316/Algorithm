/** 
 * 문제: https://programmers.co.kr/learn/courses/10302/lessons/62948
 * 접근 과정: 
 * 1. 모든 숫자의 조합을 만든 후 그 중 가장 큰 숫자 반환 => 숫자가 길어지면 표현 범위를 넘을 수 있다. 
 *     => 반환 형태가 문자열이네 -> 숫자를 문자열로 연결 짓기
 * 2. 큰 숫자 순으로 정렬했다고 큰 수가 되진 않네 (ex) 6,10,2 -> 1062 < 6210) => 숫자가 아닌 문자 정렬(내림차순) 후에 조합을 해보자.
 *     => 주의! s1, s2 비교가 아닌 s1+s2, s2+s1 비교를 해야한다.
 */



/** 
 *  s1. 버블 정렬을 이용한 방법
 *  시간 초과 발생
 *  이유: 버블 정렬은 시간 복잡도(o(n^2))가 크다.
 */
class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 배열로 변환
        String[] str_numbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            str_numbers[i] = Integer.toString(numbers[i]);
        }

        // 내림차순 정렬
        for (int i = 0; i < str_numbers.length - 1; ++i) {
            for (int j = i + 1; j < str_numbers.length; ++j) {
                String s1 = str_numbers[i];
                String s2 = str_numbers[j];
                if((s1+s2).compareTo(s2+s1) < 0) {
                    str_numbers[i] = s2;
                    str_numbers[j] = s1;
                }
            }
        }
        
        String answer = "";
        for (String val : str_numbers) {
            answer += val;
        }

        return (answer.charAt(0) == '0') ? "0" : answer;
    }
}


/**
 *  s2. 자바 라이브러리를 사용한 방법
 *  권장 방법. 시간 초과 발생 안함
 */
 import java.util.*;
 class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 배열로 변환
        String[] str_numbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            str_numbers[i] = Integer.toString(numbers[i]);
        }

        // 내림차순
        for (int i = 0; i < str_numbers.length - 1; ++i) {
            for (int j = i + 1; j < str_numbers.length; ++j) {
                Arrays.sort(str_numbers, new Comparator<String>() { 
                    public int compare(String s1, String s2) {
                        return (s2+s1).compareTo(s1+s2);
                    }
                })
            }
        }
        
        String answer = "";
        for (String val : str_numbers) {
            answer += val;
        }

        return (answer.charAt(0) == '0') ? "0" : answer;
    }
}

/**
 *  s3. s2 리팩토링 버전 (Java 8의 람다함수 이용)
 *  권장 방법. 시간 초과 발생 x 
 */
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 배열로 변환
        String[] str_numbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            str_numbers[i] = Integer.toString(numbers[i]);
        }

        /**
        *  내림차순 정렬 (람다함수 이용)
        *  Arrays.sort 두번째 arg는 Comparator 한 종류 밖에 없기 때문에 안 써줘도 컴파일러가 알아서 인지한다.
        *  Comparator 메소드는 compare 하나 밖에 없기 때문에 안 써줘도 컴파일러가 알아서 인지한다.
        *  str_numbers은 String 배열이기 때문에 String 타입도 생략 가능하다.
        */ 
        Arrays.sort(str_numbers, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        
        String answer = "";
        for (String val : str_numbers) {
            answer += val;
        }

        // 첫번째 숫자가 0일 경우 
        // return (answer.charAt(0) == '0') ? "0" : answer;
        return (answer.startsWith("0")) ? "0" : answer;
    }
}

/**
 *  s4. s3 리팩토링 버전 (Stream 이용)
 *  권장 방법. 시간 초과 발생 x 
 */
import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열 배열로 변환한 후 내림차순 정렬
        // 메소드 레퍼런스로 다음처럼 축약 가능
        // .mapToObject(n -> String.valueOf(n)) <==> .mapToObject(String::valueOf)
        String answer = IntStream.of(numbers) // <- intStream으로 반환
                 .mapToObj(String::valueOf) // 
                 .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                 .collect(Collectors.joining());

        return (answer.startsWith("0")) ? "0" : answer;
    }
}