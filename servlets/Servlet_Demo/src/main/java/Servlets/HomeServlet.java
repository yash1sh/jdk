package Servlets;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HomeServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str="<script> funtion alert() { alert('Inserted Your data ')} windows.onload= alert()</script>";
		
		String usn =req.getParameter("usn");
		String name=req.getParameter("Name");
		String pass=req.getParameter("password");
		String gender=req.getParameter("gender");
		try {
			int count=4;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
			PreparedStatement ps=conn.prepareStatement("insert into form values(?,?,?,?,?);");
			ps.setInt(1, count);
			ps.setString(2, usn);
			ps.setString(3, name);
			ps.setString(4, pass);
			ps.setString(5, gender);
			ps.executeUpdate();
			req.getRequestDispatcher("/index.html").forward(req, res);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
