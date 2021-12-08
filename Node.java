

public class Node<T> {

	private T data;
	private Node<T> Next;
	//public int levelll;


	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	public Node<T> getNext() {
		return Next;
	}

	public void setNext(Node<T> next) {
		Next = next;
	}

	public Node(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
