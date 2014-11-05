package skyfly33.practice5.toby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

	@Bean
	public UsersDao userDao() {
		UsersDao userDao = new UsersDao(realConnectionMaker());
		return userDao;
	}

	@Bean
	ConnectionMaker realConnectionMaker() {
		return new SimpleConnectionMaker();
	}
}
