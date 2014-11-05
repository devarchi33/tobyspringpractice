package skyfly33.practice05.toby;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDao {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				DaoFactory.class);
		UsersDao dao = context.getBean("userDao", UsersDao.class);

		Users user = new Users();
		user.setId("iruen99");
		user.setName("�̵���");
		user.setPassword("fighting!");

		dao.add(user);

		System.out.println(user.getId() + ", ��ϼ���!");

		Users user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + ", ��ȸ����!");

	}
}