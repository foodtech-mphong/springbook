package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import springbook.user.domain.User;


public class DUserDao extends UserDao {
	


	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection c = DriverManager.getConnection("jdbc:sqlserver://min.test.server:14330;databaseName=min", "tunifos_usr", "tunifos!dbwj");
		
		return c;
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DUserDao dao = new DUserDao();
		
		User user = new User();
		user.setId("d-white");
		user.setName("d-���");
		user.setPassword("d-mar");
		
		dao.add(user);
		
		System.out.println(user.getId() + " ��� ����");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " ��ȸ ����");
		

	}	
	
}
