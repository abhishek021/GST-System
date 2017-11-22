package com.org.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GstReturnDatabase {
	
	private static boolean loginStatus=false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new GstReturnDatabase();

	}
	public GstReturnDatabase(){
					String SQLQuery="Create Table Gstdata("+
					  "GSTIN char(15) not null,"+
					  "PURCHASE_AMOUNT varchar (10),"+
					  "SALES_AMOUNT varchar(10),"+
					  "GST_CREDIT varchar(10),"+
					  "TAX_CREDIT varchar(10) ,"+
					  "CREATED_ON varchar(15),"+
					  "primary key(GSTIN)"+
					")";
		try{	
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"system",
			"abhishek021");
			Statement st= con.createStatement();
			ResultSet rs =  st.executeQuery(SQLQuery);
		}
			catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	public static boolean addGstReturn(String cgstin, String cpamount, String csamount, String cgstcredit,
			String ctaxcredit, String cdate) {
		String SQLQuery="Insert into Gstdata values('"+cgstin+"','"+cpamount+"','"+csamount+"','"+cgstcredit+"','"+ctaxcredit+"','"+cdate+"')";
		try{	
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
			con.close();
			
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
		return loginStatus;
	}

}
