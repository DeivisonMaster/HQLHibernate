package negocio;


import dao.ProdutoDAO;
import model.Produto;

public class Programa {
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("bolacha");
		produto.setPreco(2.50);
		produto.setDescricao("biscoito recheado");
		
		dao.salvar(produto);
	}
}



























