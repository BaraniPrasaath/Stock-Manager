
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class svs_newlogin extends Frame implements FocusListener, ActionListener
{

	svs_dataStore ojt = new svs_dataStore();

String nameFinal="pending",passwordFinal="pending",address="pending",gst="pending",pan="pending",email="pending",monum="pending";
int count=0;

JLabel la1,la2,la3,la4,la5;
JTextField tf1,tf2,tf3;
JButton b1,b2,b3,b4;
JPasswordField pf1;

Color c1 = new Color(119,75,0);

BorderLayout bl = new BorderLayout();
FlowLayout fl = new FlowLayout();
GridBagLayout gbl = new GridBagLayout();
GridBagConstraints gbc = new GridBagConstraints();

Panel p1 = new Panel();
Panel p2 = new Panel();
Panel p3 = new Panel();
Panel p4 = new Panel();
Panel p5 = new Panel();

svs_newlogin()
{

setLayout(bl);                                    //normal screen
p2.setLayout(gbl);                                // center
p3.setLayout(new FlowLayout(FlowLayout.RIGHT));   // submit   
p4.setLayout(new FlowLayout(FlowLayout.LEFT));     // clear
p5.setLayout(new FlowLayout(FlowLayout.RIGHT));    // new


la1 = new JLabel("Welcome to SVS");
la2 = new JLabel("User name");
la3 = new JLabel("Password");
//la4 = new JLabel("Date of Birth");
la5 = new JLabel("Go to Page One --> ");

la1.setForeground(Color.WHITE);
la2.setForeground(Color.WHITE);
la3.setForeground(Color.WHITE);
//la4.setForeground(Color.WHITE);
la5.setForeground(Color.WHITE);

tf1 = new JTextField(20);
//tf2 = new JTextField(20);
pf1 = new JPasswordField(12);

b1 = new JButton("Submit");
b2 = new JButton("Clear");
b3 = new JButton("Go");

gbc.fill = GridBagConstraints.BOTH;

	arrangement(la2,0,0,1,1);
	arrangement(la3,0,1,1,1);
//	arrangement(la4,0,2,1,1);
	arrangement(p3,0,2,1,1);

	arrangement(tf1,1,0,1,1);
//	arrangement(tf2,1,1,1,1);
	arrangement(pf1,1,1,1,1);
	arrangement(p4,1,2,1,1);

p3.add(b1);
p4.add(b2);
p5.add(la5);
p5.add(b3);
p1.add(la1);

add(p1,BorderLayout.NORTH);
add(p5,BorderLayout.SOUTH);
add(p2);


setBackground(c1);
p1.setBackground(Color.BLACK);

setSize(850,600);
setVisible(true);

//addWindowListener(new page2_backside(this));
b1.addActionListener(this);
b3.addActionListener(this);
b2.addActionListener(this);
tf1.addActionListener(this);
//tf2.addActionListener(this);
pf1.addActionListener(this);
tf1.addFocusListener(this);
//tf2.addFocusListener(this);
pf1.addFocusListener(this);
}




public void arrangement(Component c, int col, int row, int hig, int wid)
{

	gbc.gridx = col;
	gbc.gridy = row;
	gbc.gridheight = hig;
	gbc.gridwidth = wid;
	gbl.setConstraints(c,gbc);
	p2.add(c);

}



public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
nameFinal=tf1.getText();
//reg_no=tf2.getText ();
passwordFinal=pf1.getText();

if((nameFinal.equals("")) || (passwordFinal.equals("")))
{
JOptionPane.showMessageDialog(null,"Pleas Enter all the Details");
}
else
{
ojt.storeProfile(nameFinal,passwordFinal,address,gst,pan,email,monum);
System.out.println(address);
System.out.println(gst);
System.out.println(pan);
System.out.println(email);
System.out.println(monum);
JOptionPane.showMessageDialog(null,"The User Name and Password is now Stored");
}
}

if(ae.getSource()==b2)
{
tf1.setText("");
//tf2.setText ("");
pf1.setText("");
}

if(ae.getSource()==b3)
{
new svs_login();
}

validate();
}




public void focusGained(FocusEvent fe)
{

if(fe.getSource()==tf1)
{
tf1.setBackground(Color.PINK);
//tf2.setBackground(Color.WHITE);
pf1.setBackground(Color.WHITE);
count=0;
}

/*if(fe.getSource()==tf2)
{
tf2.setBackground(Color.PINK);
tf1.setBackground(Color.WHITE);
pf1.setBackground(Color.WHITE);
count=0;
}*/

if(fe.getSource()==pf1)
{

if(count == 0)
{
JOptionPane.showMessageDialog(null,"Suggest Strong Password,\n\t use some character like <#$ ");	
count=1;
}

pf1.setBackground(Color.PINK);
//tf2.setBackground(Color.WHITE);
tf1.setBackground(Color.WHITE);

}
validate();
}
public void focusLost(FocusEvent fe)
{
tf1.setBackground(Color.WHITE);
//tf2.setBackground(Color.WHITE);
pf1.setBackground(Color.WHITE);
count=0;
}




/*
public static void main(String str[])
{
new page2_new_register();
}*/
}






