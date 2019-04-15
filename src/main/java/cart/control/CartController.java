package cart.control;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cart.client.ProdutoClient;
import cart.dto.AddProdutoRequest;
import cart.entity.Cart;
import cart.entity.Produto;
import cart.repository.CartRepository;


@RestController
public class CartController {
	private CartRepository cartRepository;
    private ProdutoClient productClient;

	public CartController(CartRepository cartRepository, ProdutoClient productClient) {
        this.cartRepository = cartRepository;
        this.productClient = productClient;
    }

    @PostMapping("{usuario}/cart/")
    public Cart createCart(@PathVariable("usuario") Long usuario) {
    	Cart cart = new Cart();
    	cart.setUsuario(usuario);
        return cartRepository.save(cart);
    }

    @PostMapping("/cart/{id}/produtos/")
    public ResponseEntity<Cart> addProductToCart(@PathVariable("id") Long id, @RequestBody AddProdutoRequest request) {
        Optional<Cart> maybeCart = cartRepository.findById(id);
        if(!maybeCart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cart cart = maybeCart.get();
        Produto product = productClient.getProduct(request.getId());
        if(null == product) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        cart.getProdutos().add(product);
        return new ResponseEntity<>(cartRepository.save(cart), HttpStatus.OK);
    }

    @GetMapping("/cart/{id}/")
    public ResponseEntity<Cart> getCart(@PathVariable("id") Long id) {
        Optional<Cart> maybeCart = cartRepository.findById(id);
        if(!maybeCart.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maybeCart.get(), HttpStatus.OK);
    }

}
