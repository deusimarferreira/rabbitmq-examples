package co.villalabs.rabbitmq.domain.product;

import co.villalabs.rabbitmq.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}