package cart.entity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CART")
public class Cart {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "USUARIO_ID")
	private long usuario;
	
	@Embedded
    @ElementCollection
	private Collection<Produto> PRODUTOS;
	
	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	
	public Cart(long id, long usuario, Collection<Produto> produtos) {
		super();
		this.usuario = usuario;
		this.id = id;
		this.PRODUTOS = produtos;
	}
	
	public Cart() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<Produto> getProdutos() {
        if(PRODUTOS == null) {
        	PRODUTOS = new ArrayList<>();
        }
        return PRODUTOS;
	}

	public void setProducts(Collection<Produto> produtos) {
		this.PRODUTOS = produtos;
	}
}

