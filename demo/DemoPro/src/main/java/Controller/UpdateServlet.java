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
@WebServlet("/update")
public class UpdateServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		person p=new person();
		p.setId(id);
		p.setName(name);
		p.setAge(age);
		PersonDao pd=new PersonDao();
		try {
			pd.UpdatePerson(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


