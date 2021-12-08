import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class fxproject {
	static String[] values;
	static String data;
	static String Name;
	static String gender;
	static int year;
	static AVLTree<TRecord> tr = new AVLTree<>();
	static AVLTree<TRecord> tr2 = new AVLTree<>();
	static Linkedlist<Integer> myListo = new Linkedlist<Integer>();
	static File file;
	private static Desktop desktop = Desktop.getDesktop();
	static  File selfold;
	static String f;
	public static void display1(String title, String message) {
		Stage windos = new Stage();
		Stage windos1 =new Stage();
		  windos1.setTitle("JavaFX App");
		 
	        DirectoryChooser c = new DirectoryChooser();
	        c.setInitialDirectory(new File("src"));
	         
	        Button buttonc = new Button("Select in folder");
	        TextField link=new TextField();
	        
	        link.setTranslateX(120);
	        buttonc.setOnAction(e -> {
	        	selfold = c.showDialog(windos1);

	            System.out.println(selfold.getAbsolutePath());
	            link.setText(selfold.getAbsolutePath());
	            
	            //f=selectedDirectory.getAbsolutePath();
	        });
	        Button log=new Button("Log in the Method");
	        log.setOnAction(e -> {
	        	
	        windos.show();
	        String outlink=(link.getText());
	        try {
				readfile(outlink);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        });

	       log.setTranslateY(30);
		
		
		//The look you want looks like the next table you want to open in the next table ...
		TableView objta = new TableView();
		// table represent the columns we will be adding in the TableColumn object Here we have created three objects
		TableColumn objcolumn = new TableColumn("in");
		// table Here we have placed the three columns in the object
		objta.getColumns().add(objcolumn);
		// table in the data object Here we have inserted the data of the object
		objta.setId(" java in Data");
		// has been added to the "Product" table in each object name. The objcolumn values will be displayed. Here we said that the column
		objcolumn.setCellValueFactory( (Callback) new TRecord(tr.LevelNode_root()));
		// in the table window, here we have specified the object size
		objta.setPrefSize(300, 300);
		// in the Root Node window, because we intend to pane it, here we have created an object from the class
		Pane root5 = new Pane();
		//in the stage
		
		// Set the title of the Stage
		windos.setTitle(title);
		// Create the Scene
		Scene scene = new Scene(root5,300,400,Color.RED);
		// Add the scene to the Stage
		windos.setScene(scene);
		// Display the Stage
		windos.show();
	}
	
	public static void display2(String title, String message) throws Exception{
		Stage windos =new Stage();
		Stage windos1 =new Stage();
		  windos1.setTitle("JavaFX App");
		 
	        DirectoryChooser c = new DirectoryChooser();
	        c.setInitialDirectory(new File("src"));
	         
	        Button buttonc = new Button("Select in folder");
	        TextField link=new TextField();
	        
	        link.setTranslateX(120);
	        buttonc.setOnAction(e -> {
	        	try {
	        	selfold = c.showDialog(windos1);

	            System.out.println(selfold.getAbsolutePath());
	            link.setText(selfold.getAbsolutePath());
	            
	            //f=selectedDirectory.getAbsolutePath();
	        	}catch (Exception e5) {
					// TODO: handle exception
				}
	        });
	        Button log=new Button("Log in the Method");
	        log.setOnAction(e -> {
	        	
	        windos.show();
	        String outlink=(link.getText());
	        try {
				readfile(outlink);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        });

	       log.setTranslateY(30);

	        
	////////////////////////////////	
	    
	
		
		
		
		
		
		// Create the Labels and TextField
        Label Name_T = new Label("Name :");
        TextField tfnamecompany =new TextField();
        Label gender_T = new Label("Gender:");
        TextField tfgenderOfShares =new TextField();
        Button linked =new Button("Show Avl and Linked list");
        Button find_Name_Avl=new Button("Find Name");
        Stage stage=new Stage();
        TextArea n=new TextArea();
        Button ok =new Button("ok");
        ok.setTranslateX(260);
        ok.setTranslateY(260);
        Group gr=new Group();
        ok.setOnAction(e->stage.close());
        gr.getChildren().addAll(n,ok);
        Scene s=new Scene(gr, 300, 300);
        stage.setScene(s);
        find_Name_Avl.setOnAction(e->{
        	try {
        	String name=(tfnamecompany.getText());
        	String ge=(tfgenderOfShares.getText());
        	
        	String find=String.valueOf(findName(tr, name, ge));
        	System.out.println(find);
        	n.setText(find);
        	stage.show();
        	}catch (Exception e55) {
				// TODO: handle exception
			}
        });
        Button AverageFrequenciesofaName =new Button("FAverage feaq");
        AverageFrequenciesofaName.setOnAction(e ->{
        	try {
        	String name=(tfnamecompany.getText());
        	String ge=(tfgenderOfShares.getText());
        	String avg=Average(tr, name, ge);
        	System.out.println(avg);
        	n.setText(avg);
        	stage.show();
        	}catch (Exception e5) {
				// TODO: handle exception
			}
        });
        Button Namewithmaxfrequency=new Button("Max freq");
        Namewithmaxfrequency.setOnAction(e -> {
        	try {
        		String x="";
				x=String.valueOf(tr.maxNode());
				n.setText(x);
	        	stage.show();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        });
        Button Totalnumberofbabiesin_a_selectedyear=new Button("Total Number");
        TextField m=new TextField();
        Totalnumberofbabiesin_a_selectedyear.setOnAction(e -> {
        	try {
        		String x="";
        		String sss="";
        		sss=m.getText();
				
				tr.total(tr.getRoot(), Integer.parseInt(sss), myListo);
				Node<Integer> current = myListo.getHead();
				int sum=0;
				while(current != null) {
					
					sum = sum +current.getData();
					current=current.getNext();
				}
				System.out.println(sum);
				n.setText(String.valueOf(sum));
	        	stage.show();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        });
        Button ExporttheAVLtreedatato_a_file =new Button("Level");
        ExporttheAVLtreedatato_a_file.setOnAction(e -> {
        	try {
        	String sss="";
        	sss= tr.LevelNode_root();
        	n.setText(sss);
        	tr.file();
        	stage.show();
        	
        	} catch (Exception e25) {
			// TODO: handle exception
		}
        });
		GridPane root5 = new GridPane();
		 // Set the horizontal spacing to 30px
        root5.setHgap(30);
        // Set the vertical spacing to 15px
        root5.setVgap(15);

        root5.add(Name_T,1,3);
        root5.add(tfnamecompany,2,3);
        root5.add(gender_T,1,4);
        root5.add(tfgenderOfShares,2,4);
        root5.add(find_Name_Avl, 1, 7);
        root5.add(AverageFrequenciesofaName, 1, 9);
        root5.add(Namewithmaxfrequency, 1, 11);
        root5.add(Totalnumberofbabiesin_a_selectedyear, 1, 13);
        root5.add(ExporttheAVLtreedatato_a_file, 1, 15);
        root5.add(m,4,13);
        //root5.add(button, 0, 0);
		// Set the title of the Stage
		windos.setTitle(title);
	
		Scene scene = new Scene(root5,960, 600,Color.RED);
		// Add the scene to the Stage
		windos.setScene(scene);
//		// Display the Stage
		Pane pane=new Pane();
		pane.getChildren().addAll(buttonc,link,log);
		Scene scene1 = new Scene(pane,300,300,Color.RED);
		windos1.setScene(scene1);
		windos1.show();
}
	
	public static void readfile(String namefile) throws IOException {
		//ًRead in folder 
		//Creating a File object for directory
//	      File directoryPath = new File(namefile);
//	      //List of all files and directories
//	      File filesList[] = directoryPath.listFiles();
//		
		
		File infiledata = new File(namefile);//dif file --> FOLDER 
		File[] fodata = infiledata.listFiles();//All File in folde
		// Fetching all the files
		for (File filedata : fodata) {
			if (filedata.isFile()) {

				///////
//				List<String> results = new ArrayList<String>();
//				results.add(file.getName());
//				String y ;//.substring(7, 10);
//				results=JSON.stringify(y);
//				year= Integer.parseInt(y);
//				System.out.println(y);
//				System.out.println(results);
				////
				BufferedReader indatafile = null;
				String Data = "";
				try {
					indatafile = new BufferedReader(new FileReader(filedata));

					while ((Data = indatafile.readLine()) != null) {
						// System.out.println(Data);
						// data=in.next();
						//split in Array
						values = Data.split(",");
						Name = values[0];
						gender = (values[1]);
						year = Integer.parseInt(values[2]);
						String stry = Name + "," + gender + "," + year;//string in trecord
//						String y = Data.substring(7, 10).trim();
//						year= Integer.parseInt(y);
//						System.out.println(y);
						TRecord n = new TRecord(Data);
						String years;//dif string
						String x = filedata.getName();//name file exist in folder 
						years = x.substring(7, 11);//remove chrachter in name file on 7 at 11
				        //casteng year
				        int yearinfile=Integer.parseInt(years);
						Baby_frequencies m = new Baby_frequencies(n.getFreq(), yearinfile);//object baby(freq,year)
						tr.insert(n, m);//tr in object avlTree 
						//tr.insert2(n, m);
						tr.inser(n,n.getFreq());
					}
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					if (indatafile != null) {
						indatafile.close();
					}
				}
			}
		}
	}
	
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
			else if (rec.compareTo(((TRecord) local.getData())) > 0)//child Right
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
	
}

