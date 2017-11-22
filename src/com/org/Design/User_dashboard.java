package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.SystemColor;

public class User_dashboard {

	private JFrame frame;
	private JButton btnNewInvoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_dashboard window = new User_dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public User_dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("User Dash Board");
		frame.setVisible(true);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		frame.setBounds(100, 100, 511, 464);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   USER DASH-BOARD");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(41, 11, 391, 50);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewInvoice = new JButton("NEW  INVOICE");
		btnNewInvoice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 100, 0), new Color(0, 100, 0)));
		btnNewInvoice.setBackground(new Color(205, 133, 63));


		btnNewInvoice.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewInvoice.setBounds(78, 108, 354, 92);
		frame.getContentPane().add(btnNewInvoice);
		
		JButton btnInvoiceSearch = new JButton("INVOICE SEARCH");
		btnInvoiceSearch.setBackground(new Color(255, 160, 122));
		btnInvoiceSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 100, 0), new Color(0, 100, 0)));
		btnInvoiceSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInvoiceSearch.setBounds(271, 238, 161, 61);
		frame.getContentPane().add(btnInvoiceSearch);
		
		
		JButton btnGstReturn = new JButton("GST RETURN");
		btnGstReturn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 100, 0), new Color(0, 100, 0)));
		btnGstReturn.setBackground(new Color(255, 160, 122));
		btnGstReturn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGstReturn.setBounds(78, 236, 166, 63);
		frame.getContentPane().add(btnGstReturn);
		
		
		JButton btnInvoiceSummary = new JButton("INVOICE \r\nSUMMARY");
		btnInvoiceSummary.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 139), new Color(0, 0, 205)));
		btnInvoiceSummary.setBackground(new Color(210, 180, 140));
		btnInvoiceSummary.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInvoiceSummary.setBounds(78, 335, 354, 63);
		frame.getContentPane().add(btnInvoiceSummary);
		
		btnInvoiceSummary.addActionListener((e)->{
			summary();
		});
		
		
		btnNewInvoice.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewInvoice) {
					new Invoice();
				}
			}
		});
		
		
		btnInvoiceSearch.addActionListener((e)->{
			new InvoiceSearch();
		});
		
		btnGstReturn.addActionListener((e)->{
			new GST_RETURN();
		});
		
	}

	private void summary() {
		// TODO Auto-generated method stub
		String SQLQuery="Select * from Invoicedata";
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
	
		
}

