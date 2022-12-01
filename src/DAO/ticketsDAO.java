package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.ticketsDTO;

public class ticketsDAO {

	Connection conn;
	PreparedStatement pstm;

	public void cadastroEstoque(ticketsDTO ticketsdto) {
		String sql = " insert into tickets (usuario_ticket, desc_ticket) values (?,?)";

		conn = new conexaoDAO().conectaBD();

		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ticketsdto.getUsuario_ticket());
			pstm.setString(2, ticketsdto.getDesc_ticket());
			JOptionPane.showMessageDialog(null, "Ticket criado com sucesso, em até 48h um membro de nosso suporte terá entrado em contato!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			pstm.execute();
			pstm.close();
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "ticketsDAO:" + erro);
		}

	}

}
