/**
 * S1. https://programmers.co.kr/learn/courses/30/lessons/43163
 */
import java.util.*;

class Solution {
    class Word {
        int depth;
        String word;
        
        public Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
            
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited  = new boolean[words.length];
        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()) {
            Word curr = queue.poll();
            for (int i = 0; i < words.length; ++i) {
                if (visited[i]) continue; // 이미 큐에 넣은 상태면 pass
                int diff = 0;
                String word = words[i];
                for (int j = 0; j < word.length(); ++j) {
                    if (curr.word.charAt(j) != word.charAt(j)) ++diff;
                } 
                if (diff > 1) continue; // 두 개이상의 알파벳이 바뀐 단어이면 pass
                if (word.equals(target)) return curr.depth + 1;
                queue.offer(new Word(word, curr.depth + 1));
                visited[i] = true; 
            }
        }
        return 0;
    }
}

/**
 * S2. LinkedList로 구현 
 */
import java.util.*;
class Solution {
    class Node {
        String next;
        int edge;
        
        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
            
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        q.offer(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {  // 현재 노드가 target이면, 이 노드의 edge를 반환한다.
                return cur.edge;
            }

            for (int i = 0; i < words.length; ++i) {
                // 방문한 적이 없고 1개의 알파벳만 바뀐 단어만 큐에 넣는다.
                if(!visited[i] && isValid(cur.next, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.edge + 1));
                }
            }
        }
        return 0;
    }

    public boolean isValid(String cur, String word) {
        int count = 0;
        for(int i = 0; i < word.length(); ++i) {
            if (cur.charAt(i) != word.charAt(i)) {
                count ++;
            }
        }
        return count > 1;
    }
}