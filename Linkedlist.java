//1191413--Mohammad hlhwly
public class Linkedlist<T extends Comparable<T>> {
	//varuble in linked list
	private Node<T> head;
	private Node<T> last;
	
	//getar and settar
	/**Return last*/
	public Node<T> getLast() {
		return last;
	}
	/**set*/
	public void setLast(Node<T> last) {
		this.last = last;
	}
	/**Return Head*/
	public Node<T> getHead() {
		return head;
	}
	/**set*/
	public void setHead(Node<T> headnode) {
		this.head = headnode;
	}
	
	// Checks if queue is empty.
	public boolean isEmpty() {
		return (head == null);
	}	
	
	//print in Linked list
	public String traverse() {
		String strnode = "";
		Node<T> currantLinked = head;
		
		while (currantLinked != null) {
			strnode  = strnode + currantLinked;
			currantLinked = currantLinked.getNext();
		}
		return " -->"+strnode ;
	}
	
	//Add in linked list 
	public void insert(T data) {
		Node<T> currantLinked = new Node<>(data); 
		//in first
		if (head == null) 
			head = currantLinked;
		else {
			//in sechand
			Node<T> prev = null, curr = head;
			for (; curr != null && curr.getData().compareTo(data) > 0; // to insert in median
					prev = curr, curr = curr.getNext())
				;

			if (prev == null)
				head = currantLinked;
			else
				prev.setNext(currantLinked);

			currantLinked.setNext(curr); // shift
		}
	}

  // calculate the size for the list
	public int size() {	
		Node<T> currantLinked = head;
		int sizelinked = 0; // set size equal zero
		// while  urent not equal 
		while (currantLinked != null) {
			sizelinked++;
			currantLinked = currantLinked.getNext();
		}
		return sizelinked;
	}
	
	//Search for Data
		public boolean find(T data) {
			try {
			Node<T> target = new Node<>(data);
			Node<T> curr = head;
			boolean exist = false;
			//The process of comparing higher values
			//find in yares
			for (; curr != null; curr = curr.getNext()) {
				if (((Baby_frequencies)target.getData()).getYear()==((Baby_frequencies)curr.getData()).getYear()) {
					exist = true;
					break;//Stop 
				}
			}
			if (exist)
				return true;
			}catch (Exception e) {
				System.out.println("Error");
				// TODO: handle exception
			}
			return false;
		}
		//print in All classes
	@Override
	public String toString() {
		return "" + head ;
	}
	
	
}
