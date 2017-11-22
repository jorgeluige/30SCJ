package br.com.fiap.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.abstractdao.ClienteDao;
import br.com.fiap.abstractdao.DaoFactory;
import br.com.fiap.abstractdao.PedidoDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			ClienteDao clientesDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getClienteDao();
			
			List<Pedido> listaPedidos = new ArrayList<>();
			
			Cliente cliente = new Cliente();
			cliente.setNome("Pedro Fontes");
			cliente.setEmail("pedro@fontes.com");
			cliente = clientesDao.inserirCliente(cliente);
						
			PedidoDao pedidosDao = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getPedidoDao();
			
			
			Pedido pedido = new Pedido();
			pedido.setData(new Date());
			pedido.setDescricao("Materiais Escritório");
			pedido.setValor(9000);
			pedido.setIdCliente(cliente.getId());
			
			pedidosDao.incluirPedido(pedido);
			
			listaPedidos = pedidosDao.listarPedido(4);
			for (Pedido pedidos : listaPedidos) {
				System.out.println(pedidos.getDescricao());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}