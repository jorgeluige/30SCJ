package br.com.fiap.dao;

import br.com.fiap.abstractdao.ClienteDao;
import br.com.fiap.abstractdao.DaoFactory;
import br.com.fiap.abstractdao.PedidoDao;

public class SqlServerDaoFactory extends DaoFactory{
	@Override
	public ClienteDao getClienteDao() {
		return null;
	}
	
	@Override
	public PedidoDao getPedidoDao() {
		return null;
	}
}