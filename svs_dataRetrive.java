import java.sql.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class svs_dataRetrive
{
	
svs_dataRetrive()
{

}


public String userVerification(String name, String password)	
{

	String signal="false";	

	String line, userData;
	String temp_name="",temp_pass="";	

String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
        
        try{ 
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      	System.out.println("Database Connected");
  		} catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	try {
	stmt  =con.createStatement();	
	ResultSet rs=stmt.executeQuery("select Name from usr_profile" );
	PreparedStatement ps=null;
while(rs.next())
{	
	if((rs.getString("Name")).equals(name))
	{
		signal="true";
	ps = con.prepareStatement("select Password from usr_profile where Name=?");
	
	ps.setString(1,name);

	rs = ps.executeQuery();
		while(rs.next())
		{
			if((rs.getString("Password")).equals(password))
			{
			 System.out.print(rs.getObject(1)+"\t");
			 signal="true";
			}
			else
			{
			 signal="false2";	
			 JOptionPane.showMessageDialog(null,"Invalid Password");
			}
		}
	}
}
	if(signal.equals("false"))
	{
		JOptionPane.showMessageDialog(null,"User not found");
	}

	ps.close();
	rs.close();
	stmt.close();
	con.close();	
	} catch(Exception ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}	

return signal;
}







public String retriveProfile(String name, String password, int i)
{

	String signal="",userdata="";	

	String line;
	String temp_name="",temp_pass="";	

String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
        
        try{ 
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      	System.out.println("Database Connected");
  		} catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	try {
	stmt  =con.createStatement();	
	ResultSet rs;	
	PreparedStatement ps=null;

while(true)
{
	if(i==0)
	{
	ps = con.prepareStatement("select Name from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}

	if(i==1)
	{
	ps = con.prepareStatement("select Password from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}
  
	if(i==2)
	{
	ps = con.prepareStatement("select Address from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}

	if(i==3)
	{
	ps = con.prepareStatement("select GST from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}

	if(i==4)
	{
	ps = con.prepareStatement("select PAN from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}

	if(i==5)
	{
	ps = con.prepareStatement("select Mobile from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}

	if(i==6)
	{
	ps = con.prepareStatement("select Email from usr_profile where Name=?");

	ps.setString(1,name);

	rs=ps.executeQuery();
	rs.next();
	userdata = rs.getString(1);
	break;
	}
}

	rs.close();
	stmt.close();
	con.close();	
	} catch(Exception ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}	

return userdata;
}









public LinkedList<String> retriveStock(int condition, int start, int end)
{

	String stock;
	LinkedList<String> stockses = new LinkedList<String>();
	int i = 0;

String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
        
        try{ 
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      	System.out.println("Database Connected");
  		} catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

try {
	stmt  =con.createStatement();	
	ResultSet rs;	
	PreparedStatement ps;

while(true)
{

	if(condition == 10)
	{
	ps = con.prepareStatement("select item_code from stock where item_code>=? and item_code<=?");
	
	ps.setInt(1,start);
	ps.setInt(2,end);

	rs = ps.executeQuery();
i=0;	
	while(rs.next())
	{
		stock = rs.getString(1);
		stockses.add(stock);
		i++;
	}
	break;
	}

	if(condition == 20)
	{
	ps = con.prepareStatement("select item_name from stock where item_code>=? and item_code<=?");
	
	ps.setInt(1,start);
	ps.setInt(2,end);

	rs = ps.executeQuery();
i=0;	
	while(rs.next())
	{
		stock = rs.getString(1);
		stockses.add(stock);
		i++;
	}
	break;
	}
	
	if(condition == 30)
	{
	ps = con.prepareStatement("select item_qty from stock where item_code>=? and item_code<=?");
	
	ps.setInt(1,start);
	ps.setInt(2,end);

	rs = ps.executeQuery();
i=0;	
	while(rs.next())
	{
		stock = rs.getString(1);
		stockses.add(stock);
		i++;
	}
	break;
	}

	if((condition==0) && (start>900))
	{
		rs = stmt.executeQuery("select item_name from stock");
	while(rs.next())
	{
		stock = rs.getString(1);	
		stockses.add(stock);
	}
	break;
	}

}
	rs.close();
	stmt.close();
	con.close();	
} catch(Exception ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}	


return stockses;
}












public int retriveQty(String item1)
{

	String[] qty = new String[15];
	int qtys=0;// = new LinkedList<Integer>();
	int i = 0;

//LinkedList<String> item = new LinkedList<String>();

//item = item1;

String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
        
        try{ 
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      	System.out.println("Database Connected");
  		} catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

try {
	stmt  =con.createStatement();	
	ResultSet rs=null;	
	PreparedStatement ps=null;

//	Iterator<String> itm = item.iterator();

//		for(String itm : item)
//		{
			ps = con.prepareStatement("select item_qty from stock where item_name = ?");
			ps.setString(1,item1);
			rs = ps.executeQuery();
			if(rs.next())
				qtys = rs.getInt("item_qty");
//		}
			rs.close();
			ps.close();
			con.close();

     }catch(Exception e){
	System.err.println("SQLException: " + e.getMessage()); }

return qtys;
}
		















/*
public String retriveStock(String name, String password, int i)
{
String line, userData="",item_stk="";

File f = new File(name);

if(f.exists()==true)
{ 

try{

	DataInputStream fis = new DataInputStream(new FileInputStream(name));
	String pass = fis.readLine();
	System.out.println(pass);
	
	String fileName = name+".csv";
	String temp_name="",temp_pass="",temp_add,temp_gst,temp_pan,temp_em,temp_mno;	
	
	BufferedReader reader = new BufferedReader(new FileReader(fileName));

	while((line = reader.readLine()) != null)
	{
		String[] parts = line.split(",");
		if(parts[0].equals("Shirt") && i==0)
		{
			item_stk = parts[1];
			break;
		}
		else if(parts[0].equals("T-Shirt") && i==1)
		{
			item_stk = parts[1];
			break;
		}
		else if(parts[0].equals("Pant") && i==2)
		{
			item_stk = parts[1];
			break;
		}
	}
	fis.close();
	reader.close();

}catch(IOException iox)
{
	System.out.println("");
}
}
else
{
	JOptionPane.showMessageDialog(null,"User not found");
}
return item_stk;
}

*/





}

/*
public void windowClosing(WindowEvent we)
{
obj.dispose();
}
*/




