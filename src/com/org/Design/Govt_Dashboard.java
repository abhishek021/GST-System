package com.org.Design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

class government {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public government() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Dash Board");
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 230, 225));
		frame.setBounds(100, 100, 775, 555);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GOVT. DASHBOARD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(108, 11, 583, 75);
		frame.getContentPane().add(lblNewLabel);

		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setBackground(new Color(176, 200, 230));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnSearch.setBounds(237, 148, 336, 69);
		frame.getContentPane().add(btnSearch);
		btnSearch.addActionListener((e)->
			{
				new InvoiceSearch();
			}
		);
		
		JButton btnSend = new JButton("SEND NOTICE");
		btnSend.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSend.setBackground(SystemColor.activeCaption);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnSend.setBounds(237, 261, 336, 75);
		frame.getContentPane().add(btnSend);
		btnSend.addActionListener((e)->{
			new SendMail();
		});
		
		
		JButton btnAddAdmin = new JButton("ADD USER");
		btnAddAdmin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAddAdmin.setBackground(new Color(176, 224, 230));
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnAddAdmin.setBounds(237, 384, 336, 75);
		frame.getContentPane().add(btnAddAdmin);
		btnAddAdmin.addActionListener((e)->{
			new GovtRegistration();
		});
	}

}
public class Govt_Dashboard{
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					government window = new government();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

