package skyfly33.practice10.toby;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDao {

	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				DaoFactory.class);
		UsersDao userDao = ctx.getBean("userDao", UsersDao.class);

		Users user = new Users("imfly778", "이동훈", "fighting!!");
		userDao.add(user);

		System.out.println("등록성공!!");

		Users user2 = userDao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + ", 조회성공!!");
	}
}
