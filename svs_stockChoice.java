import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class svs_stockChoice extends JFrame implements ActionListener
{

JLabel la1,la2,la3,la4;
JButton b1,b2,b3;
//JRadioButton[] rb = new JRadioButton[8];
JTextField tf1,tf2;
ButtonGroup bg = new ButtonGroup();

String[] str = {"1st","2nd","3rd","4th","5th","6th","7th","8th"};
int spot = 130, selected = 15;

svs_stockChoice()
{

setLayout(null);

la1 = new JLabel(" What do you want to do?...!! ");
la2 = new JLabel(" Select what to view...!! " );
la3 = new JLabel(" Starting ");
la4 = new JLabel(" Ending   ");

tf1 = new JTextField(5);
tf2 = new JTextField(5);
/*
for(int i=0;i<8;i++)
{
rb[i] = new JRadioButton(str[i]+" 15" );
bg.add(rb[i]);
System.out.println(i);
}
*/
b1 = new JButton("Add");
b2 = new JButton("View");
b3 = new JButton("ok");
b3.setEnabled(false);

la1.setBounds(80,25,190,50);
b1.setBounds(90,80,60,20);
b2.setBounds(170,80,60,20);
b3.setBounds(330,260,50,20);

la2.setBounds(210,100,190,50);
la3.setBounds(240,130,80,40);
la4.setBounds(240,155,80,40);

tf1.setBounds(300,140,40,20);
tf2.setBounds(300,165,40,20);

/*for(int i=0;i<4;i++)
{
rb[i].setBounds(210,spot,90,30);
spot = spot+30;
System.out.println(i);
}

spot=130;
System.out.println(spot);
for(int i=4;i<8;i++)
{
rb[i].setBounds(310,spot,90,30);
spot = spot+30;
System.out.println(i);
}
*/
add(la1);
add(la2);
add(la3);
add(la4);

add(tf1);
add(tf2);

add(b1);
add(b2);
add(b3);

		la2.setEnabled(false);
		la3.setEnabled(false);
		la4.setEnabled(false);
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		b3.setEnabled(false);

/*
for(int i=0;i<8;i++)
{
add(rb[i]);
rb[i].setEnabled(false);
System.out.println(i);
}
*/
setSize(500,330);
setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

}






public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
		new svs_stock(0,0,0);
	if(ae.getSource()==b2)
	{
		for(int i=0;i<8;i++)
		la2.setEnabled(true);
		la3.setEnabled(true);
		la4.setEnabled(true);
		tf1.setEnabled(true);
		tf2.setEnabled(true);
		b3.setEnabled(true);
	}
	if(ae.getSource()==b3)
	{
		int start = Integer.parseInt(tf1.getText());
		int end = Integer.parseInt(tf2.getText());
		int temp_start = start+15;
		if(temp_start>=end)
		{
		new svs_stock(1,start,end);	
		System.out.println("start : "+start+"   end : "+end);
		}
		else
		System.out.println("the end must less than or equal to "+temp_start);
//		new svs_stock(1,start,end);	

	}





/*
		for(int i=0;i<8;i++)
		{
			if(rb[i].isSelected())
			{
			if((rb[i].getText()).equals("1st 15"))
			new svs_stock(1,100,116);	
	
			if((rb[i].getText()).equals("2nd 15"))
			new svs_stock(1,200,216);	

			if((rb[i].getText()).equals("3rd 15"))
			new svs_stock(1,300,316);	

			if((rb[i].getText()).equals("4th 15"))
			new svs_stock(1,400,416);	

			if((rb[i].getText()).equals("5th 15"))
			new svs_stock(1,500,516);	

			if((rb[i].getText()).equals("6th 15"))
			new svs_stock(1,600,616);	

			if((rb[i].getText()).equals("7th 15"))
			new svs_stock(1,700,716);	

			if((rb[i].getText()).equals("8th 15"))
			new svs_stock(1,800,816);	

			else
			System.out.println("False selected : " + rb[i].getText());
			}
		}*/
}



/*

public static void main(String[] args)
{
	new svs_stockChoice();
}
*/
}


