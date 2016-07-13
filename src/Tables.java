import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables {
	public static void createTable(Connection con){
		try{
			Statement stm= con.createStatement();
			stm.executeQuery("CREATE TABLE FUNCIONARIO("
							+"FUNC_COD 	INT NOT NULL,"
							+"FUNC_NOME	VARCHAR(50),"
							+"FUNC_CPF	VARCHAR(20),"
							+"FUNC_DEPTO	INT,"
							+"FUNC_SALARIO	DOUBLE,"
							+"FUNC_CARGO	INT"
							+");");
			stm.executeQuery("CREATE TABLE DEPARTAMENTO("
							+"DEPTO_CODIGO	INT NOT NULL,"
							+"DEPTO_DESCRICAO	VARCHAR(30),"
							+"DEPTO_RAMAL		INT DEFAULT 0"
							+");");
			stm.executeQuery("CREATE TABLE CARGO("
							+"CARGO_COD	IDENTITY PRIMARY KEY,"
							+"CARGO_DESCRICAO	VARCHAR(30),"
							+"CARGO_NIVEL INT"
							+");");
			
			System.out.println("Tabelas Criadas com sucesso!\n");
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
		   
	}
	public static void insertTable(Connection con){
		try{
		Statement stm= con.createStatement();
		stm.executeQuery("INSERT INTO DEPARTAMENTO(DEPTO_CODIGO,DEPTO_DESCRICAO)"
						+"VALUES(1,'FINANCEIRO'),"
						+"(2,'RH'),"
						+"(3,'CONTABIL'),"
						+"(4,'PROJETOS');");
		stm.executeQuery("INSERT INTO FUNCIONARIO(FUNC_COD,FUNC_NOME,FUNC_DEPTO,FUNC_SALARIO,FUNC_CARGO)"
						+"VALUES(1,'LEANDRO',4,1000.00,8),"
						+"(2,'JOAO',1,1200.00,1),"
						+"(3,'JOSE',4,1000.00,7);");
		stm.executeQuery("INSERT INTO CARGO(CARGO_COD,CARGO_DESCRICAO)"
						+"VALUES(1,'ANALISTA FINANCEIRO'),"
						+"(2,'AUXILIAR ADMINISTRATIVO'),"
						+"(3,'PSICOLOGA'),"
						+"(4,'ASSISTENTE DE RECRUTAMENTO'),"
						+"(5,'CONTROLER'),"
						+"(6,'CONTADOR'),"
						+"(7,'PROGRAMADOR'),"
						+"(8,'ANALISTA DE SISTEMAS'),"
						+"(9,'GERENTE DE PROJETOS');");
		System.out.println("Dados Inseridos!\n");
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
	}
	public static void selectTable(Connection con){
		try{
			Statement stm= con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM DEPARTAMENTO");
			System.out.println("\nDepartamentos:\n");
			while(rs.next()){
			    String cod = rs.getString("DEPTO_CODIGO");
			    String descricao = rs.getString("DEPTO_DESCRICAO");
			    System.out.println(cod+" - "+descricao);
				}
			ResultSet rs1 = stm.executeQuery("SELECT * FROM FUNCIONARIO");
			System.out.println("\nFuncionarios:\n");
			while(rs1.next()){
			    String cod = rs1.getString("FUNC_COD");
			    String nome = rs1.getString("FUNC_NOME");
			    String departamento = rs1.getString("FUNC_DEPTO");
			    Double salario = rs1.getDouble("FUNC_SALARIO");
			    int cargo = rs1.getInt("FUNC_CARGO");
			    System.out.println(cod+" - "+nome+" - "+departamento+" - "+salario+" - "+cargo);
				}
			ResultSet rs2 = stm.executeQuery("SELECT * FROM CARGO");
			System.out.println("\nCargos:\n");
			while(rs2.next()){
			    String cod = rs2.getString("CARGO_COD");
			    String descricao = rs2.getString("CARGO_DESCRICAO");
			    int nivel = rs2.getInt("CARGO_NIVEL");
			    System.out.println(cod+" - "+descricao+" - "+nivel);
				}
			ConnectionFactory.closeConnection(stm);
		}catch(SQLException e){
		    System.out.println("Erro de SQL: "+e);
		    e.printStackTrace();
		}
	}
}
