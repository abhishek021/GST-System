package com.org.Database;

import java.sql.*;

public class AdminDatabase {
	public static Boolean loginStatus = false;

	public static void main(String[] args) throws SQLException {
		
		AdminDatabase obj = new AdminDatabase("test021","abhishek");
		System.out.println(obj.loginStatus);
	}
	public AdminDatabase(String userName,String Password)
	{
		try{
			
			final String SQLQuery="select * from govtdata where UserName='"+userName +"'and passWord='"+Password+"'";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","abhishek021");
			Statement st= Con.createStatement();
			ResultSet rs =  st.executeQuery(SQLQuery);
			if(rs.next())
			{
				loginStatus=true;
			}
			else
				loginStatus=false;
			Con.close();
				
			
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public AdminDatabase() throws SQLException {
	try{
		String SQLQuery="Create Table Govtdata("+
		  "NAME varchar(20) not null,"+
		  "EMAIL varchar(30),"+
		  "USERNAME varchar(10) not null,"+
		  "MOBNO varchar(10) not null,"+
		  "SEX varchar(10),"+
		  "BDATE varchar(15),"+
		  "PASSWORD varchar(20) not null,"+
		  "primary key(USERNAME)"+
		")";

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe",
		"system",
		"abhishek021");
		Statement st= con.createStatement();
		ResultSet rs =  st.executeQuery(SQLQuery);
		if(rs.next())
		{
		  loginStatus = true;
		}
	System.out.println(loginStatus);
		con.close();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	public static boolean addGovt(String cname, String cmail,String cUsername,String cphone,String Csex, String cdob,
			String cpassword) throws Exception{
		final String SQLQuery="INSERT INTO GOVTDATA VALUES('"+cname+"','"+cmail+"','"+cUsername+"','"+cphone+"','"+Csex+"','"+cdob+"','"+cpassword+"')";
		Class.forName("oracle.jdbc.OracleDriver");					
		Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "abhishek021");
		Statement st= con.createStatement();
		ResultSet rs =  st.executeQuery(SQLQuery);
		if(rs.next())
		{
			con.close();
		  return true;
		}
		else{
			con.close();
			return false;
		}
	}

}
