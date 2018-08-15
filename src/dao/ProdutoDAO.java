package dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
