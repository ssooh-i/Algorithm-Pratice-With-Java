package EX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Graph1 { //가중치가  없는 그래프
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 int n = 4; //정점의 개수 == 노드 개수
		 int m=5; //간선의 개수
		 
		 //인접리스트
		 ArrayList< ArrayList<Integer>> graph = new ArrayList<>();
		 
		 //인접리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
		 for(int i =0; i<=n; i++) {
			 graph.add(new ArrayList<>());
		 }
		 
		 for(int i=0; i<m; i++) {
			 String[] nv = br.readLine().split(" ");
			 int n1 = Integer.parseInt(nv[0]);
			 int n2 = Integer.parseInt(nv[1]);
			
			 graph.get(n1).add(n2); //양방향 연걸
			 graph.get(n2).add(n1);
		 }
		 
		 //1번 인접 리스트에서 4번 인접 리스트까지 출력
		  for(int i = 1; i<= 4 ; i++) {
			  bw.write(graph.get(i).toString());
		  }
		  
		  /*1  2
        *   1  3
        *   1  4
        *   2  4
        *   3  4*/
		  bw.close();
		  br.close();
	}
}
