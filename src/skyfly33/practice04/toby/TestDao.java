package skyfly33.practice04.toby;

import java.sql.SQLException;

public class TestDao {
	// Factory���� �и������ ���� connection���ɻ�� query���� ���ɻ� �и�.
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		UsersDao dao = new DaoFactory().userDao();

		Users user = new Users();
		user.setId("iruen7");
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
