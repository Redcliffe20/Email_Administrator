package email_app;

import java.util.*;

public class email {
	private String fname;
	private String lname;
	private String password;
	private String department;
	private int mailbox_capacity=500;
	private String email_id;
	private int def_pass_length=10;
	private String alt_email;
	private String company_suffix="amazon.com";
	
	// Constructor to receive first and last name
	public email(String fname,String lname)
	{
		this.fname=fname;
		this.lname=lname;
//		System.out.println(this.fname+" "+this.lname);
		
		// Calling method for asking department
		this.department=setDepartment();
//		System.out.print(this.department);
		
		// Calling a method that returns random password
		this.password=random_pass(def_pass_length);
		System.out.println("Your Password is "+this.password);;
		
		// Combine elements to generate email
		email_id=fname.toLowerCase()+"."+lname.toLowerCase()+"@"+department+"."+company_suffix;
//		System.out.println("Your email_id is "+email_id);
	}
	
	// ask for department
	private String setDepartment()
	{
		System.out.print("New Worker:"+fname+"\nEnter the Department Codes \n1 for Sales\n2 for Accounting\n3 for Development\n0 for None\nEnter Department code:\n");
		Scanner sc=new Scanner(System.in);
		int d_choice=sc.nextInt();
		if(d_choice==1) {
			return "Sales";
		}
		else if(d_choice==2) {
			return "Accounting";
		}
		else if(d_choice==3) {
			return "Development";
		}
		else {return "";}
	}
	
	// generate password
	private String random_pass(int length)
	{
		String pass_set="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
		char[] password=new char[length];
		for(int i=0;i<length;i++)
		{
			int rnd=(int)(Math.random()*pass_set.length());
			password[i]=pass_set.charAt(rnd);
		}
		return new String(password);
	}
	
	// Set mailbox capacity
	public void set_mailboxCapacity(int c)
	{
		this.mailbox_capacity=c;
	}
	
	// Set alternate email
	public void set_altEmail(String alt)
	{
		this.alt_email=alt;
	}
	
	// Change the password
	public void change_password(String pwd)
	{
		this.password=pwd;
	}
	
	public int get_mailboxCapacity()
	{
		return mailbox_capacity;
	}
	public String get_altEmail()
	{
		return alt_email;
	}
	public String get_password()
	{
		return password;
	}
	
	public String showinfo()
	{
		return "Display Name: "+fname+" "+lname+" "+"\nCompany Email: "+email_id+" "+"\nMailbox Capacity"+" "+mailbox_capacity+"mb";
	}
}
