import java.util.Queue;

//1191413-Mohammad hlhwly
public class TNode<T extends Comparable<T>> {
	//varuable Tnodenode
	private T data;
	//varuable nodeavl Treey
	private TNode <T> left;
	private TNode<T> right;
	//linked lest from baby
	private Linkedlist<Baby_frequencies> list = new Linkedlist<Baby_frequencies>();
	//method 5
	public Queue<Integer> level;
	/** Default constructor ** parameterized constructor*/
	public TNode(T data, Linkedlist<Baby_frequencies> list) {
		//super();
		this.data = data;
		this.list = list;
	}
	/** Return Linkedlist */
	public Linkedlist<Baby_frequencies> getList() {
		return list;
	}
	/** Set a new */
	public void setList(Linkedlist<Baby_frequencies> list) {
		this.list = list;
	}
	/** Return TNode */
	public TNode(T data) {
		this.data = data;
	}
	/** Set a new */
	public void setData(T data) {
		this.data = data;
	}
	/** Return Data */
	public T getData() {
		return data;
	}
	/** Set a new */
	public TNode<T> getLeft() {
		return left;
	}
	/** Return Left */
	public void setLeft(TNode<T> left) {
		this.left = left;
	}
	/** Set a new */
	public TNode<T> getRight() {
		return right;
	}
	/** Return right */
	public void setRight(TNode<T> right) {
		this.right = right;
	}
	/** Set a new */
	public boolean isLeaf() {
		/**
		 * method_left&right = nullroot 
		 * */
		return (left == null && right == null);
	}
	
	public boolean hasLeft() {
		/**
		 * method left = nullroot 
		 * */
		return left != null;
	}

	public boolean hasRight() {
		/**
		 * method_right = nullroot 
		 * */
		return right != null;
	}

	@Override
	public String toString() {
		////to String in SNode
		return ""+ data  + list.traverse() +"\n\n";
	}

	
}

