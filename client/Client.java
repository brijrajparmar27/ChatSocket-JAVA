import java.net.*;  
import java.util.*;
import java.io.*;  

class Sender extends Thread
{
	public static Socket s;
	public static String uname;
	public Sender(Socket s,String uname)
	{
		this.s=s;
		this.uname = uname;
	}
	public void run()
	{
		String msg = "";
		Scanner sc = new Scanner(System.in);
		try{
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
			do
			{   
				msg = sc.nextLine();
				dout.writeUTF(uname+": "+msg);  
				dout.flush();
			}while(!msg.equals("STOPSOCKET")); 
			dout.close();  
			s.close();  
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Reciever extends Thread
{
	public static Socket s;
	public Reciever(Socket s)
	{
		this.s = s;
	}
	public void run()
	{
		String incoming = "";
		try{
			DataInputStream din=new DataInputStream(s.getInputStream());
			do
			{ 
				incoming=din.readUTF();  
				System.out.println(incoming);  
			}while(!incoming.equals("STOPSOCKET")); 
			s.close();   	
		} catch(Exception e){
			System.out.println(e);
		}
		
	}
}

class Client
{  
	public static void main(String args[])
	{  
		System.out.println("                                       ");
		System.out.println("   ________  _____  ______             ");
		System.out.println("  / ____/ / / /   |/_  __/             ");
		System.out.println(" / /   / /_/ / /| | / /                ");
		System.out.println("/ /___/ __  / ___ |/ /                 ");
		System.out.println("\\____/_/ /_/_/ _|_/_/__ __ ____________");
		System.out.println("  / ___// __ \\/ ____/ //_// ____/_  __/");
		System.out.println("  \\__ \\/ / / / /   / ,<  / __/   / /   ");
		System.out.println(" ___/ / /_/ / /___/ /| |/ /___  / /    ");
		System.out.println("/____/\\____/\\____/_/ |_/_____/ /_/     ");
		System.out.println("Made By Brijrajsinh Parmar\n");

		Scanner sc = new Scanner(System.in);
		String uname;
		System.out.print("Enter your name: ");
		uname = sc.nextLine();
		System.out.println("Enter the Public IP of Reciever: ");
		System.out.print("> ");
		String IP = sc.nextLine();
		System.out.println("-----------------\n");
		System.out.println("\tConversation Initiated...\n");
		try{
		Socket s=new Socket(IP,3333);
		 
		Sender s1 = new Sender(s,uname);
		Reciever r1 = new Reciever(s);	
		
			s1.start();
			r1.start();	
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}  