package study.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//뱀과 사다리 게임
public class g5_16928 {
	static int N, M;
	static HashMap<Integer, Integer> map;

	public static int BFS() {
		int cnt = 0; // 주사위 돌린 횟수 저장
		boolean[] visited = new boolean[101]; // 방문표시
		Queue<Integer> q = new LinkedList<>(); // 큐 생성

		visited[1] = true; // 1번칸 true로 만들고 입장하기
		q.add(1);

		while (!q.isEmpty()) {// 큐가 비어있지 않으면 실행
			int size = q.size(); // q사이즈는 계속 변하니까 들어올때 사이즈를 저장

			for (int i = 0; i < size; ++i) {
				int now = q.poll();

				// 지금있는 위치가 도착지점인지 판단
				if (now == 100) { // 도착지점이다
					return cnt;
				}

				for (int dice = 1; dice < 7; ++dice) {
					int next = now + dice; // 다음 위치 = 지금 위치 + 주사위 눈

					if (next > 100) break; // 다음위치가 100 넘는다면 이동할 수 없음
					if (visited[next]) continue; // 방문한 곳이면 이동 안하고 다음꺼

					if (map.containsKey(next)) { // 맵에서 인자로 보낸 키가 존재하면 true, 없으면 false반환
						// 여기에 뭘 해야하지...
						next = map.get(next);// 키값으로 불러오기
						if (visited[next])
							continue; // 다시 방문체크 해주기
					}

					q.add(next); // 다음 위치 q에 넣어주기
					visited[next] = true;

				}
			}
			cnt++;// size만큼 한번 돌면 주사위 돌린 횟수 증가
		}
		return cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new HashMap<>();

		N = Integer.parseInt(st.nextToken()); // 사다리수
		M = Integer.parseInt(st.nextToken()); //뱀 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map.put(from, to);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map.put(from, to);
		}
		System.out.println(BFS());
	}

}
