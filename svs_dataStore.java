import java.util.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

class svs_dataStore
{

svs_dataStore()
{
}	                                            


public void storeProfile(String name, String password, String address, String gst, String pan, String email, String monum)
{
int i = 1;
String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
	             
        try 
		{
            
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      						System.out.println("Database Connected");
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
  
	try{

	stmt  =con.createStatement();	
	PreparedStatement ps=null;

	ps = con.prepareStatement("insert into usr_profile(User_id,Name,Password,Address,GST,PAN,Mobile,Email) values(?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, i);
		ps.setString(2, name);
		ps.setString(3, password);	
		ps.setString(4, address);	
		ps.setString(5, gst);
		ps.setString(6, pan);	
		ps.setString(7, monum);
		ps.setString(8, email);

	int rs = ps.executeUpdate();
	
	
			stmt.close();
			ps.close();
			con.close();	

	
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
}








public void updateProfile(String old_name, String name, String password, String address, String gst, String pan, String email, String monum)
{
int i = 1;
String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
	             
        try 
		{
            
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      						System.out.println("Database Connected");
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	
  
	try{

	stmt  =con.createStatement();
	int rs;	
	PreparedStatement ps=null;

	ps = con.prepareStatement("update usr_profile set Name=? where Name=?");

	ps.setString(1,name);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();
		
	
	ps = con.prepareStatement("update usr_profile set Password=? where Name=?");

	ps.setString(1,password);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();
		

	ps = con.prepareStatement("update usr_profile set Address=? where Name=?");

	ps.setString(1,address);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();
		

	ps = con.prepareStatement("update usr_profile set GST=? where Name=?");

	ps.setString(1,gst);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();	


	ps = con.prepareStatement("update usr_profile set PAN=? where Name=?");

	ps.setString(1,pan);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();


	ps = con.prepareStatement("update usr_profile set Email=? where Name=?");

	ps.setString(1,email);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();
		

	ps = con.prepareStatement("update usr_profile set Mobile=? where Name=?");

	ps.setString(1,monum);
	ps.setString(2,old_name);

	rs = ps.executeUpdate();
		
			stmt.close();
			ps.close();
			con.close();	





	
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
}










public void storeStock(LinkedList<String> code1,LinkedList<String> item1,LinkedList<Integer> qty1)
{

LinkedList<String> code = new LinkedList<String>();
LinkedList<String> item = new LinkedList<String>();
LinkedList<Integer> qty = new LinkedList<Integer>();

code = code1;
item = item1;
qty = qty1;

String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
	             
        try 
		{
            
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      						System.out.println("Database Connected");
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	  try{	
		PreparedStatement ps;
		Iterator<String> cd = code.iterator();
		Iterator<String> itm = item.iterator();
		Iterator<Integer> qt = qty.iterator();

		for(int i=0;i<15;i++)
		{
		ps = con.prepareStatement("insert into stock (item_code,item_name,item_qty) values(?,?,?)");
		ps.setString(1,cd.next());  
		ps.setString(2,itm.next());  
		ps.setInt(3,qt.next());  
		ps.executeUpdate();
		ps.close();
		}
		
	/*	for(String cd : code)
		{
			ps = con.prepareStatement("insert into stock (item_code) values(?)");
			ps.setString(1,cd);
			ps.executeUpdate();
			ps.close();
		}

		for(String itm : item)
		{
			ps = con.prepareStatement("insert into stock (item_name) values(?)");
			ps.setString(1,itm);
			ps.executeUpdate();
			ps.close();
		}

		for(int qt : qty)
		{
			ps = con.prepareStatement("insert into stock (item_qty) values(?)");
			ps.setString(1,Integer.toString(qt));
			ps.executeUpdate();
			ps.close();
		}
*/
		con.close();	
		}catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
}










public void updateStock(LinkedList<String> code,String item,int qty)
{
String url = "jdbc:mysql://localhost:3306/rrs";

		Connection con=null;				
		Statement stmt;
	
		String driver = "com.mysql.cj.jdbc.Driver";
 				
	             
        try 
		{
            
		Class.forName(driver);          
		con = DriverManager.getConnection(url,"root","Bar@23");
      						System.out.println("Database Connected");
		} catch(	Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	  try{	
		PreparedStatement ps;
		/*for(int i=0;i<15;i++)
		{
		PreparedStatement ps = con.prepareStatement("update stock set item_qty=? where item_name=?");
		ps.setString(1,Integer.toString(qty[i]));  
		ps.setString(2,item[i]);  
		ps.executeUpdate();
		ps.close();
		}*/



//int i = 0;
//		for(int qt : qty) 
//		{
			ps = con.prepareStatement("update stock set item_qty=? where item_name=?");
			ps.setInt(1,qty);  
			ps.setString(2,item);
			ps.executeUpdate();
			ps.close();
//			i++;
//		}


		con.close();	
		}catch(Exception ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
}







/*
public void windowClosing(WindowEvent we)
{
obj.dispose();
}
*/
}



