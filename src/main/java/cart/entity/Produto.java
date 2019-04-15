package cart.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Produto {
	@Column(name = "PRODUTO_ID")
	private Long id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "DESCRICAO")
    private String descricao;
	@Column(name = "PRECO")
    private Double preco;

    public Produto(Long id, String nome, String descricao, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
    
    public Produto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
    
    

}
