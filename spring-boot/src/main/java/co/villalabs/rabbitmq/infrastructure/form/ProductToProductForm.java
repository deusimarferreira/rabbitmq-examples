package co.villalabs.rabbitmq.infrastructure.form;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.villalabs.rabbitmq.domain.product.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
    @Override
    public ProductForm convert(Product product) {
        ProductForm productForm = new ProductForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setPrice(product.getPrice());
        productForm.setImageUrl(product.getImageUrl());
        return productForm;
    }
}