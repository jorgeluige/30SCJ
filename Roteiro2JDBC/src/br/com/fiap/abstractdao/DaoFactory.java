package br.com.fiap.abstractdao;

import br.com.fiap.dao.MySQLDaoFactory;
import br.com.fiap.dao.SqlServerDaoFactory;

public abstract class DaoFactory {

	//Lista de tipos suportados pelo factory
	public static final int MYSQL = 1; 
	public static final int SQLSERVER = 2;

	//Teremos um me?todo para cada DAO criado. As classes "factory" concretas implementara?o estes me?todos
	
	public abstract ClienteDao getClienteDao(); 
	public abstract PedidoDao getPedidoDao();

	public static DaoFactory getDaoFactory(int tipo){ 

		switch(tipo){
			case MYSQL: return new MySQLDaoFactory();
			case SQLSERVER: return new SqlServerDaoFactory(); 
			default: return null;
		}
	} 
}