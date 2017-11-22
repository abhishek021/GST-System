package com.org.Design;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.org.Database.AdminDatabase;
import com.org.mailApi.EmailValid;

import java.awt.SystemColor;

public class GovtRegistration {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField txtMob;
	private JPasswordField txtPassword;
	private JPasswordField txtRpassword;
	private String Cpassword,CRpassword;
	private JComboBox cDay,cMonth,cYear;
	private JRadioButton rdbtnMale,rdbtnF,rdbtnOthers;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	private final ButtonGroup sex = new ButtonGroup();
	private String Csex;
	private boolean test;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GovtRegistration window = new GovtRegistration();
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
	public GovtRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(30, 30, 780, 724);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GOVT. BODY  REGISTRATION ");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(10, 11, 744, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(142, 95, 83, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMob = new JLabel("Mobile No. :");
		lblMob.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMob.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMob.setBounds(142, 140, 83, 28);
		frame.getContentPane().add(lblMob);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(103, 185, 122, 28);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email Id :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(85, 230, 139, 28);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblSex = new JLabel("Sex :");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSex.setBounds(169, 275, 56, 28);
		frame.getContentPane().add(lblSex);
		
		JLabel lblDob = new JLabel("D.O.B. :");
		lblDob.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDob.setBounds(119, 320, 106, 31);
		frame.getContentPane().add(lblDob);
		
		JLabel lblPassword_1 = new JLabel("Password :");
		lblPassword_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword_1.setBounds(103, 365, 122, 28);
		frame.getContentPane().add(lblPassword_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(25, 411, 200, 31);
		frame.getContentPane().add(lblConfirmPassword);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(290, 95, 282, 29);
		frame.getContentPane().add(txtName);
		
		txtMob = new JTextField();
		txtMob.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtMob.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMob.setColumns(10);
		txtMob.setBounds(290, 140, 282, 29);
		frame.getContentPane().add(txtMob);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtUsername.setColumns(10);
		txtUsername.setBounds(290, 185, 282, 29);
		frame.getContentPane().add(txtUsername);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(290, 230, 282, 27);
		frame.getContentPane().add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPassword.setColumns(10);
		txtPassword.setBounds(290, 365, 282, 28);
		frame.getContentPane().add(txtPassword);
		
		txtRpassword = new JPasswordField();
		txtRpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRpassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtRpassword.setColumns(10);
		txtRpassword.setBounds(290, 410, 282, 28);
		frame.getContentPane().add(txtRpassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(128, 128, 0), new Color(165, 42, 42)));
		btnRegister.setBackground(new Color(154, 205, 50));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnRegister.setBounds(290, 469, 188, 50);
		frame.getContentPane().add(btnRegister);
		
		btnRegister.addActionListener((e)->{
			addAdministrator();
		});
		
		JLabel lblNewLabel_2 = new JLabel("Already Registered?");
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(290, 620, 188, 31);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 128));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(240, 230, 140));
		btnLogin.setOpaque(false);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		btnLogin.setBounds(488, 618, 93, 33);
		frame.getContentPane().add(btnLogin);
		
		btnLogin.addActionListener((e)->{
			new LoginGovt();
		});
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBackground(new Color(240, 230, 140));
		rdbtnMale.setBounds(290, 275, 56, 25);
		sex.add(rdbtnMale);
		frame.getContentPane().add(rdbtnMale);
		
		rdbtnF = new JRadioButton("Female");
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnF.setBackground(new Color(240, 230, 140));
		rdbtnF.setBounds(390, 275, 77, 25);
		sex.add(rdbtnF);
		frame.getContentPane().add(rdbtnF);
		
		rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnOthers.setBackground(new Color(240, 230, 140));
		rdbtnOthers.setBounds(490, 275, 72, 25);
		sex.add(rdbtnOthers);
		frame.getContentPane().add(rdbtnOthers);
		
		
		cDay = new JComboBox(Day);
		cDay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cDay.setFont(new Font("Tahoma", Font.BOLD, 14));
		cDay.setBackground(new Color(255, 255, 255));
		cDay.setBounds(290, 320, 56, 30);
		frame.getContentPane().add(cDay);
		
		cMonth = new JComboBox(Month);
		cMonth.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cMonth.setFont(new Font("Tahoma", Font.BOLD, 14));
		cMonth.setBounds(374, 320, 93, 30);
		frame.getContentPane().add(cMonth);
		
		cYear = new JComboBox(Year);
		cYear.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cYear.setFont(new Font("Tahoma", Font.BOLD, 14));
		cYear.setBounds(490, 320, 77, 30);
		frame.getContentPane().add(cYear);
		
	}

	private void addAdministrator() {
		// TODO Auto-generated method stub
		String Cname,Cusername,Cdob,Cphone,Cmail;
		
		Cname = txtName.getText().trim();
       
		String d=(String)cDay.getSelectedItem();
		String m=(String)cMonth.getSelectedItem();
		String y=(String)cYear.getSelectedItem();
		Cdob=d +"/"+ m + "/" + y;
		
		Csex="";
		if(rdbtnMale.isSelected())
		{
			Csex="Male";
		}
		else if(rdbtnF.isSelected())
		{
			Csex="Female";
		}
		else if(rdbtnOthers.isSelected())
			Csex="Other";
		
		Cpassword =new String(txtPassword.getText());
		CRpassword =new String(txtRpassword.getText());
		Cusername = txtUsername.getText().trim();
		Cmail = txtEmail.getText().trim();
		Cphone=txtMob.getText().trim();
		
		 try {
			 if(Cpassword.equals(CRpassword)){
				 test=AdminDatabase.addGovt(Cname,Cmail,Cusername,Cphone,Csex,Cdob,Cpassword);
				 if(test==true){
					 EmailValid obj=new EmailValid();
					 String msg="Thankyou for registering.Your Username is :"+Cusername+"and Password is :"+Cpassword+"";
					 obj.Email(msg,Cmail);
					 JOptionPane.showMessageDialog(frame, "Successfully Registered.Your Username and password has been sent to your registered mail id");
				 }else
					 JOptionPane.showMessageDialog(frame,"Error while registering,please try again later");
			 }else{
				 JOptionPane.showMessageDialog(frame,"Password doesn't match.");
				 txtPassword.setText("");
				 txtRpassword.setText("");
			 }
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
