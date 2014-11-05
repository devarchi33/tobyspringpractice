package skyfly33.practice8.toby;

import java.sql.Connection;
import java.sql.SQLException;

import skyfly33.practice6.toby.ConnectionMaker;

public class CountingConnectionMaker implements ConnectionMaker {

	int counter = 0;
	private ConnectionMaker simpleConnectionMaker;

	/*
	 * CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
	 * this.simpleConnectionMaker = realConnectionMaker; }
	 * 
	 * // 수정자 메소드를 통한 DI주입 public void setRealConnectionMaker(ConnectionMaker
	 * realConnectionMaker) { this.simpleConnectionMaker = realConnectionMaker;
	 * }
	 */

	@Override
	public Connection makeNewConnection() throws ClassNotFoundException,
			SQLException {
		this.counter++;
		Connection conn = simpleConnectionMaker.makeNewConnection();
		return conn;
	}

	public int getCounter() {
		return this.counter;
	}
}
