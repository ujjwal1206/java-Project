import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FirstPage {	
	JFrame f;
	JButton b1,b2;
	FirstPage()
	{
		f=new JFrame("School Mangement System");
		JLabel background;
		f.setBounds(300, 90, 1000, 650);
		f.setLayout(null);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		
		ImageIcon img=new ImageIcon("..\\Project Practice\\src\\School.jpg");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1000,650);
		f.add(background);
		b1=new JButton("Already Registered.Click Here!");
		b1.setFont(new Font("Bold", Font.PLAIN, 15)); 
		b1.setSize(300, 40); 
		b1.setLocation(350,110); 
		f.add(b1);
		background.add(b1);
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				new ARegistered();
			}
		});
		
		b2=new JButton("Not Registered.Click Here!");
		b2.setFont(new Font("Bold", Font.PLAIN, 15)); 
		b2.setSize(300, 40); 
		b2.setLocation(350,170); 
		f.add(b2);
		background.add(b2);
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				new MyFrame();
			}
		});
		f.setVisible(true);
		
	}	
	public static void main(String[] args) {
		new FirstPage();
	}

}
