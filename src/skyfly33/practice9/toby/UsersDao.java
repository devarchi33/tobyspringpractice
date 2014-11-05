package skyfly33.practice9.toby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class UsersDao {
	private SimpleDriverDataSource dataSource;

	public void setDataSource(SimpleDriverDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void add(Users user) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn
				.prepareStatement("INSERT INTO USERS VALUES (?,?,?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public Users get(String id) throws SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn
				.prepareStatement("select * from users where id = ?");
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		rs.next();

		Users user = new Users(rs.getString("id"), rs.getString("name"),
				rs.getString("password"));

		rs.close();
		pstmt.close();
		conn.close();

		return user;
	}
}
