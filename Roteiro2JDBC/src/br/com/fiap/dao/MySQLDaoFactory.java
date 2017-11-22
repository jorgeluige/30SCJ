package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.fiap.abstractdao.ClienteDao;
import br.com.fiap.abstractdao.DaoFactory;
import br.com.fiap.abstractdao.PedidoDao;

public class MySQLDaoFactory extends DaoFactory{
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/vendas";

	public static Connection criarConexao() throws Exception{ 
		return DriverManager.getConnection(URL,"root","fiap");
	}

	@Override
	public ClienteDao getClienteDao() {
		return new MySQLClienteDao();
	}

	@Override
	public PedidoDao getPedidoDao() {
		return new MySQLPedidoDao();
	}
}