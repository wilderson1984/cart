package cart.repository;
import org.springframework.data.repository.CrudRepository;

import cart.entity.Cart;


public interface CartRepository extends CrudRepository<Cart, Long> {
}

