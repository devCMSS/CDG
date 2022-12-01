package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import DTO.usuarioDTO;

public class usuarioDAO {

	Connection conn;

	public ResultSet autenticarUsuario(usuarioDTO objDto) {
		conn = new conexaoDAO().conectaBD();

		try {
			String sql = "Select * from login where login_empresa = ? and senha_empresa = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objDto.getLogin_empresa());
			pstm.setObject(2, objDto.getSenha_empresa());
			
			ResultSet rs = pstm.executeQuery();
			return rs;
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
			return null;
		}

	}

}
