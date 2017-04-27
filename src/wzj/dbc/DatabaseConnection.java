package wzj.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver" ;
	private static final String URL="jdbc:oracle:thin:@localhost:1521:jayw" ;
	private static final String USER="scott" ;
	private static final String PASSWORD="tiger" ;
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	public static Connection rebulidConnection(){
		try{
			Class.forName(DRIVER) ;
			return DriverManager.getConnection(URL, USER, PASSWORD) ;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null ;
	}
	public static Connection getConnection(){
		Connection conn=threadLocal.get() ;
		if(conn==null){
			conn=rebulidConnection() ;
			threadLocal.set(conn);
		}
		return conn ;
	}
	public static void close(){
		Connection conn=threadLocal.get() ;
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			threadLocal.remove();
		}
	}
}
