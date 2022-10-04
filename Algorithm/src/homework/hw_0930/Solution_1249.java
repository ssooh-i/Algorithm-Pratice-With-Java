package homework.hw_0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249 {
    static int[] se = {-1, 0, 1, 0};
    static int[] ga = {0, 1, 0, -1};
    static int shortest;
    


    
    public static void main(String[] args) throws NumberFormatException, IOException {
//        System.setIn(new FileInputStream("input_1249"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int test_case = Integer.parseInt(br.readLine());
        
        for(int T = 1; T <= test_case; T++) {
            shortest = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int[][] d = new int[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(d[i], Integer.MAX_VALUE);
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            d[0][0] = 0;
            Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.d - o2.d;
                }
            });
            pq.add(new Node(0, 0, 0));
            
            while(!pq.isEmpty()) {
                Node cur = pq.poll();
                
                for(int i = 0; i < 4; i++) {
                    int ys = cur.y + se[i];
                    int xg = cur.x + ga[i];
                    if(ys < 0 || xg < 0 || ys >= N || xg >= N) continue;
                    if(d[ys][xg] > map[ys][xg] + cur.d) {
                        d[ys][xg] = map[ys][xg] + cur.d;
                        pq.add(new Node(ys, xg, d[ys][xg]));
                    }
                }
            }
            
            sb.append("#").append(T).append(" ").append(d[N - 1][N - 1]).append("\n");
            
            
        }
        
        System.out.println(sb.toString());
    }
}
class Node {
    int y;
    int x;
    int d;
    Node(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}