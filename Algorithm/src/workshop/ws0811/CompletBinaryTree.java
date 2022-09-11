package workshop.ws0811;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompletBinaryTree {

	private char[] nodes;
	private int lastIndex;// 마지막 노드의 인덱스
	private final int SIZE;

	public CompletBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size + 1]; // 1 인덱스부터 사용
	}

	public boolean add(char e) {// 완전 이진 트리에 맞게 추가
		if (lastIndex == SIZE) {
			return false;
		}
		nodes[++lastIndex] = e;
		return true;
	}

	public void bfs() {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);// 루트노드 인덱스 부터

		while (!queue.isEmpty()) {// 방문대상이 있을 때까지 반복
			int current = queue.poll();// 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " ");// 방문할 시 해야할 일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex)
				queue.offer(current * 2);// 왼쪽자식
			if (current * 2 + 1 <= lastIndex)
				queue.offer(current * 2 + 1);// 오른쪽자식
		}

		System.out.println();
	}

	public void bfs2() {// 레벨로 나눠보기

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);// 루트노드 인덱스 부터

		while (!queue.isEmpty()) {// 방문대상이 있을 때까지 반복
			int size = queue.size();// 큐 크기확인, 동일 너비 대상의 개수

			// 반복 진입전 구현 큐 크기만큼만 반복
			while (--size >= 0) {// 먼저 size-1해서 0까지 반복, size+1로 설정해서 그럼
				int current = queue.poll();// 방문차례인 대상 정보 꺼내기
				System.out.print(nodes[current] + " ");// 방문할 시 해야할 일 처리

				// 현재 방문노드의 자식노드들을 대기열에 넣기
				if (current * 2 <= lastIndex)
					queue.offer(current * 2);// 왼쪽자식
				if (current * 2 + 1 <= lastIndex)
					queue.offer(current * 2 + 1);// 오른쪽자식

			}
			System.out.println();

		}

		System.out.println();
	}

	public void dfs() {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);// 루트노드 인덱스 부터

		while (!stack.isEmpty()) {// 방문대상이 있을 때까지 반복
			int current = stack.pop();// 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " ");// 방문할 시 해야할 일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex)
				stack.push(current * 2);// 왼쪽자식
			if (current * 2 + 1 <= lastIndex)
				stack.push(current * 2 + 1);// 오른쪽자식
		}

		System.out.println();
	}

	public void dfsByPreOrder(int current) {

		System.out.print(nodes[current] + " ");// 방문할 시 해야할 일 처리

		if (current * 2 <= lastIndex)
			dfsByPreOrder(current * 2);// 왼쪽자식
		if (current * 2 + 1 <= lastIndex)
			dfsByPreOrder(current * 2 + 1);// 오른쪽자식
	}

	public void dfsByInOrder(int current) {
		if (current > lastIndex)
			return;

		dfsByInOrder(current * 2);// 왼쪽자식
		System.out.print(nodes[current] + " ");
		dfsByInOrder(current * 2 + 1);// 오른쪽자식
	}
	
	public void dfsByPostOrder(int current) {
		if (current > lastIndex)
			return;

		dfsByInOrder(current * 2);// 왼쪽자식
		dfsByInOrder(current * 2 + 1);// 오른쪽자식
		System.out.print(nodes[current] + " ");// 내일 처리하기
	}

}
