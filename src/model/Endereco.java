package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 
    private String complemento;
    private String entreRua1;
    private String entreRua2;
    private int numero;
    private String pontoReferencia;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEntreRua1() {
		return entreRua1;
	}
	public void setEntreRua1(String entreRua1) {
		this.entreRua1 = entreRua1;
	}
	public String getEntreRua2() {
		return entreRua2;
	}
	public void setEntreRua2(String entreRua2) {
		this.entreRua2 = entreRua2;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
    
    
    
}
