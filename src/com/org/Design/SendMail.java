package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.org.mailApi.EmailSender;
import com.org.mailApi.EmailValid;
import com.org.mailApi.Validation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelListener;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class SendMail {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendMail window = new SendMail();
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
	public SendMail() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Summary");
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.setVisible(true);
		frame.setBounds(100, 100, 561, 491);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("SEND NOTICE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 218, 185));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblUserEmailId = new JLabel("USER EMAIL ID :");
		lblUserEmailId.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setText("Type your message here");
		
		JButton btnSend = new JButton("SEND");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.addActionListener((e)->{
			sendmail();
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
					frame.setVisible(false);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUserEmailId)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(130)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUserEmailId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend))
					.addGap(19))
		);
		frame.getContentPane().setLayout(groupLayout);

	}

	private void sendmail() {
		// TODO Auto-generated method stub
		String msg=textArea.getText().trim();
		String to=textField.getText().trim();
		try{
			if(Validation.emailcheck(to))
			EmailValid.Email(msg,to);
			else
				JOptionPane.showInternalMessageDialog(frame, "Invalid email id");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	public static DefaultTableModel buildTableModel(ResultSet rst)
	        throws SQLException {

	    ResultSetMetaData metaData = rst.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount= 6;//= metaData.getColumnCount();
	    //for (int column = 1; column <= 5; column++) {
	        columnNames.add("GSTIN");
	        columnNames.add("Invoice_No");
	        columnNames.add("Invoice_Type");
	        columnNames.add("Invoice_Date");
	        columnNames.add("Item_Name");
	        columnNames.add("Total_Payable");
	   // }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rst.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rst.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
}
