package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.RepaintManager;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.org.Database.InvoiceDatabase;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class InvoiceSearch {

	private JFrame frame;
	private JLabel lblInvoiceNumber;
	private JTextField textField_1;
	private JLabel lblIssuedOn;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_4;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	private String select[]={"select","Excise","VAT","Retail/Commercial"};
	private String status[]={"select","Approved","Scheduled","Payment Sent"};
	private JLabel lblQuickSearch;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceSearch window = new InvoiceSearch();
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
	public InvoiceSearch() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Invoice Search");
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 913, 427);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblInvoiceNumber = new JLabel("Invoice Number :");
		lblInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInvoiceNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceNumber.setForeground(Color.BLUE);
		lblInvoiceNumber.setBounds(10, 96, 161, 25);
		frame.getContentPane().add(lblInvoiceNumber);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(181, 93, 230, 28);
		frame.getContentPane().add(textField_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(178, 34, 34), new Color(139, 0, 0)));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSearch.setForeground(Color.RED);
		btnSearch.setBounds(181, 300, 170, 53);
		frame.getContentPane().add(btnSearch);
		
		btnSearch.addActionListener((e)->{
			search();
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReset.setForeground(Color.RED);
		btnReset.setBounds(421, 300, 170, 53);
		frame.getContentPane().add(btnReset);
		
		btnReset.addActionListener((e)->{
			textField_1.setText("");
			textField_3.setText("");
			comboBox_2.setSelectedIndex(0);
			comboBox_3.setSelectedIndex(0);
			comboBox_4.setSelectedIndex(0);
			
		});
		
		lblIssuedOn = new JLabel("Issued On :");
		lblIssuedOn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIssuedOn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIssuedOn.setForeground(Color.BLUE);
		lblIssuedOn.setBackground(Color.BLUE);
		lblIssuedOn.setBounds(454, 94, 111, 23);
		frame.getContentPane().add(lblIssuedOn);
		
		comboBox_2 = new JComboBox(Day);
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_2.setBounds(575, 94, 68, 25);
		frame.getContentPane().add(comboBox_2);
		
		comboBox_3 = new JComboBox(Month);
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_3.setBounds(664, 94, 96, 25);
		frame.getContentPane().add(comboBox_3);
		
		comboBox_4 = new JComboBox(Year);
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comboBox_4.setBounds(782, 94, 89, 25);
		frame.getContentPane().add(comboBox_4);
		
		lblQuickSearch = new JLabel("Quick Search :");
		lblQuickSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuickSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuickSearch.setForeground(Color.BLUE);
		lblQuickSearch.setBackground(Color.WHITE);
		lblQuickSearch.setBounds(230, 224, 144, 25);
		frame.getContentPane().add(lblQuickSearch);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_3.setBounds(384, 225, 296, 25);
		textField_3.setToolTipText("Enter Invoice Number");
		frame.getContentPane().add(textField_3);
		
		lblNewLabel_3 = new JLabel("                       Invoice Search");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(178, 34, 34));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_3.setBounds(10, 11, 731, 53);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(664, 300, 170, 53);
		frame.getContentPane().add(btnBack);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBackground(new Color(255, 0, 0));
		lblOr.setFont(new Font("Ubuntu", Font.BOLD, 26));
		lblOr.setBounds(471, 166, 46, 23);
		frame.getContentPane().add(lblOr);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
					frame.setVisible(false);
			}
		});
	}

	private void search() {
		String Cdate;
		String d=(String)comboBox_2.getSelectedItem();
		String m=(String)comboBox_3.getSelectedItem();
		String y=(String)comboBox_4.getSelectedItem();
		Cdate=d +"/"+ m + "/" + y;
		if(textField_3.getText().trim()=="")
			InvoiceDatabase.searchInvoice(textField_1.getText().trim(),Cdate);
		else
			InvoiceDatabase.quickSearchInvoice(textField_3.getText().trim());
			
		
	}
}
