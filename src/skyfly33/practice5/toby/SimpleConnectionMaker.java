package skyfly33.practice5.toby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker implements ConnectionMaker {

	@Override
	public Connection makeNewConnection() throws SQLException,
			ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
		// "jdbc:oracle:thin:@192.168.0.13:1521:orcl", "spring", "spring");
		   "jdbc:oracle:thin:@localhost:1521:orcl", "spring", "spring");

		return conn;
	}
}
