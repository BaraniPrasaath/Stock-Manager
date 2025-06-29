import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class svs_home implements ActionListener
{

JLabel la1, la2, la3, la4, ila1, ila2, ila3, ila4;
JButton b1, b2, b3, b4;

Color c1 = new Color(64,115,155);
JFrame frame = new JFrame("Shri Vasupradha Silks");

ImageIcon purchace = new ImageIcon("bill_purchase.jpg");
ImageIcon sales = new ImageIcon("sales_bill.jpg");
ImageIcon profile = new ImageIcon("user_profile.jpg");
ImageIcon stock = new ImageIcon("stock_details.jpg");

svs_login obj;

svs_home(svs_login obj1)
{
obj = obj1;

frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

purchace = resize(purchace);
sales = resize(sales);
profile = resize(profile);
stock = resize(stock);

la1 = new JLabel("Purchase Entry");
la2 = new JLabel("Sales Entry");
la3 = new JLabel("Stock Check");
la4 = new JLabel("Profile");

ila1 = new JLabel(purchace);
ila2 = new JLabel(sales);
ila3 = new JLabel(stock);
ila4 = new JLabel(profile);

b1 = new JButton("Add");
b2 = new JButton("Add");
b3 = new JButton("View");
b4 = new JButton("View");

la1.setForeground(Color.WHITE);
la2.setForeground(Color.WHITE);
la3.setForeground(Color.WHITE);
la4.setForeground(Color.WHITE);

ila1.setBounds(125,130,120,120);
ila2.setBounds(275,130,120,120);
ila3.setBounds(425,130,120,120);
ila4.setBounds(575,130,120,120);

la1.setBounds(125,250,100,30);
la2.setBounds(275,250,100,30);
la3.setBounds(425,250,100,30);
la4.setBounds(575,250,100,30);

b1.setBounds(125,280,100,30);
b2.setBounds(275,280,100,30);
b3.setBounds(425,280,100,30);
b4.setBounds(575,280,100,30);


frame.add(la1);
frame.add(la2);
frame.add(la3);
frame.add(la4);

frame.add(ila1);
frame.add(ila2);
frame.add(ila3);
frame.add(ila4);

frame.add(b1);
frame.add(b2);
frame.add(b3);
frame.add(b4);

frame.getContentPane().setBackground(c1);
frame.setVisible(true);
frame.setSize(850,600);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

}


public static ImageIcon resize(ImageIcon originalicon)
{

	Image image = originalicon.getImage();
	Image scaled = image.getScaledInstance(120,120,Image.SCALE_SMOOTH);
	ImageIcon scaledicon = new ImageIcon(scaled);
	return scaledicon;
}


public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
		new svs_purchase(this);
	if(ae.getSource()==b2)
		new svs_sales(this);
	if(ae.getSource()==b3)
		new svs_stockChoice();
	if(ae.getSource()==b4)
		new svs_userProfile(obj);
}



/*
public static void main(String[] ags)
{
new svs_home();
}*/
}