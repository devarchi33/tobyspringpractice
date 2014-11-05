package skyfly33.practice07.toby;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {

	int counter = 0;
	private ConnectionMaker realConnectionMaker;

	// ������ �޼ҵ带 ���� DI����
	public void setRealConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	@Override
	public Connection makeNewConnection() throws ClassNotFoundException,
			SQLException {
		this.counter++;
		Connection conn = realConnectionMaker.makeNewConnection();
		return conn;
	}

	public int getCounter() {
		return this.counter;
	}
}
