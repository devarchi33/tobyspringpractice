package skyfly33.practice1.toby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UsersDao {

	public void add(Users user) throws SQLException, ClassNotFoundException {
		Connection conn = getConncetion();
		PreparedStatement pstmt = conn
				.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();
	}

	public Users get(String id) throws SQLException, ClassNotFoundException {
		Connection conn = getConncetion();
		PreparedStatement pstmt = conn
				.prepareStatement("select * from users where id = ?");
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		rs.next();

		Users user = new Users();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		pstmt.close();
		conn.close();

		return user;
	}

	public abstract Connection getConncetion() throws ClassNotFoundException,
			SQLException;
}
