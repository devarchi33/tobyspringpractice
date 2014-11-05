package skyfly33.practice10.toby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DaoFactory {

	@Bean
	public UsersDao userDao() {
		UsersDao userDao = new UsersDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}

	@Bean
	public SimpleDriverDataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@192.168.0.13:1521:orcl");
		dataSource.setUsername("spring");
		dataSource.setPassword("spring");

		return dataSource;
	}
}
