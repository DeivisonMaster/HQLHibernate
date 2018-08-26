package dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Endereco;
import model.Pessoa;
import util.HibernateUtil;

public class DAO<T> {
	private Session session;
	private Transaction tx;
	
	public DAO() {
		this.session = new HibernateUtil().getSession();
	}
	
	public void salvar(T entity) {
		try {
			tx = session.beginTransaction();
			session.persist(entity);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Type Unsafed only for tests */
	public List<Pessoa> getListaPessoa(){
		String hql = "SELECT pessoa FROM Pessoa pessoa";
		String buscaPessoasEnderecoRelaciconados = "SELECT p FROM Pessoa p JOIN FETCH p.endereco";
		String buscaPessoasEnderecoNaoRelacionados = "SELECT p FROM Pessoa p LEFT JOIN FETCH p.endereco";
		
		try {
			Query<Pessoa> listaPessoas = session.createQuery(buscaPessoasEnderecoNaoRelacionados);
			return listaPessoas.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Endereco> getListaEndereco(){
		try {
			Query<Endereco> query = session.createQuery("SELECT e FROM Endereco e");
			List<Endereco> resultado = query.getResultList();
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Pessoa buscarPessoaId(int numero) {
		String hql = "SELECT p FROM Pessoa p LEFT JOIN FETCH p.endereco e WHERE e.numero = :numeroEndereco";
		try {
			Query<Pessoa> consulta = session.createQuery(hql);
			consulta.setParameter("numeroEndereco", numero);
			Pessoa pessoa = consulta.getSingleResult();
			if(pessoa == null) {
				System.out.println("pessoa não encontrada!");
			}
			return pessoa;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}





























