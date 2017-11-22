package br.com.fiap.abstractdao;

import br.com.fiap.entity.Cliente;

public interface ClienteDao {
	Cliente inserirCliente(Cliente cliente) throws Exception;
	Cliente buscarCliente(int id) throws Exception;
}