import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class svs_stock extends JFrame implements ActionListener
{

	svs_dataStore stkStore = new svs_dataStore();
	svs_dataRetrive stkRetv = new svs_dataRetrive();

int shirt_stk=0,tshirt_stk=0,pant_stk=0;
String temp="";
int temp1=0;
LinkedList<String> code = new LinkedList<String>();
LinkedList<String> item = new LinkedList<String>();
LinkedList<Integer> qty = new LinkedList<Integer>();
LinkedList<String> qty2 = new LinkedList<String>();

JTextField[] tf = new JTextField[60];
JButton b1,b2;
JLabel la1,la2,la3,la4,la5,la6,la7,la8,la9;

BorderLayout bl = new BorderLayout();
FlowLayout fl = new FlowLayout();
GridBagLayout gbl = new GridBagLayout();
GridBagConstraints gbc = new GridBagConstraints();

Panel p1 = new Panel();
Panel p2 = new Panel();
Panel p3 = new Panel();
Panel p4 = new Panel();

svs_stock(int decesion, int start, int end)
{

setLayout(bl);
p1.setLayout(gbl);
p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
p3.setLayout(new FlowLayout(FlowLayout.LEFT));

for(int i=0;i<15;i++)
{
int j=4;
tf[i] = new JTextField(j);
}
for(int i=15;i<30;i++)
{
int j=4;
tf[i] = new JTextField(j);
}
for(int i=30;i<45;i++)
{
int j=30;
tf[i] = new JTextField(j);
}
//int fault = 0;
for(int i=45;i<60;i++)
{
int j=4;
tf[i] = new JTextField(j);
//tf[i].setText(Integer.toString(fault));
}

int j=1;
for(int i=0;i<15;i++)
{
tf[i].setText(Integer.toString(j));
tf[i].setEnabled(false);
j++;
}

la1 = new JLabel("Stock Details");
la2 = new JLabel("Bill No");
la3 = new JLabel("Date");
la4 = new JLabel("Party Name");
la5 = new JLabel("Narration");
la6 = new JLabel("Sno");
la7 = new JLabel("Code");
la8 = new JLabel("Item");
la9 = new JLabel("Qty");

b1 = new JButton("Save");
b2 = new JButton("Quit");

p2.add(b1);
p3.add(b2);

gbc.fill = GridBagConstraints.BOTH;

	arrangements(la6,0,0,1,1);
	j=1;
	for(int i=0;i<15;i++)
	{
		arrangements(tf[i],0,j,1,1);
		j++;
	}

	arrangements(la7,1,0,1,1);
	j=1;
	for(int i=15;i<30;i++)
	{
		arrangements(tf[i],1,j,1,1);
		j++;
	}
	arrangements(p2,2,16,1,1);

	arrangements(la8,2,0,1,1);
	j=1;
	for(int i=30;i<45;i++)
	{
		arrangements(tf[i],2,j,1,1);
		j++;
	}
	arrangements(p3,3,16,1,1);

	arrangements(la9,3,0,1,1);
	j=1;
	for(int i=45;i<60;i++)
	{
		arrangements(tf[i],3,j,1,1);
		j++;
	}

p4.add(la1);
add(p4,BorderLayout.NORTH);
add(p1);

try{
if(decesion == 1)
{
	
j=15;
	code=stkRetv.retriveStock(10,start,end);

	for(String cd : code)
	{
		tf[j].setText(cd);
		tf[j].setEnabled(true);
		j++;
	}

j=30;
	item=stkRetv.retriveStock(20,start,end);

	for(String itm : item)
	{
		tf[j].setText(itm);
		tf[j].setEnabled(true);
		j++;
	}

j=45;
	qty2=stkRetv.retriveStock(30,start,end);

	for(String qt : qty2)
	{
		tf[j].setText(qt);
		tf[j].setEnabled(true);
		j++;
	}

	b1.setEnabled(false);
}
}catch(java.util.NoSuchElementException ne)
{ System.out.println("--");}


setSize(850,600);
setVisible(true);

b1.addActionListener(this);
b2.addActionListener(this);
}


public void arrangements(Component c, int col, int row, int ht, int wd)
{
	gbc.gridx = col;
	gbc.gridy = row;
	gbc.gridheight = ht;
	gbc.gridwidth = wd;
	gbl.setConstraints(c,gbc);
	p1.add(c);
}




public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		for(int i=15;i<30;i++)
			code.add(tf[i].getText());
	
		for(int i=30;i<45;i++)
			item.add(tf[i].getText());

		for(int i=45;i<60;i++)
		{
			String temp_qty = tf[i].getText();
			if(!temp_qty.isEmpty())
				qty.add(Integer.parseInt(temp_qty));
		}
		
		stkStore.storeStock(code,item,qty);
		JOptionPane.showMessageDialog(null,"Your Stored Stock");
	}

	if(ae.getSource()==b2)
		dispose();
}

/*
public static void main(String[] args)
{
new svs_stock();
}*/
}