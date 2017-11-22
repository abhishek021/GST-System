package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.org.Database.GstReturnDatabase;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GST_RETURN {

	private JFrame frame;
	private JTextField txtPurchaseamt;
	private JTextField txtSalesamt;
	private JTextField txtOutputGst;
	private JTextField txtTaxCredit;
	private JTextField txtGstin;
	private boolean test=false;
	private JComboBox cDate,cMonth,cYear;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_RETURN window = new GST_RETURN();
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
	public GST_RETURN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setTitle("GST Return");
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().setBackground(new Color(189, 183, 107));
		frame.setBounds(100, 100, 779, 568);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GST RETURN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 11, 743, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PURCHASE AMOUNT. :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(105, 150, 234, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSales = new JLabel("SALES AMOUNT :");
		lblSales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSales.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSales.setBounds(86, 200, 253, 25);
		frame.getContentPane().add(lblSales);
		
		JLabel lblOutputGst = new JLabel("OUTPUT GST ( ON SALES) :");
		lblOutputGst.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutputGst.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOutputGst.setBounds(53, 250, 286, 25);
		frame.getContentPane().add(lblOutputGst);
		
		JLabel lblInputTaxCredit = new JLabel("INPUT TAX (ON PURCHASE) :");
		lblInputTaxCredit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInputTaxCredit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblInputTaxCredit.setBounds(10, 300, 329, 22);
		frame.getContentPane().add(lblInputTaxCredit);
		
		txtPurchaseamt = new JTextField();
		txtPurchaseamt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPurchaseamt.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPurchaseamt.setBounds(400, 150, 324, 30);
		frame.getContentPane().add(txtPurchaseamt);
		txtPurchaseamt.setColumns(10);
		
		txtSalesamt = new JTextField();
		txtSalesamt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSalesamt.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSalesamt.setColumns(10);
		txtSalesamt.setBounds(400, 200, 324, 30);
		frame.getContentPane().add(txtSalesamt);
		
		txtOutputGst = new JTextField();
		txtOutputGst.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOutputGst.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtOutputGst.setColumns(10);
		txtOutputGst.setBounds(400, 250, 324, 30);
		frame.getContentPane().add(txtOutputGst);
		
		txtTaxCredit = new JTextField();
		txtTaxCredit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTaxCredit.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTaxCredit.setColumns(10);
		txtTaxCredit.setBounds(400, 300, 324, 30);
		frame.getContentPane().add(txtTaxCredit);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 139), new Color(0, 0, 139)));
		btnSubmit.setBackground(new Color(205, 92, 92));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSubmit.setBounds(294, 424, 172, 53);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener((e)->{
			addReturn();
		});
		
		JLabel lblGstin = new JLabel("GSTIN :");
		lblGstin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGstin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGstin.setBounds(244, 100, 95, 25);
		frame.getContentPane().add(lblGstin);
		
		txtGstin = new JTextField();
		txtGstin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtGstin.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtGstin.setColumns(10);
		txtGstin.setBounds(400, 100, 324, 30);
		frame.getContentPane().add(txtGstin);
		
		JLabel lblDate = new JLabel("DATE :");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(272, 350, 67, 21);
		frame.getContentPane().add(lblDate);
		
		cDate = new JComboBox(Day);
		cDate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		cDate.setBounds(400, 350, 67, 30);
		frame.getContentPane().add(cDate);
		
		cMonth = new JComboBox(Month);
		cMonth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		cMonth.setBounds(491, 350, 114, 30);
		frame.getContentPane().add(cMonth);
		
		cYear = new JComboBox(Year);
		cYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		cYear.setBounds(629, 350, 95, 30);
		frame.getContentPane().add(cYear);
		
		btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReset.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 139), new Color(0, 0, 139)));
		btnReset.setBackground(new Color(205, 92, 92));
		btnReset.setBounds(552, 424, 172, 53);
		frame.getContentPane().add(btnReset);
		
		btnReset.addActionListener((e)->{
			txtGstin.setText("");
			txtOutputGst.setText("");
			txtPurchaseamt.setText("");
			txtSalesamt.setText("");
			txtTaxCredit.setText("");
			cDate.setSelectedIndex(0);
			cMonth.setSelectedIndex(0);
			cYear.setSelectedIndex(0);
		});
	}

	private void addReturn() {
		// TODO Auto-generated method stub
		String Cgstin,Cpamount,Csamount,Cgstcredit,Ctaxcredit,Cdate;
		Cgstin=txtGstin.getText().trim();
		Cpamount=txtPurchaseamt.getText().trim();
		Csamount=txtSalesamt.getText().trim();
		Cgstcredit=txtOutputGst.getText().trim();
		Ctaxcredit=txtTaxCredit.getText().trim();
		
		String d=cDate.getSelectedItem().toString();
		String m=cMonth.getSelectedItem().toString();
		String y=cYear.getSelectedItem().toString();
		Cdate= d + "/" + m + "/" + y;
		try{
			test=GstReturnDatabase.addGstReturn(Cgstin,Cpamount,Csamount,Cgstcredit,Ctaxcredit,Cdate);
			if(test==true)
				JOptionPane.showMessageDialog(frame, "GST filling successfully completed");
			else
				JOptionPane.showMessageDialog(frame, "Error while filling GST,try again later");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
