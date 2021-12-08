import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Test {
	static String[] values;
	static String data;
	static String Name;
	static String gender;
	static int year;
	static AVLTree<TRecord> tr = new AVLTree<>();
	static Linkedlist<Integer> myListo = new Linkedlist<Integer>();
	//static AVLTree<TRecord> tr2 = new AVLTree<>();
	static File file;
	public static void main(String[] a) throws IOException {
		
		File myfile = new File("C:\\Users\\Mohammad Abo khalid\\Downloads\\files");
		File[] files = myfile.listFiles();
		// Fetching all the files
		for (File file : files) {
			if (file.isFile()) {

				///////
//				List<String> results = new ArrayList<String>();
//				results.add(file.getName());
//				String y ;//.substring(7, 10);
//				results=JSON.stringify(y);
//				year= Integer.parseInt(y);
//				System.out.println(y);
//				System.out.println(results);
				////
				BufferedReader inputStream = null;
				String Data = "";
				try {
					inputStream = new BufferedReader(new FileReader(file));

					while ((Data = inputStream.readLine()) != null) {
						// System.out.println(Data);
						// data=in.next();
						values = Data.split(",");
						Name = values[0];
						gender = (values[1]);
						year = Integer.parseInt(values[2]);
						String str = Name + "," + gender + "," + year;
//						String y = Data.substring(7, 10).trim();
//						year= Integer.parseInt(y);
//						System.out.println(y);
						TRecord n = new TRecord(Data);
						String years;
						String x = file.getName();
						years = x.substring(7, 11);
				        int year = Integer.parseInt(years);
				        int yearinfile=Integer.parseInt(years);
						Baby_frequencies m = new Baby_frequencies(n.getFreq(), yearinfile);
						//tr.insert2(n, m);
						//tr.insert(n, m);
						//tr.inser(n,n.getFreq());
						//tr.insert(n);
						tr.insert2(n, m);
					}
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
				}
			}
		}

//				File [] arrfile=myfile.listFiles();
//				for (File f : arrfile) {
//					System.out.println(f);			
//				}
		// System.out.println(tr.find("Orion,M,676"));

		 //tr.PrintTree();

//		        tr.inser("moh");
//		        tr.inser("mo");
//		        tr.inser("m");
		// tr.inser(new TRecord("ayle,F,16"));
		 tr.traverseInOrder();
		//System.out.println(".++++." + findName(tr, "Jarin","F")+"\n\n");
		//System.out.println("................"+Average(tr, "Jarin", "F"));
		//System.out.println(total_freq(tr,2000));
		//System.out.println(".++++." + tr.find(new TRecord("Zakariyah,M", myfile)));
		// System.out.println(tr.find(null));
//		tr.maxNode();
//		Node<Integer> current1 =myListo.getHead();
//		int sum1=0;
//		while(current1 != null) {
//			
//			sum1 = sum1 +current1.getData();
//			current1=current1.getNext();
//		}
//		tr.total(tr.getRoot(), 2000, myListo);
//		Node<Integer> current = myListo.getHead();
//		int sum=0;
//		while(current != null) {
//			
//			sum = sum +current.getData();
//			current=current.getNext();
//		}
//		System.out.println(sum1);
		//System.out.println(tr.maxNode());
		//tr.traverseInOrder();
		//tr.traverseInOrder();
		//tr.LevelNode_root();
		//tr.toString();
		//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}

//	public static String finfName(String data+String) {
//		return findName(tr, data);
//	}

	/**
	 * statrt
	 * let name and gendr
	 * while secch in th node
	 * while tnode != null
	 * if serch in left if data >0
	 * else if serch in right  if data <0
	 * **/
	//Method Find Name 
	public static TNode findName(AVLTree<TRecord> t, String x,String g) {
		TNode<TRecord> local = t.getRoot();//dif object form Tnode and record
//		x=((TRecord)local.getData()).getName();//name TRecord
//		g=((TRecord)local.getData()).getGender();//gender TRecord 
		String line = x+","+g+","+0; //String argeomant in TRecord
		TRecord rec = new TRecord(line); //obj TRecord
		while (local != null) { 
			if (rec.compareTo(local.getData() )< 0)//child left
				local = local.getLeft();//serchroot left
			else if (rec.compareTo((local.getData())) > 0)//child Right
				local = local.getRight();//serchroot right
			else
				return local;//print node
		}
		return null;
	}
	
	/**
	 * babayb fr = new Baybyfrq();
	 * let name ,year 
	 * scane name ,year 
	 * find name srche
	 * linkedlist to year 
	 * Node curr = head.getfrist();
	 * while(curr != null)
	 * 
	 * Total += f.getfreq; count ++;
	 * 
	 * double avg = Total / count;
	 * 
	 */

	/*Let Name and gender 
	scanner name and gender 
	Tnode=root 
	while(Tnode != null){
		and find node (name,gread)
		if(find is true )
		node =head 
		leat sum ,coun,Avg
		while(node != null){
			sum equal sum plase data
			Counter_node ++
			avg equal sum div coun
		}
	}
		print sum 
		print avg 
	*/
public static String Average(AVLTree<TRecord> t, String x, String g) {
	/*
	the Method is calculeat 
	calculaet an Average 
	*/
		TNode<TRecord> local = t.getRoot();//node root
//		x=((TRecord)local.getData()).getName();//name TRecord
//		g=((TRecord)local.getData()).getGender();//gender TRecord
	//Let Varuble
		TNode findcurr=findName(t, x, g);
		int Counter_node = 0;
		double sum_freq = 0,
		avg_freq = 0;//
		//Spin on all Node
		if (local != null) {
		//Serch in name 
		if(findcurr != null) {
			//Log in to node and Baby_frequencies(Freq,year)
				Node<Baby_frequencies> Currant = findcurr.getList().getHead();
				//Spin on all Node
				while (Currant != null) {
					//calculaet
					sum_freq += Currant.getData().getFreq();
					Counter_node++;//Counter_node=Counter_node+1
					Currant = Currant.getNext();//next to node Head
					//calculaet
					avg_freq = sum_freq / Counter_node;
				}
				//print
				return " Average Freq is: " + avg_freq;
			}
		else
			return "Erorr";

		}
		//else 
		//print
		return " Error in the Name";
	}
//
//	// Method insert
//	public static <T> void inser2(AVLTree<TRecord> t, T data) {
//		TNode<TRecord> objnode = t.root1;
//		if (t.root1 == null)
//			t.root1 = new TNode<TRecord>((TRecord) data);
//		else {
//			TRecord record = null;
//			if (t.find1((TRecord) data)) {
//				if (finfName(tr, ((TRecord) data).getName()) != "yes") {
//					TNode<TRecord> rootNode = t.root1;
//					t.addEntry((TRecord) data, rootNode);
//					t.root1 = t.rebalance(rootNode);
//				}
//			}
//		}
//
//	}

	/**
	 * babayb fr = new Baybyfrq();
	 * let name ,year 
	 * scane name ,year 
	 * find name srche
	 * linkedlist to year 
	 * Node curr = head.getfrist();
	 * while(curr != null)
	 * 
	 * Total += f.getfreq; count ++;
	 * 
	 * double avg = Total / count;
	 * @param <T>
	 * 
	 **/

	
	
//	
//	public static String Average(AVLTree<TRecord> avltree, 
//			String name, String gen) {
//		TNode<TRecord> record=avltree.getRoot();
//		String find=findName(avltree, name, gen);
//		double Avg = 0;
//		int count = 0, sum = 0;
//		int num=0;
//		if(find != "no") {
//			
//		
//		return "++";
//		
//	}

//		
//		TNode<TRecord> rootavl = avltree.getRoot();
//		Baby_frequencies baby = new Baby_frequencies(((TRecord) rootavl.getData()).getFreq(), year);
//		double Avg = 0;
//		int cout = 0, sum = 0;
//		// String v=findName(tr, name);
//		String line = name +","+ gen+","+0;
//		TRecord data = new TRecord(line);
//		//TNode TT = avltree.find(data);
//		String TT=findName(avltree, name, gen);
//		if (TT == null) {
//
//			return null;
//		} else {
//			
//			//find in first == true : done
//			//++
//			//in finaly false 
//			while(findName(avltree, name, gen)!="no") {
//				
//				sum += baby.getFreq();
//				cout++;
//			}
//			Avg = sum / cout*1.0;
//			
//			return ""+Avg;
//			
//
//		}
//	}
//	
	
	
	/*let sum =0
	 * set linkedlis list 
	 * node =head ;
	 * while (node != null)
	 * start loop
	 *    sum=sum+freq
	 *    if(sum> max){
	 *    set max =sum;
	 *    }
	 *    
	 * end loop
	 * Node  . ....  sum  of all value int first 
	 * set max =0 
	 * if(max > sum)
	 * max =sum 
	 */
	
	
//	public static <T> String maxNode(AVLTree<TRecord> avltree,Baby_frequencies local) {  
//		while(local != null) {
//			int sum=0;
//			TNode<TRecord>curr=local.getFreq();
//		}
		
		//        local=avltree.getRoot();
//        Node<Baby_frequencies> curr = local.getList().getHead();
//        int sum = 1;
//        String str=" ";
//        while(local != null ) {
//        	if (local.getLeft() != null)
//        		maxNode(avltree,local.getLeft());
//    				while (curr != null) {
//    						str=str+curr.getData();
//    						sum += local.getData().getFreq();
//    						curr = curr.getNext();
//    				}
//			if (local.getRight() != null)
//				maxNode(avltree,local.getRight());
//		}
//        	
        	
//		while (curr != null) {
//			str=str+curr.getData();
//			sum += local.getData().getFreq();
//			curr = curr.getNext();
//		}
//        
//		return " "+ sum;
//    }  
	
//	public static String  Max_freq(AVLTree<TRecord> avltree,Linkedlist list , TNode node) {
//		int sum=0;		
//		
//			 if (node!= null) {
//			 sum+= 
//			 if (comp == 0)
//			 return node;
//			 else if (comp > 0 && node.hasLeft()) return find(data, node.left);
//			 else if (comp < 0 && node.hasRight()) return find(data, node.right);
//			 }
//			 return null;
//		}
		
	/*
	 * start 
	 * leat year 
	 * tnode =root
	 * while(tnode != null){
	 * node <Baby_frequencies>
	 * while(not equal null)
	 * find year 
	 * 		sum=sum+freq
	 * }
	 * }
	 * print sum
	 */
//	public static String total_freq(AVLTree<TRecord> baby,int yere_total) {
//		TNode<TRecord> loc=baby.getRoot();
//		while(loc != null) {
//			Node<Baby_frequencies> loc_total = loc.getList().getHead();
//			Baby_frequencies rec=new Baby_frequencies(0, yere_total);
//			while (loc_total != null) {
//				loc.setList(f);
//		
//		
//		
//			}
//	}
//		return Name;
//}



}
	
