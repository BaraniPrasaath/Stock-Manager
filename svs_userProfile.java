import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class svs_userProfile extends JFrame implements ActionListener
{

svs_dataRetrive data = new svs_dataRetrive();
svs_dataStore data1 = new svs_dataStore();

ImageIcon profile = new ImageIcon("profile.jpg");

JTextField tf[] = new JTextField[7];
JButton b1,b2;
JLabel la1,la2,la3,la4,la5,la6,la7,la8,ila;

svs_login obj;

svs_userProfile(svs_login obj1)
{
obj = obj1;
setLayout(null);

Image image = profile.getImage();
Image scaled = image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
ImageIcon scaledicon = new ImageIcon(scaled);
profile = scaledicon;

ila = new JLabel(profile);
ila.setBounds(550,180,200,200);

la1 = new JLabel("Your Profile");
la2 = new JLabel("Name");
la3 = new JLabel("Password");
la4 = new JLabel("Address");
la5 = new JLabel("GSTIN");
la6 = new JLabel("PAN");
la7 = new JLabel("E-mail");
la8 = new JLabel("Contact");

la1.setBounds(400,30,100,70);
la2.setBounds(220,150,70,30);
la3.setBounds(220,200,70,30);
la4.setBounds(220,250,70,30);
la5.setBounds(220,300,70,30);
la6.setBounds(220,350,70,30);
la7.setBounds(220,400,70,30);
la8.setBounds(220,450,70,30);

tf[0] = new JTextField(4);
tf[1] = new JTextField(4);
tf[2] = new JTextField(4);
tf[3] = new JTextField(20);
tf[4] = new JTextField(20);
tf[5] = new JTextField(20);
tf[6] = new JTextField(4);

tf[0].setBounds(300,150,200,30);
tf[1].setBounds(300,200,200,30);
tf[2].setBounds(300,250,200,30);
tf[3].setBounds(300,300,200,30);
tf[4].setBounds(300,350,200,30);
tf[5].setBounds(300,400,200,30);
tf[6].setBounds(300,450,200,30);

b1 = new JButton("OK");
b2 = new JButton("Edit");

b1.setBounds(530,480,60,30);
b2.setBounds(600,480,60,30);

getContentPane().setBackground(Color.GRAY);

for(int i=0;i<7;i++)
add(tf[i]);

add(ila);
add(la1);
add(la2);
add(la3);
add(la4);
add(la5);
add(la6);
add(la7);
add(la8);

add(b1);
add(b2);

String temp_var="";
for(int i=0;i<7;i++)
{
	temp_var=data.retriveProfile(obj.nameFinal, obj.passwordFinal, i);
	tf[i].setText(temp_var);
	tf[i].setEnabled(false);
}
	JOptionPane.showMessageDialog(null,"Your Profile");
setSize(850,600);
setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);

}





String[] editedData = new String[7];

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		String old_name=obj.nameFinal;
		
		for(int i=0;i<7;i++)
			editedData[i] = tf[i].getText();
		data1.updateProfile(old_name, editedData[0], editedData[1], editedData[2], editedData[3], editedData[4], editedData[5], editedData[6]);
		JOptionPane.showMessageDialog(null,"Data is edited and stored sucessfully");
		for(int i=0;i<7;i++)
			tf[i].setEnabled(false);
		
		//dispose();
	}	

	if(ae.getSource()==b2)
	{
		//JOptionPane.showMessageDialog(null,"Technical issues you can't edit");
		for(int i=0;i<7;i++)
			tf[i].setEnabled(true);
	}	
}






/*
public static void main(String[] args)
{
new svs_userProfile(new svs_login());
}*/
}