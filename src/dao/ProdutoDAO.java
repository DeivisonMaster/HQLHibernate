package dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Produto;
import util.HibernateUtil;

public class ProdutoDAO {
	private Session session;
	private Transaction transaction;
	
	public ProdutoDAO() {
		this.session = HibernateUtil.getSession();
	}
	
	public void salvar(Produto produto){
		try {
			this.transaction = this.session.beginTransaction();
			this.session.save(produto);
			this.transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Produto atualiza(String nome, Integer id){
		try {
			String busca = "UPDATE Produto SET nome = :nome WHERE id = :id";
			Query<Produto> consulta = session.createQuery(busca);
			consulta.setParameter("id", id);
			consulta.setParameter("nome", nome);
			return consulta.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleta(Integer id){
		try {
			String busca = "DELETE Produto WHERE id = :id";
			Query<Produto> consulta = session.createQuery(busca);
			consulta.setParameter("id", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> getListaProdutos(){
		List<Produto> produtos = new ArrayList<>();
		try {
			String busca = "SELECT p FROM Produto p";
			Query<Produto> consulta = session.createQuery(busca);
			produtos = consulta.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	public List<Produto> getListaProdutosPorId(Integer id){
		List<Produto> produtos = new ArrayList<>();
		try {
			String busca = "SELECT p FROM Produto p WHERE p.id = :id";
			Query<Produto> consulta = session.createQuery(busca);
			consulta.setParameter("id", id);
			produtos = consulta.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}
}
