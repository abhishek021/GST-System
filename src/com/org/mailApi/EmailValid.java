package com.org.mailApi;

public class EmailValid {

	public static void Email(String msg,String mailid) 
	{
		String[] to={mailid};
	try{	
		if(EmailSender.sendMail("sender's email id", "password",msg,to))
		{
			System.out.println("email sent");
		}
		else
			System.out.println("error occured");
	 }catch (Exception e) {
		System.out.println(e);
	}
	}
}
