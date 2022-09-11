package workshop.ws0808;

public class SsafyStack<E> implements IStack<E>{
	
	private Node<E> top; //더미노드 아님!
	
	@Override
	public void push(E data) {//첫노드 삽입 알고리즘
		top = new Node<E>(data, top);
	}
	
	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("공백스택이여서 작업이 불가합니다.");
			return null;
		}
		
		Node<E> popNode = top; //삭제노드
		top = popNode.link;//다음링크를 탑으로 바꾸기
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("공백스택이여서 작업이 불가합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for(Node temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		return cnt;
	}

	

}
