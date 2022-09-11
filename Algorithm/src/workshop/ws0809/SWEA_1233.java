package workshop.ws0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {
	static Node[] nodes;
	static boolean flag;// 플래그 세우기

	static class Node {
		// 내 정점 번호, 연산자, 연결되는 자식 노드
		int index;
		String op; // Operators
		Integer left;// Integer -> int로 사용가능
		Integer right;
		double value;

		public Node(int index, String op, int left, int right) {
			this.index = index;
			this.op = op;
			this.left = left;
			this.right = right;
		}

		public Node(int index, double value) {
			this.index = index;
			this.value = value;
		}

		public Node(int index, String op) {
			this.index = index;
			this.op = op;
		}

		public Node(int index, String op, int left) {
			this.index = index;
			this.op = op;
			this.left = left;
		}

	}

	// op == null 일때 숫자 노드니까 숫자를 리턴하기
	// null이 아니면 연산자기 때문에 한번 더 내려가기
	public static double cal(int index) {
		if (flag) {// flag가 true면 유효성검사가 끝나서(안됨으로) 재귀를 끝내야함
			return 1;
		}
		if (nodes[index].op == null) {
			return nodes[index].value;
		} // else안해도 됨, return하면 종료해서 else로 이동 안함
		if ((nodes[index].left != null) && (nodes[index].right != null)) {

			if (nodes[index].op.equals("+"))
				return cal(nodes[index].left) + cal(nodes[index].right);
			if (nodes[index].op.equals("-"))
				return cal(nodes[index].left) - cal(nodes[index].right);
			if (nodes[index].op.equals("*"))
				return cal(nodes[index].left) * cal(nodes[index].right);
			if (nodes[index].op.equals("/")) {
				if (nodes[index].right == 0) {
					flag = true;
					return 1;
				}
				return cal(nodes[index].left) / cal(nodes[index].right); // false
			}
		}
		flag = true;
		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			nodes = new Node[N + 1];

			// 1 - 2 3 or 87 2
			for (int i = 1; i <= N; i++) {// 노드 입력
				String[] str = br.readLine().split(" ");
				if (str.length == 2) {
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						nodes[i] = new Node(Integer.parseInt(str[0]), str[1]);
					} else {
						nodes[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
					}
				} else if (str.length == 3) {
					nodes[i] = new Node(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]));
				} else {
					nodes[i] = new Node(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2]),
							Integer.parseInt(str[3]));
				}
			}
			flag = false;
			cal(1);
			System.out.print("#" + t + " ");
			if (flag) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
	}
}
