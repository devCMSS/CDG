package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class classeConexao {
	private static Connection conexao = null;
	//Método para fazer a conexão com o MySQL:
	public static Connection Conectar() {
		try {
			//Verificar primeiro se a cnoxão já foi feita:
			if(conexao==null) {
				//Vamos criar uma String contendo o caminho do banco de dados:
				String url = "jdbc:mysql://localhost/cdg";
				//Vamos fazer a conexão:
				conexao = DriverManager.getConnection (url,"root","");
			}
		} catch(SQLException erro) {
			JOptionPane.showMessageDialog(null, "Usuário não cadastrado" + erro);
		 erro.printStackTrace();
		}
		return conexao;
	}
	
 public static void FecharConexao(Connection c) {
	  try {
		  if(c!=null) {
			  c.close();
			  conexao = null;
	    }
        } catch(SQLException e) {
	 e.printStackTrace();
    }
  }

}