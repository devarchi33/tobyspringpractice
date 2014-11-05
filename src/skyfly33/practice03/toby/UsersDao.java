package skyfly33.practice03.toby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {
	private ConnectionMaker simpleConnectionMaker;

	public UsersDao(ConnectionMaker simpleConnectionMaker) {
		// ì§?ê³? ê°???¨í?? ì½??????´ì??ë§?, UserDaoê°? ??´ë?? ConnectionMakerë¥? ??¬ì?©í??ì§?ë¥? ê²°ì???????? ???ë¦½ì????? ê´???¬ì?¬ë?? ë³? ???
		// ??????.
		// simpleConnectionMaker = new SimpleConnectionMaker();
		// ??¸ë???????? ??¤ë???????¸ë?? ?????¬ë???????¼ë????? UserDaoì½?????????? simpleConnectionMakerì½??????? ?????? ???ì¡´ì?±ì?? ???ê±°ë?????.
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
