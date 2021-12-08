

public class QueueLinkedList <T extends Comparable<T>>{
	
	private Node<sNode> first;
	private Node<sNode> last; 
	
	
	public Node<sNode> getFirst() {
		return first;
	}

	public void setFirst(Node<sNode> first) {
		this.first = first;
	}

	public Node<sNode> getLast() {
		return last;
	}

	public void setLast(Node<sNode> last) {
		this.last = last;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(sNode<T> root) {
		Node<sNode> newNode = new Node<>(root);
		if (first == null)
			first = newNode;
		else
			last.setNext(newNode);
		last = newNode;
	}

	public sNode dequeue() {
		if (first == null)
			return null;
		sNode data = first.getData();
		first = first.getNext();
		if (first == null)
			last = null;
		return data;
	}

	public int length() {
		Node<sNode> curr = first;
		int counter = 0;
		while (curr != null) {
			counter++;
			curr = curr.getNext();
		}
		return counter;
	}
	
	public void traverse() {
		Node<sNode> curr = first;
		System.out.print("first-->");
		while (curr != null) {
			System.out.print(curr.getData() + "-->");
			curr = curr.getNext();
		}
		System.out.println("<--last");
	}

}

