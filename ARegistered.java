import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ARegistered{
	int i=0;
	JFrame jf,jf1;
	JLabel l2,l3,t,f2;
	JButton b1,b2,b3,b5,b4,b6;
	JTextField f1;
	 Connection con;
	 PreparedStatement ps;
	 String q="";
	 String column[]={"ID","STUDENT NAME","FATHERS NAME","MOTHERS NAME","GENDER","DOB","MOBILE NO.","CLASS"}; 
     static JTable jt;
     JComboBox<String> cb;
  ARegistered(){
	 con=null;
	  try
	  {
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Ujjwal12");
	  // System.out.print("Working");
	  }
	  catch(Exception e)
	  {
	   System.out.println(e);
	  }
	
	jf=new JFrame("Student data ");
	 
	 l2=new JLabel("Enter ID");
	 l2.setBounds(80,70,200,30);
	 f1=new JTextField();
	 f1.setBounds(200,70,200,30);
	 b5=new JButton("OK");
	 b5.setBounds(600,20,70,30);
	 b5.setVisible(false);
	 t=new JLabel();
	 t.setBounds(400,75,200,20);
	 t.setForeground(Color.red);
	 t.setVisible(false);
	 f2=new JLabel();
	 f2.setBounds(150,220,490,30);
	 f2.setVisible(false);
	 
	 
	 l3=new JLabel("Select class");
		l3.setBounds(70,80,200,30);
		l3.setVisible(false);
		 String clss[]={"","1","2","3","4","5","6","7","8","9","10","11","12"};        
		    cb=new JComboBox<String>(clss); 
		    cb.setBounds(200, 85, 200, 30);	
		    cb.setVisible(false);
	 
	//SEARCH THAT ROW WHICH MATCHES THE ENTERED ROLL NUMBER
	 
	 b1=new JButton("SEARCH");
	 b1.setBounds(60, 330, 200, 30);
	 b1.setBackground(Color.gray);
	 b1.addActionListener(new ActionListener(){
		 
		 public void actionPerformed(ActionEvent e) {
			 if(f1.getText().length()==0)
			 {
				 t.setVisible(true);
				 f1.setVisible(true);
				 l2.setVisible(true);
				 t.setText("*Please enter ID of student*");
			 }else {
				 t.setVisible(false);
			 q="select * from STUDENT.School where ROLL_NUMBER = "+(Integer.parseInt(f1.getText()));
			 showTableData();
			 f1.setText("");
		 	}
		 }
		 
	 }
	 );
//SHOW DATA BASED ON SELECTED CLASS	 
					
	 b2=new JButton("Class Data");
	 b2.setBounds(150, 500, 200, 30);
	 b2.setBackground(Color.gray);
     b2.addActionListener(new ActionListener(){
		 
		 public void actionPerformed(ActionEvent e) {
			f1.setVisible(false);
			l2.setVisible(false);
			l3.setVisible(true);
			cb.setVisible(true);
			    b5.setVisible(true);
			    t.setVisible(false);

			
			 b5.addActionListener(new ActionListener(){
				 
				 public void actionPerformed(ActionEvent e) {
					 if(cb.getSelectedIndex()==0)
					 {
						 t.setVisible(true);
						 t.setBounds(400,80,200,20);
						 t.setText("*Please select class*");
						 t.setForeground(Color.red);
						
					 }else {
						 t.setVisible(false);
						 q="select * from STUDENT.School where class = "+ cb.getSelectedIndex();
					     showTableData();
					     l3.setVisible(false);
					     cb.setVisible(false);
					     b5.setVisible(false);
				 }
					 
				 }
			 });
		
		 }});	
			
     
  //DELETE THAT ROW WHICH MATCHES THE EMTERED ROLL NO.
     b3=new JButton("DELETE");
	 b3.setBounds(280, 330, 200, 30);
	 b3.setBackground(Color.gray);
	 b3.addActionListener(new ActionListener() {
		 
		 public void actionPerformed(ActionEvent e)
		 {
			 if(f1.getText().length()==0)
			 {
				 f1.setVisible(true);
				 l2.setVisible(true);
				 t.setVisible(true);
				 t.setText("*Please enter ID of student*");
			 }else {
				 
			t.setVisible(false);
			
			 int k=0;
			  try
			  {
			   ps=con.prepareStatement("delete from STUDENT.School where ROLL_NUMBER = ?");
			   ps.setInt(1,(Integer.parseInt(f1.getText())));
			   k=ps.executeUpdate();
			  
			  }
			  catch(SQLException e1)
			  {
			   e1.printStackTrace();
			 
			  }
			    t.setVisible(true);
			t.setText("Deleted");
			t.setBounds(400,80,200,20);
			t.setForeground(Color.green);
			f1.setText("");
		 
		 }
		 }
	 });
//	 
	 //DISPLAY ALL DATA OF SCHOOL WITH TOTAL NUMBER OF ROWS SOMEHOW
	 b4=new JButton("School Data");
	 b4.setBounds(150,550,200,30);
	 b4.setBackground(Color.gray);
	 b4.addActionListener(new ActionListener()
     {
	 
	 public void actionPerformed(ActionEvent e) {
		 f2.setVisible(false);
		 f1.setVisible(false);
		 l2.setVisible(false);
		 
		 
		 q="select * from STUDENT.School";
		 showTableData();
		 print(i);
		
			}
     }
     ); 
	 b6=new JButton("BACK");
	 b6.setBounds(20,630,80,20);
	 b6.setBackground(Color.red);
	 b6.addActionListener(new ActionListener()
			 {
		 public void actionPerformed(ActionEvent e)
		 {
			 new FirstPage();
		 }
			 });
    jf.add(f2);
	 jf.add(l2);
	 jf.add(f1);
	 jf.add(b6);
	 jf.add(b4);
	jf.add(cb);
	  jf.add(b5); 
	  jf.add(b1);
	  jf.add(b2);
	  jf.add(l3);
	  jf.add(b3);
	  jf.add(t);
	jf.getContentPane().setBackground(Color.cyan);
	jf.setLayout(null);
	jf.setVisible(true);
	jf.setSize(700,700);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void print(int i)
{
	f2.setVisible(true);
	f2.setText("At present you have "+i +" students.");
	f2.setFont(new Font("Arial", Font.PLAIN, 30));
	f2.setForeground(Color.gray);
		
	
}

   public void showTableData()
  {
	jf1=new JFrame("Result");
	jf1.setLayout(new BorderLayout());
	
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(column);
	
	jt= new JTable();
	jt.setModel(model); 
	
	jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	jt.setFillsViewportHeight(true);
	
	JScrollPane scroll = new JScrollPane(jt);
	int r;
	String sname="";
	String fname="";
	String mname="";
	String gen="";
	String dob="";
	String mob="";
	String cls="";
	 try
	  {
	   ps=con.prepareStatement(q);
	   ResultSet rs=ps.executeQuery();  
	   i=0;
	   while(rs.next()){  
	       sname=rs.getString(1);
	       fname=rs.getString(2);
	       mname=rs.getString(3);
	       gen=rs.getString(4);
	       dob=rs.getString(5);
	        r = rs.getInt(6);
			mob = rs.getString(7);
			cls=rs.getString(8);
			
			model.addRow(new Object[]{r, sname,fname,mname,gen,dob,mob,cls});
			i++;
			
		}
	   if(i<1)
		{
			JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
		
		}
		

	
}
catch (SQLException e) {
		e.printStackTrace();
	}
	 jf1.add(scroll);	
     jf1.setVisible(true);
      jf1.setSize(400,300);
      jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
