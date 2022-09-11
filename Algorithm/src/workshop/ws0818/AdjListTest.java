package workshop.ws0818;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjListTest {
	
	static class Node{ 
		//가중치가 있는 그래프라면 int weight;추가
		int to;
		Node next;
		
		public Node(int to, Node next) { //from은 기억할 필요없음, 인접리스트 간의 헤드들을 가지고 있으니까 필요없음
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//정점수
		int E = sc.nextInt();//간선수
		
		adjList = new Node[N]; //헤드 넣을 꺼임
		for (int i = 0; i < E; i++) { // 간선 수만큼 반복
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to, adjList[from]); // 새로 노드를 만들되
			//from의 인접리스트의 해드를 새로 만드는 노드로 바꿀 꺼, 단 원래있던해드였던 첫번째 노드를 현재노드 뒤에 물리는 것
			adjList[to] = new Node(from, adjList[to]);//무향그래프
			
		}
		visited = new boolean[N];
		dfs(0);
		Arrays.fill(visited, false);
		bfs();
	}
	
	private static void dfs(int cur) {
		visited[cur] = true; //방문처리를 맨 위로 뻬주면서 체크를 해줘서 0을 따로 true 안해줘도됨
		System.out.print((char) (cur + 'A'));

		// 현 정점의 인접정점들의 리스트에서 탐색
		//인접리스트의 헤드에 들어가야함
		for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {// 방문하지 않았으며, 인접한 경우
				dfs(temp.to);//탐색 다 안했으면 다음꺼 ㄱㄱ
			}

		}
	}
	
	private static void bfs() {
		
		visited[0] = true;
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			Node a1 = adjList[a];
			/* 노드를 방문했을 떄 할 일 */
			System.out.println(a);
			
			
			for(Node temp = a1; temp != null; temp = temp.next) {
				if(!visited[temp.to]) {
					q.add(temp.to);
					visited[temp.to] = true;
				}
			}
		}
		
	}
	

}
