import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConn {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName("jdbc.oracle.driver.OracleDriver");
			Connection con = (Connection) DriverManager.getConnection("oracle:jdbc:thin:@localhost:1521:XE","etender","etender");
		return con;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("DBConn.getConnection()==> 1"+DBConn.getConnection());
	}
}
