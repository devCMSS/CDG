package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DTO.estoqueDTO;
import cdg.gui.cdgestoque;

@SuppressWarnings("unused")
public class estoqueDAO {

	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	ArrayList<estoqueDTO> lista = new ArrayList<>();

	public void cadastroEstoque(estoqueDTO estoquedto) {
		conn = new conexaoDAO().conectaBD();
		String sql = " insert into estoque (produto, quantidade) values (?,?)";



		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, estoquedto.getProduto());
			pstm.setInt(2, estoquedto.getQuantidade());
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			pstm.execute();
			pstm.close();

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "estoqueDAO (CADASTRO): " + erro);
		}

	}

	public ArrayList<estoqueDTO> pesquisarEstoque() {
		conn = new conexaoDAO().conectaBD();
		String sql = "select * from estoque";
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				estoqueDTO estoquedto1 = new estoqueDTO();
				estoquedto1.setCodigo(rs.getInt("codigo"));
				estoquedto1.setProduto(rs.getString("produto"));
				estoquedto1.setQuantidade(rs.getInt("quantidade"));
				lista.add(estoquedto1);
			}

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "estoqueDAO (PESQUISA): " + erro);
		}
		return lista;

	}
	
	public void Selecionar () {
		conn = new conexaoDAO().conectaBD();
		String sql = "select * from estoque order by codigo";
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				estoqueDTO estoquedto1 = new estoqueDTO();
				estoquedto1.setCodigo(rs.getInt("codigo"));
				estoquedto1.setProduto(rs.getString("produto"));
				estoquedto1.setQuantidade(rs.getInt("quantidade"));
				lista.add(estoquedto1);
			}

		} catch (SQLException erro) {

			JOptionPane.showMessageDialog(null, "estoqueDAO (PESQUISA): " + erro);
		}
	}
	

}
