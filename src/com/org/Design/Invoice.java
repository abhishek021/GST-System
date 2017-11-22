package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.org.Database.InvoiceDatabase;
import com.org.Database.UserDatabase;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.util.Random;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

import javax.swing.JScrollBar;

public class Invoice {

	private JFrame frame;
	private boolean flag=false;
	private JTextField textField_gstin;
	private JTextField textField_invoiceNo;
	private JTextField textField_place;
	private JComboBox comboBox_1,comboBox_2,comboBox_3,comboBox_Invoicetype;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	private String select[]={"select","Excise","VAT","Retail/Commercial"};
	private JLabel lblTotalIn;
	private boolean test;
	private JTextField txtName,txtName_1,txtName_2,txtName_3,txtName_4;
	private JTextField textQuantity;
	private JTextField textQuantity_1;
	private JTextField textQuantity_2;
	private JTextField textQuantity_3;
	private JTextField textQuantity_4;
	private JTextField textPrice,textPrice_1,textPrice_2,textPrice_3,textPrice_4;
	private JLabel lblIgst,lblSgst,lblCgst,lblTotal_payable,lblSgstRate,lblCgstRate,lblIgstRate;
	private JComboBox comboBox;
	private String rate[]={"Select","5","12","18","28"};
	private JLabel lblType;
	private JComboBox comboBox_4;
	private String type[]={"Select","Inter_State","Intra_State"};
	private float cgst,sgst,igst=0;
	private float totalpayable=0,total,gst;
	private String PurchaseType;
	private JButton btnReset;
	/**
	 * @wbp.nonvisual location=112,9
	 */
	//private final JScrollBar scrollBar = new JScrollBar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoice window = new Invoice();
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
	public Invoice() {
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(50, 0, 600, 753);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//JPanel panel=new JPanel();
		//JScrollPane pane = new JScrollPane(panel);
        //frame.setContentPane(pane);

		
		JLabel lblGstFilling = new JLabel("   INVOICE");
		lblGstFilling.setBounds(140, 11, 399, 61);
		lblGstFilling.setForeground(Color.RED);
		lblGstFilling.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		JLabel lblGstin = new JLabel("GSTIN");
		lblGstin.setBounds(10, 107, 64, 14);
		lblGstin.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblInvoiceType = new JLabel("INVOICE TYPE");
		lblInvoiceType.setBounds(10, 152, 80, 14);
		lblInvoiceType.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblInvoiceNo = new JLabel("INVOICE NO.");
		lblInvoiceNo.setBounds(291, 107, 73, 14);
		lblInvoiceNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPlace = new JLabel("PLACE");
		lblPlace.setBounds(291, 152, 64, 14);
		lblPlace.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_gstin = new JTextField();
		textField_gstin.setBounds(105, 104, 160, 20);
		textField_gstin.setColumns(10);
		
		textField_invoiceNo = new JTextField();
		textField_invoiceNo.setBounds(381, 106, 160, 20);
		textField_invoiceNo.setColumns(10);
		
		textField_place = new JTextField();
		textField_place.setBounds(381, 151, 160, 20);
		textField_place.setColumns(10);
		
		comboBox_Invoicetype = new JComboBox(select);
		comboBox_Invoicetype.setBounds(105, 149, 160, 20);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setBounds(10, 201, 64, 14);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnSubmit = new JButton("Generate");
		btnSubmit.setBounds(106, 669, 101, 27);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		btnSubmit.addActionListener((e)->{
			calculate();
			flag=true;
		});
		
		
		comboBox_1 = new JComboBox(Day);
		comboBox_1.setBounds(105, 198, 49, 20);
		comboBox_2 = new JComboBox(Month);
		comboBox_2.setBounds(160, 198, 63, 20);
		comboBox_3 = new JComboBox(Year);
		comboBox_3.setBounds(229, 198, 68, 20);
		
		lblTotalIn = new JLabel("");
		lblTotalIn.setBounds(411, 454, 120, 24);
		lblTotalIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalIn.setBackground(SystemColor.info);
		lblTotalIn.setOpaque(true);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(44, 454, 70, 24);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBackground(SystemColor.activeCaption);
		
		JLabel lblGst = new JLabel("GST@");
		lblGst.setBounds(44, 496, 70, 24);
		lblGst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGst.setBackground(SystemColor.activeCaption);
		
		JLabel lblcgst = new JLabel("-CGST@");
		lblcgst.setBounds(87, 526, 70, 24);
		lblcgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcgst.setBackground(SystemColor.activeCaption);
		
		JLabel lblsgst = new JLabel("-SGST@");
		lblsgst.setBounds(87, 556, 70, 24);
		lblsgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblsgst.setBackground(SystemColor.activeCaption);
		
		JLabel lblTotalPayable = new JLabel("Total Payable");
		lblTotalPayable.setBounds(44, 622, 107, 24);
		lblTotalPayable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPayable.setBackground(SystemColor.activeCaption);
		
		lblTotal_payable = new JLabel("");
		lblTotal_payable.setBounds(411, 622, 120, 24);
		lblTotal_payable.setOpaque(true);
		lblTotal_payable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal_payable.setBackground(SystemColor.info);
		
		lblCgst = new JLabel("");
		lblCgst.setBounds(411, 526, 120, 24);
		lblCgst.setOpaque(true);
		lblCgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCgst.setBackground(SystemColor.info);
		
		lblSgst = new JLabel("");
		lblSgst.setBounds(411, 556, 120, 24);
		lblSgst.setOpaque(true);
		lblSgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSgst.setBackground(SystemColor.info);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(229, 669, 93, 27);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnSave.addActionListener((e)->{
			if(flag==true)
			addinvoice();
			else
				JOptionPane.showMessageDialog(frame, "Generate Invoice first");
		});
		
		lblCgstRate = new JLabel("");
		lblCgstRate.setBounds(163, 526, 70, 24);
		lblCgstRate.setOpaque(true);
		lblCgstRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCgstRate.setBackground(SystemColor.info);
		
		lblSgstRate = new JLabel("");
		lblSgstRate.setBounds(163, 556, 70, 24);
		lblSgstRate.setOpaque(true);
		lblSgstRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSgstRate.setBackground(SystemColor.info);
	
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblGstFilling);
		frame.getContentPane().add(lblGstin);
		frame.getContentPane().add(textField_gstin);
		frame.getContentPane().add(lblInvoiceNo);
		frame.getContentPane().add(textField_invoiceNo);
		frame.getContentPane().add(lblInvoiceType);
		frame.getContentPane().add(lblDate);
		frame.getContentPane().add(comboBox_1);
		frame.getContentPane().add(comboBox_2);
		frame.getContentPane().add(comboBox_3);
		frame.getContentPane().add(comboBox_Invoicetype);
		frame.getContentPane().add(lblPlace);
		frame.getContentPane().add(textField_place);
		frame.getContentPane().add(lblGst);
		frame.getContentPane().add(lblTotal);
		frame.getContentPane().add(lblTotalPayable);
		frame.getContentPane().add(lblCgstRate);
		frame.getContentPane().add(lblSgstRate);
		frame.getContentPane().add(lblTotal_payable);
		frame.getContentPane().add(lblTotalIn);
		frame.getContentPane().add(lblCgst);
		frame.getContentPane().add(lblSgst);
		frame.getContentPane().add(lblsgst);
		frame.getContentPane().add(lblcgst);
		frame.getContentPane().add(btnSubmit);
		frame.getContentPane().add(btnSave);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemName.setBounds(23, 261, 86, 14);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setBounds(262, 261, 86, 14);
		frame.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(432, 261, 86, 14);
		frame.getContentPane().add(lblPrice);
		
		txtName = new JTextField();
		txtName.setBounds(10, 286, 177, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtName_1 = new JTextField();
		txtName_1.setColumns(10);
		txtName_1.setBounds(10, 317, 177, 20);
		frame.getContentPane().add(txtName_1);
		
		txtName_2 = new JTextField();
		txtName_2.setColumns(10);
		txtName_2.setBounds(10, 348, 177, 20);
		frame.getContentPane().add(txtName_2);
		
		txtName_3 = new JTextField();
		txtName_3.setColumns(10);
		txtName_3.setBounds(10, 379, 177, 20);
		frame.getContentPane().add(txtName_3);
		
		txtName_4 = new JTextField();
		txtName_4.setColumns(10);
		txtName_4.setBounds(10, 410, 177, 20);
		frame.getContentPane().add(txtName_4);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(249, 286, 73, 20);
		frame.getContentPane().add(textQuantity);
		textQuantity.setText("0");
		
		
		textQuantity_1 = new JTextField();
		textQuantity_1.setColumns(10);
		textQuantity_1.setBounds(249, 317, 73, 20);
		frame.getContentPane().add(textQuantity_1);
		textQuantity_1.setText("0");
		
		textQuantity_2 = new JTextField();
		textQuantity_2.setColumns(10);
		textQuantity_2.setBounds(249, 348, 73, 20);
		frame.getContentPane().add(textQuantity_2);
		textQuantity_2.setText("0");
		
		textQuantity_3 = new JTextField();
		textQuantity_3.setColumns(10);
		textQuantity_3.setBounds(249, 379, 73, 20);
		frame.getContentPane().add(textQuantity_3);
		textQuantity_3.setText("0");
		
		textQuantity_4 = new JTextField();
		textQuantity_4.setColumns(10);
		textQuantity_4.setBounds(249, 410, 73, 20);
		frame.getContentPane().add(textQuantity_4);
		textQuantity_4.setText("0");
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(411, 286, 120, 20);
		frame.getContentPane().add(textPrice);
		textPrice.setText("0");
		
		textPrice_1 = new JTextField();
		textPrice_1.setColumns(10);
		textPrice_1.setBounds(411, 317, 120, 20);
		frame.getContentPane().add(textPrice_1);
		textPrice_1.setText("0");
		
		textPrice_2 = new JTextField();
		textPrice_2.setColumns(10);
		textPrice_2.setBounds(411, 348, 120, 20);
		frame.getContentPane().add(textPrice_2);
		textPrice_2.setText("0");
		
		textPrice_3 = new JTextField();
		textPrice_3.setColumns(10);
		textPrice_3.setBounds(411, 379, 120, 20);
		frame.getContentPane().add(textPrice_3);
		textPrice_3.setText("0");
		
		textPrice_4 = new JTextField();
		textPrice_4.setColumns(10);
		textPrice_4.setBounds(411, 410, 120, 20);
		frame.getContentPane().add(textPrice_4);
		textPrice_4.setText("0");
		
		
		JLabel lbligst = new JLabel("-IGST@");
		lbligst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbligst.setBackground(SystemColor.activeCaption);
		lbligst.setBounds(87, 587, 70, 24);
		frame.getContentPane().add(lbligst);
		
		lblIgstRate = new JLabel("");
		lblIgstRate.setOpaque(true);
		lblIgstRate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIgstRate.setBackground(SystemColor.info);
		lblIgstRate.setBounds(163, 587, 70, 24);
		frame.getContentPane().add(lblIgstRate);
		
		lblIgst = new JLabel("");
		lblIgst.setOpaque(true);
		lblIgst.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIgst.setBackground(SystemColor.info);
		lblIgst.setBounds(411, 587, 120, 24);
		frame.getContentPane().add(lblIgst);
		
		comboBox = new JComboBox(rate);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setBounds(105, 500, 64, 20);
		frame.getContentPane().add(comboBox);
		
		lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblType.setBackground(SystemColor.activeCaption);
		lblType.setBounds(179, 496, 70, 24);
		frame.getContentPane().add(lblType);
		
		comboBox_4 = new JComboBox(type);
		comboBox_4.setBounds(229, 500, 126, 20);
		frame.getContentPane().add(comboBox_4);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(341, 669, 93, 27);
		frame.getContentPane().add(btnReset);
		
		btnReset.addActionListener((e)->{
			textField_gstin.setText("");
			textField_invoiceNo.setText("");
			textField_place.setText("");
			comboBox.setSelectedIndex(0);
			comboBox_1.setSelectedIndex(0);
			comboBox_2.setSelectedIndex(0);
			comboBox_3.setSelectedIndex(0);
			comboBox_4.setSelectedIndex(0);
			comboBox_Invoicetype.setSelectedIndex(0);
			lblCgst.setText("");
			lblIgst.setText("");
			lblSgst.setText("");
			lblCgstRate.setText("");
			lblSgstRate.setText("");
			lblIgstRate.setText("");
			lblTotal_payable.setText("");
			lblTotalIn.setText("");
			txtName.setText("");
			txtName_1.setText("");
			txtName_2.setText("");
			txtName_3.setText("");
			txtName_4.setText("");
			textPrice.setText("0");
			textPrice_1.setText("0");
			textPrice_2.setText("0");
			textPrice_3.setText("0");
			textPrice_4.setText("0");
			textQuantity.setText("0");
			textQuantity_1.setText("0");
			textQuantity_2.setText("0");
			textQuantity_3.setText("0");
			textQuantity_4.setText("0");
		
		});
	}
	private void addinvoice() {
		// TODO Auto-generated method stub
		createNewUserObject();
	}

	private void calculate() {
		try{
			int p=Integer.parseInt(textPrice.getText());
			int p1=Integer.parseInt(textPrice_1.getText());
			int p2=Integer.parseInt(textPrice_2.getText());
			int p3=Integer.parseInt(textPrice_3.getText());
			int p4=Integer.parseInt(textPrice_4.getText());
			
			int q=Integer.parseInt(textQuantity.getText());
			int q1=Integer.parseInt(textQuantity_1.getText());
			int q2=Integer.parseInt(textQuantity_2.getText());
			int q3=Integer.parseInt(textQuantity_3.getText());
			int q4=Integer.parseInt(textQuantity_4.getText());
			
			total=p*q+p1*q1+p2*q2+p2*q3+p4*q4;
			gst=Integer.parseInt((String)comboBox.getSelectedItem());
			lblTotalIn.setText(Float.toString(total));
				if((String)comboBox_4.getSelectedItem()=="Intra_State"){
					cgst=sgst=gst/2;
					igst=0;
					lblCgstRate.setText(Float.toString(cgst)+"%");
					lblSgstRate.setText(Float.toString(sgst)+"%");
					lblIgstRate.setText(Float.toString(igst)+"%");
					lblCgst.setText(Float.toString(total*cgst/100));
					lblSgst.setText(Float.toString(total*sgst/100));
					lblIgst.setText(Float.toString(total*igst/100));
					totalpayable=total+(total*cgst/100)+(total*sgst/100)+(total*igst/100);
					lblTotal_payable.setText(Float.toString(totalpayable));
				}
				else if((String)comboBox_4.getSelectedItem()=="Inter_State")
				{
					cgst=sgst=0;
					igst=gst;
					lblCgstRate.setText(Float.toString(cgst)+"%");
					lblSgstRate.setText(Float.toString(sgst)+"%");
					lblIgstRate.setText(Float.toString(igst)+"%");
					lblCgst.setText(Float.toString(total*cgst/100));
					lblSgst.setText(Float.toString(total*sgst/100));
					lblIgst.setText(Float.toString(total*igst/100));
					totalpayable=total+(total*cgst/100)+(total*sgst/100)+(total*igst/100);
					lblTotal_payable.setText(Float.toString(totalpayable));
				}
		}catch(Exception e){
			JOptionPane.showMessageDialog(frame, "Error while generating invoice,Please check details");
		}
			
		
	}

	private void createNewUserObject()
	{
		
		String Cgstin,CinvoiceNo,CinvoiceType,Cplace,Cdate;
		PurchaseType=(String)comboBox_4.getSelectedItem();
		
		Cgstin = textField_gstin.getText().trim();
       
		String d=(String)comboBox_1.getSelectedItem();
		String m=(String)comboBox_2.getSelectedItem();
		String y=(String)comboBox_3.getSelectedItem();
		Cdate=d +"/"+ m + "/" + y;
		CinvoiceNo=textField_invoiceNo.getText().trim();
		CinvoiceType = (String)comboBox_Invoicetype.getSelectedItem();
		Cplace = textField_place.getText().trim();
		 try {
				 test=InvoiceDatabase.addInvoice(Cgstin,CinvoiceNo,CinvoiceType,Cplace,Cdate,gst,PurchaseType,cgst,sgst,igst,total,totalpayable);
				 if(test==true)
					 JOptionPane.showMessageDialog(frame, "Invoice Saved!");
				 else
					 JOptionPane.showMessageDialog(frame, "Error while saving the Invoice");
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			JOptionPane.showMessageDialog(frame, "Error!,check details");
		}
		 
		 
		 //Validation obj=new Validation();
		// isdatavalidate = obj.dataValidation(Cname,Cmail,Cphone,Cadhar,Cpan);
		 
	}
}
