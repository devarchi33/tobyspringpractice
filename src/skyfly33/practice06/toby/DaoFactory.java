package skyfly33.practice06.toby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

	@Bean
	public UsersDao userDao() {
		UsersDao userDao = new UsersDao(countingConnectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker countingConnectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new SimpleConnectionMaker();
	}
}
