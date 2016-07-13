import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionFactory{
	public Connection getConnection(){
		
		String driver = "org.hsqldb.jdbcDriver";
		String url = "jdbc:hsqldb:file:/banco/hyperDB";
		String user = "sa";
		String password = "";
		
		try{
		   	Class.forName(driver);
		    Connection con = DriverManager.getConnection(url,user, password);
		    return con;
		   
		}catch(ClassNotFoundException e1){
		    System.out.println("Erro ao carregar o driver JDBC. ");
		}catch(SQLException e2){
		    System.out.println("Erro de SQL: "+e2);
		    e2.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Statement stm){
		try {
			stm.execute("SHUTDOWN");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
