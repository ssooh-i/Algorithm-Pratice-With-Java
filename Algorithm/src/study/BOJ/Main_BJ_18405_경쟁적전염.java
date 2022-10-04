package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_18405_경쟁적전염 {
   
   static int[] se = {-1, 0, 1, 0};
   static int[] ga = {0, 1, 0, -1};

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       
       st = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       
       int[][] pan = new int[N][N];
       
       Queue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

         @Override
         public int compare(Node o1, Node o2) {
            if(o1.s != o2.s) return o1.s - o2.s;
            else return o1.num - o2.num;
         }
      });
       
       for(int i = 0; i < N; i++) {
          st = new StringTokenizer(br.readLine());
          for(int j = 0; j < N; j++) {
             pan[i][j] = Integer.parseInt(st.nextToken());
             if(pan[i][j] != 0) pq.add(new Node(i, j, pan[i][j], 0));
          }
       }
       st = new StringTokenizer(br.readLine());
       int S = Integer.parseInt(st.nextToken());
       int X = Integer.parseInt(st.nextToken()) - 1;
       int Y = Integer.parseInt(st.nextToken()) - 1;
       int cnt = 0;
       while(!pq.isEmpty()) {
          int size = pq.size();
          if(cnt++ >= S) break;
          for(int q = 0; q < size; q++) {
             Node cur = pq.poll();
             int y = cur.y;
             int x = cur.x;
             int num = cur.num;
             for(int i = 0; i < 4; i++) {
                int ys = y + se[i];
                int xg = x + ga[i];
                if(ys < 0 || xg < 0 || ys >= N || xg >= N || pan[ys][xg] != 0) continue;
                pan[ys][xg] = num;
                pq.add(new Node(ys, xg, num, cnt));
             }
          }
          for(int i = 0; i < N; i++) {
             System.out.println(Arrays.toString(pan[i]));
          }
          System.out.println();
       }
       System.out.println(pan[X][Y]);
       
   }

}
class Node {
   int y;
   int x;
   int num;
   int s;
   public Node(int y, int x, int num, int s) {
      super();
      this.y = y;
      this.x = x;
      this.num = num;
      this.s = s;
   }
}