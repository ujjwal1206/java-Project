import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.*;
class MyFrame implements ActionListener { 
	JFrame c=new JFrame();
	JLabel title,name,mno,gender,add,res,fn,dob,mn,class1; 
	JTextField tname,tmno,tadd,tfname,mname,cname;  
	JRadioButton male,female;  
	ButtonGroup gengp;  
	JComboBox date,month,year;  
	JCheckBox term; 
	JButton sub,reset,login; 
	JPasswordField p;
	Connection con;
	PreparedStatement ps;
	String dates[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }; 
	String months[] = { "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "Decemeber" }; 
	String years[] = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", }; 
	public MyFrame() 
	{ 
		
		con=null;
		try
		{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Ujjwal12");
		 //System.out.println("connection done");
		}
		catch(Exception e)
		{
		 System.out.println(e);
		}
		
		c.setTitle("School Management System"); 
		c.setBounds(300, 90, 1000, 650); 
		c.setDefaultCloseOperation(c.EXIT_ON_CLOSE); 
		c.setLayout(null); 
		c.getContentPane().setBackground(Color.CYAN);
		title = new JLabel("Registration Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		c.add(title); 

		name = new JLabel("Student Name"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(200, 20); 
		name.setLocation(100, 100); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(200, 20); 
		tname.setLocation(300, 100); 
		c.add(tname); 

		fn = new JLabel("Fathers Name"); 
		fn.setFont(new Font("Arial", Font.PLAIN, 20)); 
		fn.setSize(200, 20); 
		fn.setLocation(100, 150); 
		c.add(fn); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(200, 20); 
		tmno.setLocation(300, 150); 
		c.add(tmno); 
		
		mn = new JLabel("Mothers Name"); 
		mn.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mn.setSize(200, 20); 
		mn.setLocation(100, 200); 
		c.add(mn); 

		mname = new JTextField(); 
		mname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		mname.setSize(200, 20); 
		mname.setLocation(300, 200); 
		c.add(mname); 

		gender = new JLabel("Gender"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(200, 20); 
		gender.setLocation(100, 250); 
		c.add(gender); 

		male = new JRadioButton("Male"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(75, 20); 
		male.setLocation(300, 250); 
		c.add(male); 

		female = new JRadioButton("Female"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(80, 20); 
		female.setLocation(375, 250); 
		c.add(female); 

		gengp = new ButtonGroup(); 
		gengp.add(male); 
		gengp.add(female); 

		dob = new JLabel("Date of Birth"); 
		dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
		dob.setSize(200, 20); 
		dob.setLocation(100, 300); 
		c.add(dob); 

		date = new JComboBox(dates); 
		date.setFont(new Font("Arial", Font.PLAIN, 15)); 
		date.setSize(50, 20); 
		date.setLocation(300, 300); 
		c.add(date); 

		month = new JComboBox(months); 
		month.setFont(new Font("Arial", Font.PLAIN, 15)); 
		month.setSize(80, 20); 
		month.setLocation(350, 300); 
		c.add(month); 

		year = new JComboBox(years); 
		year.setFont(new Font("Arial", Font.PLAIN, 15)); 
		year.setSize(60, 20); 
		year.setLocation(430, 300); 
		c.add(year); 

		add = new JLabel("Roll Number"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(120, 20); 
		add.setLocation(100, 350); 
		c.add(add); 

		tadd = new JTextField(); 
		tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tadd.setSize(200, 20); 
		tadd.setLocation(300, 350); 
		c.add(tadd); 
		
		mno = new JLabel("Mobile Number");
		mno.setFont(new Font("Arial", Font.PLAIN, 20));
		mno.setSize(220,20);
		mno.setLocation(100,400);
		c.add(mno);
		
		tfname = new JTextField();
		tfname.setFont(new Font("Arial",Font.PLAIN,15));
		tfname.setSize(200,20);
		tfname.setLocation(300, 400);
		c.add(tfname);

		class1 = new JLabel("Class");
		class1.setFont(new Font("Arial", Font.PLAIN, 20)); 
		class1.setSize(220, 20); 
		class1.setLocation(100, 450); 
		c.add(class1); 
		
		cname=new JTextField();
		cname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		cname.setSize(200, 20); 
		cname.setLocation(300, 450); 
		c.add(cname);

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 500); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 500); 
		reset.addActionListener(this); 
		c.add(reset); 
		
		login = new JButton("Back");
		login.setFont(new Font("Arial", Font.PLAIN, 13));
		login.setSize(100, 20); 
		login.setLocation(390, 500);
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				new ARegistered();
			}
		});
		c.add(login);

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 540); 
		c.add(res); 

		c.setVisible(true); 
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) { 
				String name=tname.getText();
				String fname=tmno.getText();
				String mnam=mname.getText();
				String g="";
				if (male.isSelected()) 
                    g = "Male";
                else
                    g = "Female" ;
				String d=(String)date.getSelectedItem()  + "-" + (String)month.getSelectedItem() + "-" + (String)year.getSelectedItem();
				String rn=tadd.getText();
				String mn=tfname.getText();
				String clas=cname.getText();
				int t=0;
				try
				{
				 ps=con.prepareStatement("insert into STUDENT.School values(?,?,?,?,?,?,?,?)");
				 ps.setString(1,name);
				 ps.setString(2,fname);
				 ps.setString(3,mnam);
				 ps.setString(4,g);
				 ps.setString(5,d);
				 ps.setString(6,rn);
				 ps.setString(7,mn);
				 ps.setString(8, clas);
				 t=ps.executeUpdate();
				 //System.out.println("t is: "+t);
				 res.setText("Registration Successfully");
				 res.setForeground(Color.GREEN);
				 //result.setText("Successfully Added");
				}
				catch(SQLException b)
				{
				 //b.printStackTrace();
					if(rn.isEmpty())
					{
						res.setText("*Please Input some value*");
						res.setForeground(Color.RED);
					}
					else
					{
				 res.setText("**Already Registered Please Sign in");
				 res.setForeground(Color.RED);
				 //return "FAIL";
					}
				} 
			
		} 

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tadd.setText(def); 
			tmno.setText(def); 
			mname.setText(def);
			tfname.setText(def);
			res.setText(def);  
			tname.setText(def);
			//term.setSelected(false); 
			cname.setText(def);
			date.setSelectedIndex(0); 
			month.setSelectedIndex(0); 
			year.setSelectedIndex(0); 
		} 
	} 
} 
class Sign_up1 { 

	public static void main(String[] args) 
	{ 
		MyFrame f = new MyFrame(); 
	} 
} 
