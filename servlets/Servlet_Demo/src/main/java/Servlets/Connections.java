package Servlets;
import java.sql.*;
public class Connections {
	
	static Connection con;
	
	public static Connection getcon(String Schema_Name)
	{
		try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Class Not Found Exeption");
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception");
		}
		return con;
		
		
	}
	
	
}
