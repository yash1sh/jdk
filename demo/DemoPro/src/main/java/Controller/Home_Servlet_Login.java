package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.PersonDao;
@WebServlet("/Login")
public class Home_Servlet_Login extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PersonDao pd=new PersonDao();
		Connection conn=pd.getConnection("students");
		PrintWriter pw=res.getWriter();
		
		try {
			Statement st=conn.createStatement();
			if(st.execute("select from person where name='"+req.getParameter("name")+"' and age='"+req.getParameter("age")+"'"))
			{
				
				pw.println("You Have logged in");
			}
			else
			{
				pw.println("No such Name is reGistered");
			}
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
	}

}
