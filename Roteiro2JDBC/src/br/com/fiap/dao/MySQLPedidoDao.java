package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.abstractdao.PedidoDao;
import br.com.fiap.entity.Pedido;

public class MySQLPedidoDao implements PedidoDao{
	

	Connection cn = null;
	PreparedStatement stmt;
	ResultSet rs = null;
	
	@Override
	public Pedido incluirPedido(Pedido pedido) throws Exception { 
		
		try {
			cn=MySQLDaoFactory.criarConexao();
			
			String sql="INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
			stmt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, pedido.getIdCliente());
			stmt.setDate(2, new Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			if (rs.next()){
				pedido.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
 		}
		return pedido;
	}
	
	@Override
	public List<Pedido> listarPedido(int idCliente) throws Exception { 
		List<Pedido> pedidos = new ArrayList<>();
		
		try {
			cn=MySQLDaoFactory.criarConexao();
			
			
			String sql="SELECT IDPEDIDO,IDCLIENTE,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE IDCLIENTE=?";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			while (rs.next()){
				pedidos.add(new Pedido(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
						rs.getInt("IDCLIENTE"), idCliente));
			}
		} catch (Exception e) {
			throw e;
		}
		finally{
			cn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		
		return pedidos;
		
	}
}