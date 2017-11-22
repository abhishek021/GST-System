package com.org.Design;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.org.Database.UserDatabase;
import com.org.Database.GstReturnDatabase;
import com.org.mailApi.EmailValid;


class AccountOpening extends JFrame
{
	boolean isdatavalidate;
	private JPanel AccountOpening;
	private JLabel lblName,lblSex,lblDOB,lblPassword,lblRpassword,lblPhone,lblAddress,lblBtype,lblAadhaar,
					lblPANId,lblEmailId;
	private JTextField txtName,txtPassword,txtRpassword,txtPhone,txtVoterId,txtAadhaar,txtPANId,txtEmailId;
	private JButton btnOpen;
	private JTextArea txtAddress;
	private JRadioButton rdbtnMale,rdbtnFemale;
	private final ButtonGroup sex = new ButtonGroup();
	private JComboBox cbDay,cbMonth,cbYear,cBtype;
	private String Csex;
	private String Cmail,Cname,Cpassword;
	private String Day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
			"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String Month[] = {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
	private String Year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
			"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011"};
	private String Businesstype[]={"Company","Partnership"};
	String value="";
	boolean test;
	
	public AccountOpening()
	{
		formOpen();
	}
	

	private void formOpen() 
	{
		
		
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AccountOpening.class.getResource("/resources/Forms.png")));
		setTitle("ACCOUNT OPENING FORM");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
               // if( result==JOptionPane.OK_OPTION){
                    // NOW we change it to dispose on close..
                    setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    setVisible(false);
                    dispose();
                   // new AccountantFrame();
                }
        }
        );
		setBounds(0, 0, 1378, 780);
		AccountOpening = new JPanel();
		AccountOpening.setBackground(new Color(76, 224, 230));
		AccountOpening.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AccountOpening);
		AccountOpening.setLayout(null);
		
		
		JLabel lblForm = new JLabel("GST Account Opening Form");
		lblForm.setForeground(new Color(119, 12, 47));
		lblForm.setFont(new Font("Trajan Pro 3", Font.BOLD, 48));
		lblForm.setBounds(350, 21, 854, 52);
		AccountOpening.add(lblForm);
		
		
		lblName = new JLabel("NAME :");
		lblName.setToolTipText("");
		lblName.setForeground(new Color(0,0,0));
		lblName.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblName.setBounds(220, 100, 82, 51);
		AccountOpening.add(lblName);
		
		
		
		lblDOB = new JLabel("DATE OF BIRTH :");
		lblDOB.setToolTipText("Minimum Age to open an Account is 5 Year");
		lblDOB.setForeground(new Color(0,0,0));
		lblDOB.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblDOB.setBounds(120, 150, 181, 51);
		AccountOpening.add(lblDOB);
		
		
		lblSex = new JLabel("SEX :");
		lblSex.setToolTipText("Manadatory");
		lblSex.setForeground(new Color(0,0,0));
		lblSex.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblSex.setBounds(240, 200, 54, 51);
		AccountOpening.add(lblSex);
		
	
		lblAddress = new JLabel("ADDRESS :");
		lblAddress.setForeground(new Color(0,0,0));
		lblAddress.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblAddress.setBounds(173, 350, 129, 51);
		AccountOpening.add(lblAddress);
		
		
		lblPhone = new JLabel("PHONE :");
		lblPhone.setForeground(new Color(0,0,0));
		lblPhone.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblPhone.setBounds(208, 450, 94, 51);
		AccountOpening.add(lblPhone);
		
		
		lblBtype = new JLabel("Business Type :");
		lblBtype.setForeground(new Color(0,0,0));
		lblBtype.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblBtype.setBounds(120, 500, 200, 51);
		AccountOpening.add(lblBtype);
		
		
		lblAadhaar = new JLabel("AADHAAR NO. :");
		lblAadhaar.setForeground(new Color(0,0,0));
		lblAadhaar.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblAadhaar.setBounds(127, 550, 174, 51);
		AccountOpening.add(lblAadhaar);
		
		
		lblPANId = new JLabel("PAN :");
		lblPANId.setForeground(new Color(0,0,0));
		lblPANId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblPANId.setBounds(236, 600, 66, 51);
		AccountOpening.add(lblPANId);
		
		
		lblEmailId = new JLabel("EMAIL :");
		lblEmailId.setForeground(new Color(0,0,0));
		lblEmailId.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblEmailId.setBounds(212, 650, 90, 51);
		AccountOpening.add(lblEmailId);
		
		lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(new Color(0,0,0));
		lblPassword.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblPassword.setBounds(150, 250, 197, 51);
		AccountOpening.add(lblPassword);
		
		lblRpassword = new JLabel("RE-TYPE PASSWORD :");
		lblRpassword.setForeground(new Color(0,0,0));
		lblRpassword.setFont(new Font("Tekton Pro Cond", Font.BOLD, 32));
		lblRpassword.setBounds(50, 303, 250, 51);
		AccountOpening.add(lblRpassword);
		
		
		txtName = new JTextField();
		txtName.setToolTipText("Mandatory");
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(330, 105, 500, 40);
		AccountOpening.add(txtName);
		txtName.setColumns(10);
		
		
		
		
		cbDay = new JComboBox(Day);
		cbDay.setToolTipText("Manadatory");
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbDay.setBackground(new Color(255, 255, 255));
		cbDay.setBounds(330, 160, 100, 30);
		AccountOpening.add(cbDay);
		
		cbMonth = new JComboBox(Month);
		cbMonth.setToolTipText("Manadatory");
		cbMonth.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbMonth.setBackground(new Color(255, 255, 255));
		cbMonth.setBounds(450, 160, 120, 30);
		AccountOpening.add(cbMonth);
		
		cbYear = new JComboBox(Year);
		cbYear.setToolTipText("Manadatory");
		cbYear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cbYear.setBackground(new Color(255, 255, 255));
		cbYear.setBounds(600, 160, 120, 30);
		AccountOpening.add(cbYear);
		
		
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(76, 224, 230));
		rdbtnMale.setFont(new Font("Times New Roman", Font.BOLD, 22));
		sex.add(rdbtnMale);
		rdbtnMale.setBounds(330, 210, 109, 23);
		AccountOpening.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(76, 224, 230));
		rdbtnFemale.setFont(new Font("Times New Roman", Font.BOLD, 22));
		sex.add(rdbtnFemale);
		rdbtnFemale.setBounds(450, 210, 109, 23);
		AccountOpening.add(rdbtnFemale);
		
		
		txtPassword= new JPasswordField();
		txtPassword.setToolTipText("Mandatory");
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setBounds(330, 253, 500, 40);
		AccountOpening.add(txtPassword);
		//txtPassword.setColumns(10);
		
		
		txtRpassword = new JPasswordField();
		txtRpassword.setToolTipText("Manadatory");
		txtRpassword.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtRpassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRpassword.setBounds(330, 303, 500, 40);
		AccountOpening.add(txtRpassword);
		//txtRpassword.setColumns(10);
		
		
		txtAddress = new JTextArea();
		txtAddress.setToolTipText("Manadatory");
		txtAddress.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddress.setBounds(330, 353, 500, 70);
		AccountOpening.add(txtAddress);
		
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Manadatory");
		txtPhone.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPhone.setBounds(330, 453, 500, 40);
		AccountOpening.add(txtPhone);
		txtPhone.setColumns(10);
		
		
		cBtype = new JComboBox(Businesstype);
		cBtype.setToolTipText("Not Manadatory");
		cBtype.setFont(new Font("Times New Roman", Font.BOLD, 28));
		cBtype.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cBtype.setBounds(330, 503, 500, 40);
		AccountOpening.add(cBtype);
		
		
		txtAadhaar = new JTextField();
		txtAadhaar.setToolTipText("Not Manadatory");
		txtAadhaar.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtAadhaar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAadhaar.setBounds(330, 553, 500, 40);
		AccountOpening.add(txtAadhaar);
		txtAadhaar.setColumns(10);
		
		
		txtPANId = new JTextField();
		txtPANId.setToolTipText("Manadatory");
		txtPANId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtPANId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPANId.setBounds(330, 603, 500, 40);
		AccountOpening.add(txtPANId);
		txtPANId.setColumns(10);
		
		
		txtEmailId = new JTextField();
		txtEmailId.setToolTipText("Not Manadatory");
		txtEmailId.setFont(new Font("Times New Roman", Font.BOLD, 28));
		txtEmailId.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmailId.setBounds(330, 653, 500, 40);
		AccountOpening.add(txtEmailId);
		txtEmailId.setColumns(10);
		
		btnOpen = new JButton("CREATE");
		btnOpen.setToolTipText("Register");
		btnOpen.setBorderPainted(false);
		btnOpen.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnOpen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnOpen.setForeground(new Color(155, 140, 0));
		btnOpen.setBackground(new Color(246, 224, 130));
		btnOpen.setBounds(1000, 403, 150, 50);
		AccountOpening.add(btnOpen);
		btnOpen.addActionListener((e)->
		{
			AddInformation();
			
			
		});
		this.setVisible(true);
	}
	public void createNewUserObject()
	{
		
		String Cname,Cdob,Cadd,Cphone,Cbusinesstype,Cadhar,Cpan;
		
		Cname = txtName.getText().trim();
       
		String d=(String)cbDay.getSelectedItem();
		String m=(String)cbMonth.getSelectedItem();
		String y=(String)cbYear.getSelectedItem();
		Cdob=d +"/"+ m + "/" + y;
		Cbusinesstype = (String)cBtype.getSelectedItem();
		
		Csex="";
		if(rdbtnMale.isSelected())
		{
			Csex="Male";
		}
		else if(rdbtnFemale.isSelected())
		{
			Csex="Female";
		}
		//Csex = "Male";
		Cpassword =new String(txtPassword.getText());
		String CRpassword =new String(txtRpassword.getText());
		Cadd = txtAddress.getText().trim();
		Cphone = txtPhone.getText().trim();
		Cadhar = txtAadhaar.getText().trim();
		Cpan = txtPANId.getText().trim();
		Cmail = txtEmailId.getText().trim();
		
		String rand = "0123456789";
		
		Random r = new Random();
		 for(int i=0;i<10;i++)
			 value = value + rand.charAt(r.nextInt(rand.length()));
		// UserRegistration ureg=new UserRegistration();
		 try {
			 if(Cpassword==CRpassword)
				 test=UserDatabase.addUser(value,Cname,Cphone,Cdob,Cadd,Csex,Cpassword,Cbusinesstype,Cadhar,Cpan,Cmail);
			 else{
				 JOptionPane.showMessageDialog(this,"Password doesn't match.");
				 txtPassword.setText("");
				 txtRpassword.setText("");
			 }
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 //Validation obj=new Validation();
		// isdatavalidate = obj.dataValidation(Cname,Cmail,Cphone,Cadhar,Cpan);
		 
	}
		 
	public void AddInformation()
	{
		createNewUserObject();
			   if(test==true){   
				   int con=JOptionPane.showConfirmDialog(this, "Are You Sure to  apply");
	     		   if(con==JOptionPane.YES_OPTION)
				       {
	     			  String msg="Thankyou for registering.Your Password is :"+Cpassword+"";
	     			   	EmailValid obj=new EmailValid();
						 obj.Email(msg,Cmail);   
					      JOptionPane.showMessageDialog(this, "Account successfully created..Your GISTIN no. is "+value);
					      
					      /*String message = "Thank you for registering ";
				        	 message = message+c.getAccountNo();
				        	 
				        	 EmailValid obj=new EmailValid();
								obj.Email(message,c.getAccountNo());*/
					      
					      
					      resetFrame();
				       
				       }
			   }else
				   JOptionPane.showMessageDialog(this,"Failed to create account");
    }
	
	
	   


	private void resetFrame() {
		this.dispose();
		//new NewAccountOpeningForm();
		
	}
	
}


public class TaxpayerRegistration 
{

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AccountOpening form = new AccountOpening();
					form.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});


	}
}


