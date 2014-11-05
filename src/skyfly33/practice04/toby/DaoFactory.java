package skyfly33.practice04.toby;

public class DaoFactory {

	public UsersDao userDao() {
		ConnectionMaker connectionMaker = new SimpleConnectionMaker();
		UsersDao userDao = new UsersDao(connectionMaker);
		return userDao;
	}
}
