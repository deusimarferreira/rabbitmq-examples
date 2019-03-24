package co.villalabs.rabbitmq.infrastructure.listener;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import co.villalabs.rabbitmq.domain.product.Product;
import co.villalabs.rabbitmq.domain.product.ProductRepository;

@Component
public class ProductMessageListener {
    private ProductRepository productRepository;

    private static final Logger log = LogManager.getLogger(ProductMessageListener.class);

    public ProductMessageListener(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * This method is invoked whenever any new message is put in the queue.
     * See {@link guru.springframework.SpringBootRabbitMQApplication} for more details
     * @param message
     */
    public void receiveMessage(Map<String, String> message) {
        log.info("Received <" + message + ">");
        Long id = Long.valueOf(message.get("id"));
        Product product = productRepository.findById(id).orElse(null);
        product.setMessageReceived(true);
        product.setMessageCount(product.getMessageCount() + 1);

        productRepository.save(product);
        log.info("Message processed...");
    }
}