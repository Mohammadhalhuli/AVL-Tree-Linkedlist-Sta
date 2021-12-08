

public class sNode<T extends Comparable<T>> implements Comparable<sNode<T>> {

	private T data;
	private sNode<T> left;
	private sNode<T> right;
	public int level;
	public int f;
	private int depth;

	public sNode(T data,int f) {
		this(data,f, null, null);
	}

	public sNode(T data,int f, sNode<T> left, sNode<T> right) {
		super();
		this.data = data;
		this.f=f;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public sNode<T> getLeft() {
		return left;
	}

	public void setLeft(sNode<T> left) {
		this.left = left;
	}

	public sNode<T> getRight() {
		return right;
	}

	public void setRight(sNode<T> right) {
		this.right = right;
	}

	public int getDepth() {
		return depth;
	}
	
	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public int compareTo(sNode<T> o) {
		return this.data.compareTo(o.data);
	}

	@Override
	public String toString() {
		return  ""+data+f;
	}

	

}