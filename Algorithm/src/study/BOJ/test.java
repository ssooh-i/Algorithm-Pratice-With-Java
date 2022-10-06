package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test {
    
    static int[] se = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] ga = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[][] pan = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        List<Cloud> clouds = new ArrayList<>();
        
        // 초기 구름
        clouds.add(new Cloud(N - 2, 0));
        clouds.add(new Cloud(N - 1, 0));
        clouds.add(new Cloud(N - 2, 1));
        clouds.add(new Cloud(N - 1, 1));
        
        // 명령어 받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] cmd = new int[2];
            cmd[0] = Integer.parseInt(st.nextToken()) - 1; // 방향
            cmd[1] = Integer.parseInt(st.nextToken()); // 거리
            // 구름이 있던 곳 표시할 visit 배열
            boolean[][] visit = new boolean[N][N];
            // 각각의 구름을 커맨드에 맞게 이동 시키기
            for(int j = 0; j < clouds.size(); j++) {
                clouds.get(j).move(cmd[0], cmd[1], N, pan, visit);
            }
            // 각각의 구름이 있던 자리에 물복사 버그
            for(int j = 0; j < clouds.size(); j++) {
                clouds.get(j).waterPlus(pan, N);
            }
            // 앞의 구름은 삭제하고(버리고) 새로운 구름 만들기
            clouds = new ArrayList<>();
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < N; m++) {
                    // 이전에 구름이 있던 곳이면 구름 만들지 않기
                    if(visit[n][m]) continue;
                    // 물의 양이 2 이상이면 2 빼고 구름 만들기
                    if(pan[n][m] >= 2) {
                        pan[n][m] -= 2;
                        clouds.add(new Cloud(n, m));
                    }
                }
            }
        }
        
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res += pan[i][j];
            }
        }
        
        System.out.println(res);
        
        
        
    }

}
class Cloud {
    int y;
    int x;
    int[] se = {0, -1, -1, -1, 0, 1, 1, 1};
    int[] ga = {-1, -1, 0, 1, 1, 1, 0, -1};
    // 1, 3, 5, 7
    public Cloud(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }
    // 구름 움직이기
    void move(int d, int s, int N, int[][] pan, boolean[][] visit) {
        // 해당 방향(d)으로 s번 만큼 반복
        for(int i = 0; i < s; i++) {
            y = y + se[d];
            x = x + ga[d];
            // 경계밖으로 넘어가면 반대쪽으로 이동
            if(y < 0) y += N;
            else if(y >= N) y -= N;
            if(x < 0) x += N;
            else if(x >= N) x -= N;
        }
        // 이동이 끝난 후 구름이 있는 자리 표시해주기
        visit[y][x] = true;
        // 구름에서 비 내려 바구니의 물 양 + 1
        pan[y][x] += 1;
    }
    // 물복사 버그
    void waterPlus(int[][] pan, int N) {
        // 위에 있는 8방 중 대각선 방향만 골라서 탐색
        for(int i = 1; i < 8; i += 2) {
            int ys = y + se[i];
            int xg = x + ga[i];
            if(ys < 0 || xg < 0 || ys >= N || xg >= N) continue;
            // 대각선 방향에 물이 있으면 물 양 +1
            if(pan[ys][xg] != 0) pan[y][x]++;
        }
    }
}