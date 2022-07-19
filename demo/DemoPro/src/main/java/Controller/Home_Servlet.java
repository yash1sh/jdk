package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.PersonDao;
import dto.person;
@WebServlet("/Person")
public class Home_Servlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		person p=new person();
		p.setId(Integer.parseInt(req.getParameter("id")));
		p.setName(req.getParameter("name"));
		p.setAge(Integer.parseInt(req.getParameter("age")));
		try {
			PersonDao.InsertPerson(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
