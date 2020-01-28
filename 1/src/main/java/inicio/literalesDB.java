package inicio;

import java.sql.*;

public class literalesDB {
	String url = new String("'jdbc:mysql://localhost:3306/tablasacesso', 'root', '12345678'");
	String username = "root";
	String password = "123456789";
	public static void connectar(String command,String username, String password) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tablasacesso",username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(command);
		rs.next();
		 String foundType = rs.getString(1);
		 System.out.println(foundType);
	}
	
	public static void updatear(String command,String username, String password) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tablasacesso",username, password);
		Statement st = con.createStatement();
		st.executeUpdate(command);
		
	}
}
