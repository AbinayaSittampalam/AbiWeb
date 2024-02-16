package Abi.website.bootstrap;

import Abi.website.domain.Product;
import Abi.website.repositories.ProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Product shirt = new Product();
        shirt.setDescription("shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://www.google.com/search?q=mug&tbm=isch&tbs=il:ol&hl=en&sa=X&ved=0CAAQ1vwEahcKEwjAy6WV7aOEAxUAAAAAHQAAAAAQAw&biw=1519&bih=695#imgrc=a5pRzAQTy6_06M");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Tshirt");
        mug.setImageUrl("https://www.google.com/search?q=mug&tbm=isch&tbs=il:ol&hl=en&sa=X&ved=0CAAQ1vwEahcKEwjAy6WV7aOEAxUAAAAAHQAAAAAQAw&biw=1519&bih=695#imgrc=a5pRzAQTy6_06M");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }
}
