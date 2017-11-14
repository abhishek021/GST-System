package com.org.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDatabase {

	public static Boolean loginStatus=false;
	public static void main(String[] args) throws SQLException {
			//UserDatabase obj=new UserDatabase("852963741","password");	
	/*try {
			boolean test=addUser("123456789", "Shiwanjha", "789456123", "12/04/1996", "uit", "male", "abhishekpass", "personal", "456123456123", "4567896544","abc@gmail.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public UserDatabase(String gstIn,String Password) throws SQLException
	{
		
		try{
			String SQLQuery="SELECT * FROM USERDATA WHERE GSTIN='"+gstIn+"' and PASSWORD='"+Password+"'";
			/*String SQLQuery="Create Table Userdata("+
							  "GSTIN char(10) not null,"+
							  "NAME varchar (20) not null,"+
							  "MOBNO char(10) not null,"+
							  "BDATE varchar(15),"+
							  "ADDRESS varchar(30),"+
							  "SEX varchar(10),"+
							  "PASSWORD varchar(20) not null,"+
							  "BUSINESSTYPE varchar(15) ,"+
							  "AADHAR varchar(12) not null,"+
							  "PAN varchar(10) not null,"+
							  "EMAIL varchar(30),"+
							  "primary key(GSTIN)"+
							")";*/

			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "abhishek021");
			Statement st= con.createStatement();
			ResultSet rs =  st.executeQuery(SQLQuery);
			//ResultSet rs1=stmt.executeUpdate(sql); ->for operations like INSERT,UPDATE,DELETE
		    /*ResultSetMetaData rsmd=rs.getMetaData();
		    System.out.println("Test");
		    
		    int count=rsmd.getColumnCount();
		    int i=1;
		    while(count>=i){
		    	System.out.print(rsmd.getColumnName(i)+"\t");
		     	System.out.println(rsmd.getColumnTypeName(i));
		     	i++;
		    }*/
		if(rs.next())
			{
			  loginStatus = true;
			}
		System.out.println(loginStatus);
			con.close();
			
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public UserDatabase()
	{
		
	}
	public static boolean addUser(String value,String cname,String cphone, String cdob, String cadd,String Csex, String cpassword, String cbusinesstype, String cadhar, String cpan, String cmail) throws Exception{
		final String SQLQuery="INSERT INTO USERDATA VALUES('"+value+"','"+cname+"','"+cphone+"','"+cdob+"','"+cadd+"','"+Csex+"','"+cpassword+"','"+cbusinesstype+"','"+cadhar+"','"+cpan+"','"+cmail+"')";
		Class.forName("oracle.jdbc.OracleDriver");					//TO_CHAR('"+cdob+"','DD-MM-YYYY'),
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

