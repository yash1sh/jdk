package dao;
import java.sql.*;

import dto.person;
public class PersonDao {

	
	
	
	
	public Connection getConnection(String schemaName)
	{
		Connection conn = null;
			try 
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+schemaName+"","root", "root");
			}
			catch(ClassNotFoundException e)
			{
				System.out.println("Class Not Found Exeption");
			}
			catch(SQLException e)
			{
				System.out.println("SQL Exception");
			}
			return conn;
			
			
		
	}
	
	public static void InsertPerson(person p) throws SQLException
	{
		PersonDao pd=new PersonDao();
		Connection conn=pd.getConnection("students");
		PreparedStatement st=conn.prepareStatement("insert into person values(?,?,?) ");
		st.setInt(1, p.getId());
		st.setString(2,p.getName());
		st.setInt(3, p.getAge());
		st.execute();
	}
	
	public void UpdatePerson(person p)throws SQLException
	{
		
		Connection conn=getConnection("students");
		PreparedStatement st=conn.prepareStatement("update person set name=?,age=? where id=?");
		st.setString(1, p.getName());
		st.setInt(2, p.getAge());
		st.setInt(3, p.getId());
		st.execute();
		System.out.println("Updated");
	}
	public void DeletePerson(person p) throws SQLException
	{

		Connection conn=getConnection("students");
		PreparedStatement st=conn.prepareStatement("delete from person where id=?");
		st.setInt(1, p.getId());
		st.execute();
	}
}
