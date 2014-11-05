package skyfly33.practice02.toby;

import java.sql.SQLException;

public class TestDao {
	// class분리방법을 통한 connection관심사와 query수행 관심사 분리.
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		UsersDao dao = new UsersDao();

		Users user = new Users();
		user.setId("iruen4");
		user.setName("이동훈");
		user.setPassword("fighting!");

		dao.add(user);

		System.out.println(user.getId() + ", 등록 성공!!");

		Users user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + ", 조회 성공!!");
	}
}
