package negocio;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

/* CLASSE PARA MANIPULAÇÃO DE OBJETOS NO BANCO */
public class OperacoesCrud {
	public static void main(String[] args) {
		Produto produto = new Produto();
		ProdutoDAO dao = new ProdutoDAO();
		
		produto.setNome("sabão");
		produto.setPreco(33.0);
		produto.setDescricao("em pó");
		
		//dao.salvar(produto);
		System.out.println();
		
		List<Produto> listaProdutos = dao.getListaProdutos();
		for (Produto p : listaProdutos) {
			System.out.println("nome: " + p.getNome());
		}
		
		System.out.println();
		
		List<Produto> listaId = dao.getListaProdutosPorId(6);
		for (Produto p : listaId) {
			System.out.println("busca nome produto por Id: " + p.getNome());
		}
		
		System.out.println();
		
		String nome = "lixeira";
		Integer id  = 6;
		//Produto prod = dao.atualiza(nome, id);
		//System.out.println("produto: " + prod.getNome());
		
		System.out.println();
		
		dao.deleta(7);
	}
}
