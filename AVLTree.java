import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {
	static int min =0;
	static TNode<TRecord> mi =null;
	/**object From TNode class*/
	private TNode<T> root;
	
	/**Return roott*/
	public TNode<T> getRoot() {
		return root;
	}
	/**set roott */
	public void setRoot(TNode<T> root) {
		this.root = root;
	}
	/** Default constructor ** parameterized constructor*/
	public AVLTree(){
		/** Default constructor ** parameterized constructor*/
	}
	/***
	 * All left in time complexity in constant
	 */
	public TNode<T> rightRotate(TNode<T> Nodenew) {
		TNode<T> cRight = Nodenew.getLeft();//def nodeavl
		Nodenew.setLeft(cRight.getRight());//nodeavl in the leftt
		cRight.setRight(Nodenew);//node in the Rightt
		return cRight;//print nodeavl
	}

	/***
	 * All Right in time complexity in constant
	 */
	public TNode<T> leftRotate(TNode<T> Nodenew) {
		TNode<T> CLift = Nodenew.getRight();//def nodeavl
		Nodenew.setRight(CLift.getLeft());//nodeavl in the leftt
		CLift.setLeft(Nodenew);//node in the Rightt
		return CLift;//print nodeavl
	}

	/*
	 * Rotations in double right and left (rightt to leftt) and the time complexity in
	 * constantt
	 */
	private TNode<T> RightLift(TNode<T> Nodenew) {
		TNode<T> CRightLift = Nodenew.getRight();//def nodeavl and nodeavl in the Rightt
		Nodenew.setRight(rightRotate(CRightLift));////node in the leftt
		return leftRotate(Nodenew);//print nodeavl

	}

	/*
	 * Rotations in double left and right (leftt to rightt) and the time complexity in
	 * constant
	 */
	private TNode<T> LiftRight(TNode<T> Nodenew) {
		TNode<T> CLiftRight = Nodenew.getLeft();//def nodeavl and nodeavl in the leftt
		Nodenew.setLeft(leftRotate(CLiftRight));////node in the rightt
		return rightRotate(Nodenew);//print nodeavl

	}

	/**
	 * Update height of this ancestor node
	 * 
	 */
	private int getHeightDifference(TNode<T> Nodenew) {
		int leftch = height(Nodenew.getLeft());//dif node on leftt 
		int Rightch = height(Nodenew.getRight());//dif node on Rightt
		// return leftch - Rightch;
		 //if lef - righ = 2 3 4...... print -1
//		if (leftch - Rightch >= 2)
//			return -1;//(Balance)
//		// if lef - righ = -2-3-4...... print 1
//		else if (leftch - Rightch <= -2)
//			return 1;//(Balance)
//		return 0;
		return leftch-Rightch;

	}
	/**This is placed Method so that we can place the danta evenly(Balance)
	 * And so it is the time complexity in(log(n))
	 * */
	TNode<T> rebalance(TNode<T> nodeN) {
		/**
		 *The left subtree of N’s left child (case 1: right rotation)
 		 The right subtree of N’s left child (case 4: left-right rotation)
 		 The left subtree of N’s right child (case 3: right-left rotation)
         The right subtree of N’s right child (case 2: left rotation) **/
		int diff = getHeightDifference(nodeN);
		/**so it is not Balance */
		//A rotation about node N’s grandchild G (its child’s child)
		//A rotation about node N’s new child
		if (diff > 1) { // addition was in node's left subtree
			if (getHeightDifference(nodeN.getLeft()) > 0)
				nodeN = rightRotate(nodeN);
			else
				nodeN = LiftRight(nodeN);
			//A rotation about node N’s grandchild G (its child’s child)
			//A rotation about node N’s new child
		} else if (diff < -1) { // addition was in node's right subtree
			if (getHeightDifference(nodeN.getRight()) < 0)
				nodeN = leftRotate(nodeN);
			else
				nodeN = RightLift(nodeN);
		}
		return nodeN;//print node_avl_treey
	}

	private boolean isEmpty() {
		//root.avlTreey equal null
		return (root == null);
	}

	// insert
	public void insert(T DataAVLTree, Baby_frequencies freq) {
		/**isEmpty ==(root==null)*/
		if (isEmpty()) { // insert in root and with linkedlist
			/**so it is root equal null new node in avlTree and Babyfreq(freq,year)*/
			root = new TNode<>(DataAVLTree);
			root.getList().insert(freq);
		} else {
			/**so it is root not equal null 
			 * Calculation process if the tree is equal(Balance) or not
			 * we do work call function find to node if node it exist 
			 * if not exist -->> new node in tree
			 * and if it exist -->>new linked list from node Which is similar with it
			 * */
			TNode<T> rootnodeAvlTree = root;
			if (find(DataAVLTree) == null) {
				addEntry(DataAVLTree, rootnodeAvlTree, freq);
				root = rebalance(rootnodeAvlTree);
			} else {
				TNode<T> rootnodeAvlTree2 = find(DataAVLTree);
				rootnodeAvlTree2.getList().insert(freq);
				rootnodeAvlTree = rebalance(rootnodeAvlTree2);
			}
		}
	}
	
	
	public void insert2(T DataAVLTree, Baby_frequencies freq) {
		/**isEmpty ==(root==null)*/
		if (isEmpty()) { // insert in root and with linkedlist
			/**so it is root equal null new node in avlTree and Babyfreq(freq,year)*/
			root = new TNode<>(DataAVLTree);
			root.getList();//.insert(freq);
		} else {
			/**so it is root not equal null 
			 * Calculation process if the tree is equal(Balance) or not
			 * we do work call function find to node if node it exist 
			 * if not exist -->> new node in tree
			 * and if it exist -->>new linked list from node Which is similar with it
			 * */
			TNode<T> rootnodeAvlTree = root;
			if (find(DataAVLTree) == null) {
				addEntry(DataAVLTree, rootnodeAvlTree, freq);
				root = rebalance(rootnodeAvlTree);
			} else {
				TNode<T> rootnodeAvlTree2 = find(DataAVLTree);
				rootnodeAvlTree2.getList();//.insert(freq);
				rootnodeAvlTree = rebalance(rootnodeAvlTree2);
			}
		}
	}
	
	

	public int height() {
		//tack in the noderoot avlTree.y
		return height(root);
	}

	private int height(TNode<T> node) {
		/*
		 * Perform the normal BST rotation Update height of this ancestor node Get the
		 * balance factor of this ancestor node to check whether this node became
		 * unbalance
		 */
		if (node == null)
			return 0;
		if (node.isLeaf())
			return 1;
		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());
		if (node.hasRight())
			right = height(node.getRight());
		// Update heights
		// Get Balance factor of node
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	public void addEntry(T data_n_g, TNode<T> root_node_avltree, Baby_frequencies freq) {
		assert root_node_avltree != null;
		/**
		 * (a) The AVL tree after additions that maintain its balance;
		   (b) after an addition that destroys the balance;
           (c) after a left rotation;
           (d) after a right rotatio*/
		if (data_n_g.compareTo((T) root_node_avltree.getData()) < 0) { // right into left subtree
			if (root_node_avltree.hasLeft()) {
				TNode<T> leftChild_avltree = root_node_avltree.getLeft();
				addEntry(data_n_g, leftChild_avltree, freq);
				root_node_avltree.setLeft(rebalance(leftChild_avltree));

			} else {
				TNode<T> nodeavltree = new TNode<>(data_n_g);
				root_node_avltree.setLeft(nodeavltree);
				nodeavltree.getList().insert(freq);
			}

		} else if (data_n_g.compareTo((T) root_node_avltree.getData()) > 0) { // right into right subtree
			if (root_node_avltree.hasRight()) {
				TNode<T> rightChild_avltree = root_node_avltree.getRight();
				addEntry(data_n_g, rightChild_avltree, freq);
				root_node_avltree.setRight(rebalance(rightChild_avltree));
			} else {
				TNode<T> nodeavltree = new TNode<>(data_n_g);
				root_node_avltree.setRight(nodeavltree);
				nodeavltree.getList().insert(freq);
			}
		} else if (data_n_g.compareTo((T) root_node_avltree.getData()) == 0) {
			root_node_avltree.getList().insert(freq);
		}
		
	}
	
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode<T> node) {
		String stravll="";
		if (node != null) {
			if (node.getLeft() != null)
				traverseInOrder(node.getLeft());
			//stravll=stravll+node;
			//System.out.print(node + "\n\n");
			if (node.getRight() != null)
				traverseInOrder(node.getRight());
		}
		//return stravll;
	}

	public TNode<T> find(T data) {
		return findinnode(data, root);
	}

	public TNode<T> findinnode(T datanode, TNode<T> rot2) {
		if (rot2 != null) {
			int i = rot2.getData().compareTo(datanode);
			if (i == 0)
				return rot2;
			else if (i > 0 && rot2.hasLeft())
				return findinnode(datanode, rot2.getLeft());
			else if (i < 0 && rot2.hasRight())
				return findinnode(datanode, rot2.getRight());
		}
		return null;
	}

	public String file() {
		try {
			return file((TNode<TRecord>) root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String file(TNode<TRecord> re) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue=re.level;
		if(queue!=null) {
			FileWriter file=new FileWriter("out.txt");
			Node<String> curr=(Node<String>) queue;
			while(curr!=null){
				file.write(curr.getData());
				curr=curr.getNext();
			}
			file.close();
			return ""+1;
		}
		return""+0;
	}
	public void inq(T data) {
		AVLTree<TRecord> o = null;

		// TNode<TRecord> curr = o.root1;
		if (isEmpty())
			root = new TNode<>(data);
		else {

			TNode<TRecord> rootNode = o.root;
			addEntry(data, (TNode<T>) rootNode, null);
			root = rebalance((TNode<T>) rootNode);
			if (((TRecord) rootNode.getData()).getName() != ((TRecord) root.getData()).getName())
				;
			// queue.enqueue(data);
		}
	}

//	public Node find(T data) {
//	return find(data, root);
//}

	public TNode<T> findd(T data, TNode<T> root2) {
		if (root2 != null) {
			int comp = root2.getData().compareTo(data);
			if (comp == 0)
				return root2;
			else if (comp > 0 && root2.hasLeft())
				return findinnode(data, root2.getLeft());
			else if (comp < 0 && root2.hasRight())
				return findinnode(data, root2.getRight());
		}
		return null;
	}

	private boolean find1(T x, TNode t) {
		while (t != null)
			if (x.compareTo((T) ((TRecord)t.getData()).getName()) < 0 && x.compareTo((T) ((TRecord)t.getData()).getGender()) < 0)
				t = t.getLeft();
			else if (x.compareTo((T) ((TRecord)t.getData()).getName()) > 0 && x.compareTo((T) ((TRecord)t.getData()).getGender()) > 0)
				t = t.getRight();
			else
				return true; // Match

		return false; // No match
	}

	public boolean find1(T data) {
		return find1(data, root);
	}
	public  TNode<TRecord> maxNode() {
		return maxNode((TNode<TRecord>) root);
	}
	/***
	 * 	Create a new node.
		It first checks, whether the head is equal to null which means the list is empty.
		If the list is empty, both head and tail will point to a newly added node.
		If the list is not empty, the new node will be added to end of the list such
 		that tail's next will point to a newly added node. This new node will
  		become the new tail of the list
  		*/
	public  TNode<TRecord> maxNode(TNode<TRecord> local) { 
		int max=0;
		int sum_freq=0;
	//	int min= local.getData().getFreq();
	//	Node mi= local.getList().getHead();
		String name="";
        	if(local != null) {
        		//Initializing min with head node data  
        		Node<Baby_frequencies> Currant = local.getList().getHead();
        		
        		//If current node's data is smaller than max  
                //Then, replace value of max with current node's data  
        		while(Currant != null) {
        			//min.getData().getFreq()
        			sum_freq +=Currant.getData().getFreq();
        			Currant=Currant.getNext();
                    }if(min<sum_freq) { 
        				
        				min=sum_freq;
        				mi=local;
        			
        		}
        			//sum=sum+Currant.getData().getFreq();
        		maxNode(local.getLeft());
        		maxNode(local.getRight());
        	}
        return mi;
	}
	
	
	public void total (TNode<T> local,int y,Linkedlist< Integer> info) {
		int sum=0;
		if(local!=null) {
			
		Node<Baby_frequencies> Currant = local.getList().getHead();
		for(;Currant != null;) {
		if(Currant.getData().getYear()==y) {
			info.insert(Currant.getData().getFreq());
			break;
		}
			Currant=Currant.getNext();
		}
		total(local.getLeft(), y,info);
		total(local.getRight(), y,info);
		}
		
	}
	
	public String LevelNode_root(){
		/*
			 level by level and write the information to an output
		*/
			QueueLinkedList<T> Queue=new QueueLinkedList<>();//obj from QueueLinkedList
			Queue.enqueue(rootavltre9);//Add in Data from root
			//root not equal null
			/**› N(0) = 1, N(1) = 2
			Induction
			N(h) = N(h-1) + N(h-2) + 1
			Solution (recall Fibonacci analysis)
			 */
			String content="";
			while (!Queue.isEmpty()) {
				sNode<T> currinnode = (sNode<T>) Queue.dequeue();
				content=String.valueOf(currinnode+"\n");
				System.out.println(currinnode);
				try {
					
					FileWriter fileName = new FileWriter("output1.txt",true);
					fileName.write(content);
					fileName.close();
					//Files.writeString(fileName,content);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("Error");
					e1.printStackTrace();
				}
				//dif noderoot
				sNode<T> childrenleftnode = currinnode.getLeft();
				sNode<T> childreRightnode = currinnode.getRight();
				//left =null
				if (childrenleftnode != null) {
					//add root
					Queue.enqueue( childrenleftnode);
				}//rigt =null
				if (childreRightnode != null) {
					//add root
					Queue.enqueue(childreRightnode);
				}
//				else
//					System.out.println("null");
			}
//			try {
//			
//				FileWriter fileName = new FileWriter("output1.txt",true);
//				fileName.write(content);
//				fileName.close();
//				//Files.writeString(fileName,content);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				System.out.println("Error");
//				e1.printStackTrace();
//			}
			return " ";
			
		}
	

	sNode<T> rootavltre9;

	

	public T Maximum() {
		sNode<T> local = rootavltre9;
		if (local == null)
			return null;
		while (local.getRight() != null)
			local = local.getRight();
		return local.getData();
	}

	public T Minimum() {
		sNode<T> local = rootavltre9;
		if (local == null)
			return null;
		while (local.getLeft() != null) {
			local = local.getLeft();
		}
		return local.getData();
	}

	private int depth(sNode<T> sNode) {
		if (sNode == null)
			return 0;
		return sNode.getDepth();
		// 1 + Math.max(depth(sNode.getLeft()), depth(sNode.getRight()));
	}

	public sNode<T> inser(T data,int f) {
		rootavltre9 = inser(rootavltre9, data,f);
		switch (balanceNumber(rootavltre9)) {
		case 1:
			rootavltre9 = rotateLeft(rootavltre9);
			break;
		case -1:
			rootavltre9 = rotateRight(rootavltre9);
			break;
		default:
			break;
		}
		return rootavltre9;
	}

	public sNode<T> inser(sNode<T> sNode, T data,int f) {
		if (sNode == null)
			return new sNode<T>(data,f);
		if (sNode.getData().compareTo(data) > 0) {
			sNode = new sNode<T>(sNode.getData(), f, inser(sNode.getLeft(), data,f),
					sNode.getRight());
			// sNode.setLeft(inser(sNode.getLeft(), data));
		} else if (sNode.getData().compareTo(data) < 0) {
			// sNode.setRight(inser(sNode.getRight(), data));
			sNode = new sNode<T>(sNode.getData(), f, sNode.getLeft(), inser(
					sNode.getRight(), data,f));
		}
		// After inser the new sNode, check and rebalance the current sNode if
		// necessary.
		switch (balanceNumber(sNode)) {
		case 1:
			sNode = rotateLeft(sNode);
			break;
		case -1:
			sNode = rotateRight(sNode);
			break;
		default:
			return sNode;
		}
		return sNode;
	}

	private int balanceNumber(sNode<T> sNode) {
		int L = depth(sNode.getLeft());
		int R = depth(sNode.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private sNode<T> rotateLeft(sNode<T> sNode) {
		sNode<T> q = sNode;
		sNode<T> p = q.getRight();
		sNode<T> c = q.getLeft();
		sNode<T> a = p.getLeft();
		sNode<T> b = p.getRight();
		q = new sNode<T>(q.getData(), q.f, c, a);
		p = new sNode<T>(p.getData(), q.f, q, b);
		return p;
	}

	private sNode<T> rotateRight(sNode<T> sNode) {
		sNode<T> q = sNode;
		sNode<T> p = q.getLeft();
		sNode<T> c = q.getRight();
		sNode<T> a = p.getLeft();
		sNode<T> b = p.getRight();
		q = new sNode<T>(q.getData(), q.f, b, c);
		p = new sNode<T>(p.getData(), q.f, a, q);
		return p;
	}

	

	public String toString() {
		return rootavltre9.toString();
	}

	public void PrintTree() {
		rootavltre9.level = 0;
		Queue<sNode<T>> queue = new LinkedList<sNode<T>>();
		queue.add(rootavltre9);
		while (!queue.isEmpty()) {
			sNode<T> sNode = queue.poll();
			System.out.println(sNode);
			int level = sNode.level;
			sNode<T> left = sNode.getLeft();
			sNode<T> right = sNode.getRight();
			if (left != null) {
				left.level = level + 1;
				queue.add(left);
			}
			if (right != null) {
				right.level = level + 1;
				queue.add(right);
			}
		}
	}

	
	
}