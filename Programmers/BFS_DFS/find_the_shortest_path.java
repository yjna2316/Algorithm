import java.util.*;
class Solution {
    // 현재 위치 (x, y)를 동시에 표현하기 위해서 class 생성
    class Postion {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValid(int width, int height) {
            if (x < 0 || x >= width) return false;
            if (y < 0 || y >= height) return false;
            return ture;
        }
    }

	public int solution(int[][] maps) {
        int mapHeight = maps.length;
        int mapWidth = maps[0].length;

		Queue<Position> queue = new LinkedList<>(); // player가 움직이고 있는 현재 위치를 큐에 넣는다.
        int[][] count = new int[mapHeight][mapWidth]; // 그 위치까지의 최단 거리
        boolean[][] visited = new boolean[mapHeight][mapWidth]; // 지나온 길인지 아닌지 확인하기 위한 용도   
        
        queue.offer(new Position(0, 0)); // Player를 시작 위치로 이동시킨다.
        count[0][0] = 1; // 시작점까지 1칸 움직임 
        visited[0][0] = true; // 시작점 지나갑니다.

        final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        if (!queue.empty()) {
            Position current = queue.poll(); // 현재 위치를 큐에서 꺼내온다.
            int current_count = count[current.y][current.x]; // 현재 위치 까지 최단 거리
         

            for (int i = 0; i < moving.length; ++i) {
                Position next = new Position(current.x + moving[i][0], current.y + moving[i][1]); // 다음 위치           
                if (!next.isValid(mapWidth, mapHeight)) continue;
                if (visited[next.y][next.x]) continue;
                if (maps[next.y][next.x] == 0) continue; 

                count[next.y][next.x] = current_count + 1;
                visited[next.y][next.x] = true;
                queue.offer(next);
            }            
        }
        int answer = count[mapHeight-1][mapWidth-1];
        return (answer > 0) ? answer : - 1;
	}
}