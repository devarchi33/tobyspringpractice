package skyfly33.practice3.toby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
	private ConnectionMaker simpleConnectionMaker;

	public UsersDao(ConnectionMaker simpleConnectionMaker) {
		// 짦고 간단한 코드이지만, UserDao가 어떤 ConnectionMaker를 사용할지를 결정하는 독립적인 관심사로 볼 수
		// 있다.
		// simpleConnectionMaker = new SimpleConnectionMaker();
		// 외부에서 오브젝트를 전달받음으로써 UserDao코드에는 simpleConnectionMaker코드에 대한 의존성이 제거된다.
		this.simpleConnectionMaker = simpleConnectionMaker;
	}

	public void add(Users user) throws SQLException, ClassNotFoundException {
		Connection conn = simpleConnectionMaker.makeNewConnection();
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
		Connection conn = simpleConnectionMaker.makeNewConnection();
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
}
