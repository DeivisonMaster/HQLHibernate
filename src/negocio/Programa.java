package negocio;


import java.util.HashSet;
import java.util.List;

import org.hibernate.query.Query;

import dao.DAO;
import dao.ProdutoDAO;
import model.Endereco;
import model.Pessoa;
import model.Produto;

public class Programa {
	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		DAO persiste = new DAO();
		
		Produto produto = new Produto();
		produto.setNome("bolacha");
		produto.setPreco(2.50);
		produto.setDescricao("biscoito recheado");
		
		//dao.salvar(produto);
		
		Endereco endereco1 = new Endereco();
		endereco1.setNumero(12);
		endereco1.setPontoReferencia("proximo ao mercado legal");
		//persiste.salvar(endereco1);
		
		Endereco endereco2 = new Endereco();
		endereco2.setNumero(321);
		endereco2.setPontoReferencia("ao lado farmacia");
		//persiste.salvar(endereco2);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("rebecca");
		pessoa.setEmail("rebecca@gmail.com");
		List<Endereco> listaEndereco = persiste.getListaEndereco();
		pessoa.setEndereco(new HashSet<>(listaEndereco));
		//persiste.salvar(pessoa);
		
		List<Pessoa> listaPessoa = persiste.getListaPessoa();
		for (Pessoa p : listaPessoa) {
			System.out.println("id pessoa: " + p.getId() + " - " + "nome pessoa: " + p.getNome());
		}
		
		System.out.println("***********************");
		
		Pessoa pessoa2 = persiste.buscarPessoaId(1233);
		System.out.println("nome: " + pessoa2.getNome());
	}
}



























