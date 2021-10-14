import java.net.*;  
import java.util.*;
import java.io.*;  

class Sender extends Thread
{
	public static Socket s;
	public static ServerSocket ss;
	public static String uname;

	public Sender(Socket s,ServerSocket ss,String uname)
	{
		this.s = s;
		this.ss = ss;
		this.uname = uname;
	}

	public void run()
	{

		String msg = "";
		Scanner sc = new Scanner(System.in);
		try
		{
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());

			do
			{  
				msg = sc.nextLine();
				dout.writeUTF(uname+": "+msg);  
				dout.flush();  
			}while(!msg.equals("STOPSOCKET")); 

			s.close();  
			ss.close();  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Reciever extends Thread
{
	public static Socket s;
	public static ServerSocket ss;

	public Reciever(Socket s,ServerSocket ss)
	{
		this.s = s;
		this.ss = ss;
	}

	public void run()
	{
		String incoming = "";  
		try
		{
			DataInputStream din=new DataInputStream(s.getInputStream());  
			do
			{  
				incoming=din.readUTF();  
				System.out.println(incoming);  
			}while(!incoming.equals("STOPSOCKET")); 

			din.close();  
			s.close();  
			ss.close();  
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class Server
{  
	public static void main(String args[])throws Exception
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
		System.out.println("-----------------\n");
		System.out.println("\tConversation Initiated...\n");
		try
		{
			ServerSocket ss=new ServerSocket(3333);  
			Socket s=ss.accept();  

			Sender s1 = new Sender(s,ss,uname);
			Reciever r1 = new Reciever(s,ss);

			s1.start();
			r1.start();

		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}  