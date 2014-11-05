package skyfly33.practice03.toby;

import java.sql.SQLException;

public class TestDao {
	// interface �и������ ���� connection���ɻ�� query���� ���ɻ� �и�.
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		
		ConnectionMaker simpleConnectionMaker = new SimpleConnectionMaker();
		UsersDao dao = new UsersDao(simpleConnectionMaker);

		Users user = new Users();
		user.setId("iruen17");
		user.setName("�̵���");
		user.setPassword("fighting!");

		dao.add(user);

		System.out.println(user.getId() + ", ��� ����!!");

		Users user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());

		System.out.println(user2.getId() + ", ��ȸ ����!!");
	}
}
