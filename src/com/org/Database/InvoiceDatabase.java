package com.org.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InvoiceDatabase {
	private static boolean flag;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//new InvoiceDatabase();

	}
	public InvoiceDatabase() throws SQLException{
		try {
		String SQLQuery="Create Table Invoicedata("+
				  "GSTIN varchar(20) not null,"+
				  "INVOICE_NUMBER varchar (20) not null,"+
				  "INVOICE_TYPE varchar(20) not null,"+
				  "PLACE varchar(15),"+
				  "DATED varchar(15),"+
				  "GST_RATE varchar(5),"+
				  "Purchase_Type varchar(30),"+
				  "CGST_AMOUNT varchar(10),"+
				  "SGST_AMOUNT varchar(10),"+
				  "IGST_AMOUNT varchar(10),"+
				  "TOTAL varchar(10),"+
				  "TOTAL_Payable varchar(10),"+
				  "PRIMARY KEY(INVOICE_NUMBER)"+
				")";
		
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "abhishek021");
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery(SQLQuery);
		con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean addInvoice(String cgstin, String cinvoiceNo, String cinvoiceType, String cplace, String cdate,
			float gst, String purchaseType, float cgst, float sgst, float igst, float total, float totalpayable) {
		try{
		String SQLQuery="Insert into Invoicedata Values('"+cgstin+"','"+cinvoiceNo+"','"+cinvoiceType+"','"+cplace+"','"+cdate+"','"+gst+"','"+purchaseType+"','"+cgst+"','"+sgst+"','"+igst+"','"+total+"','"+totalpayable+"')";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "abhishek021");
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery(SQLQuery);
		
		if(rs.next())
			flag=true;
		else
			flag=false;
		
		con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	public static void searchInvoice(String trim, String cdate) {
		// TODO Auto-generated method stub
		String SQLQuery="Select * from Invoicedata where INVOICE_NUMBER='"+trim+"' and DATED='"+cdate+"'";
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
	            "jdbc:oracle:thin:@localhost:1521:xe",
	            "system",
	            "abhishek021");
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery(SQLQuery);
		    JTable table = new JTable(buildTableModel(rs));
		    JOptionPane.showMessageDialog(null, new JScrollPane(table));
			}catch(Exception e){
				System.out.println(e);
			}
	}
	private static TableModel buildTableModel(ResultSet rs) throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	public static void quickSearchInvoice(String trim) {
		// TODO Auto-generated method stub
		String SQLQuery="Select * from Invoicedata where INVOICE_NUMBER='"+trim+"'";
		try{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "abhishek021");
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery(SQLQuery);
	    JTable table = new JTable(buildTableModel(rs));
	    JOptionPane.showMessageDialog(null, new JScrollPane(table));
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}
