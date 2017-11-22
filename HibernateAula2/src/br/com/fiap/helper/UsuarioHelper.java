package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import br.com.fiap.core.HibernateUtil;
import br.com.fiap.entity.Usuario;

public class UsuarioHelper {
	Session session = null;
	public UsuarioHelper(){
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	private Session getSession() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}
	
	public List<Usuario> getUsuarios(){
		List<Usuario> lista = new ArrayList<Usuario>();
		try{
			Transaction tx = getSession().beginTransaction();
			Query q = session.createQuery("from Usuario");
			lista = q.list();
			tx.commit();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return lista;
	}
	
	public Usuario getUsuario(int id){
		Usuario usuario = new Usuario();
		try {
			Transaction tx = getSession().beginTransaction();
			getSession().load(usuario, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	
	public String salvarUsuario(Usuario p){
		try{
			Transaction tx = getSession().beginTransaction();
			session.save(p);
			tx.commit();
			return "Dados inseridos";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}
}