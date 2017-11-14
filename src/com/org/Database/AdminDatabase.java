package com.org.Database;

import java.sql.*;
import java.sql.DriverManager;

public class AdminDatabase {
	public static Boolean loginStatus = false;

	public static void main(String[] args) {
		
		///AdminDatabase obj = new AdminDatabase("amitkm","amitkm");
		//System.out.println(obj.loginStatus);
	}
	public AdminDatabase(String userName,String Password)
	{
		try{
			final String SQLQuery="select * from ADMIN where UserName='"+userName +"'and passWord='"+Password+"'";
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
	public AdminDatabase() {
		
	}

}
