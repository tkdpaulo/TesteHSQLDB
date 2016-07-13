import java.sql.Connection;


public class Main {
	
	

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		Tables.createTable(con);
		Tables.insertTable(con);
		Tables.selectTable(con);
			
	}
	
	
}
