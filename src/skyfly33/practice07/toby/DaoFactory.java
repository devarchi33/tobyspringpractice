package skyfly33.practice07.toby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

	@Bean
	public UsersDao userDao() {
		UsersDao userDao = new UsersDao();
		userDao.setSimpleConnectionMaker(countingConnectionMaker());
		return userDao;
	}

	@Bean
	public ConnectionMaker countingConnectionMaker() {
		CountingConnectionMaker ccm = new CountingConnectionMaker();
		ccm.setRealConnectionMaker(realConnectionMaker());
		return ccm;
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new SimpleConnectionMaker();
	}
}
