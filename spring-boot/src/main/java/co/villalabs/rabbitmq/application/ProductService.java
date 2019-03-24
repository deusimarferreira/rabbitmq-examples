package co.villalabs.rabbitmq.application;

import co.villalabs.rabbitmq.domain.product.Product;
import co.villalabs.rabbitmq.infrastructure.form.ProductForm;

import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

   Product saveOrUpdateProductForm(ProductForm product);

    void sendProductMessage(String id);
}