package br.com.fiap.abstractdao;

import java.util.List;

import br.com.fiap.entity.Pedido;

public interface PedidoDao {
	Pedido incluirPedido(Pedido pedido) throws Exception; 
	List<Pedido> listarPedido(int idCliente) throws Exception;
}