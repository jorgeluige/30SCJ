package br.com.fiap.core;

import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.UsuarioHelper;

public class Teste {

	public static void main(String[] args) {
		try {
			
			final Usuario usuario = new Usuario("Teste", "teste@teste.com");
			
			final UsuarioHelper usuarioHelper = new UsuarioHelper();
			
			usuarioHelper.salvarUsuario(usuario);
			
			final Usuario usuario2 = usuarioHelper.getUsuario(1);
			
			usuario2.setNome("Teste2");
			
			usuarioHelper.salvarUsuario(usuario2);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
