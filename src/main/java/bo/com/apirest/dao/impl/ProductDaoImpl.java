package bo.com.apirest.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import bo.com.apirest.dao.ProductDao;
import bo.com.apirest.entities.Product;
import bo.com.apirest.repository.ProductRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProductDaoImpl implements ProductDao {

    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
    this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> finByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return this.productRepository.findProductByPriceBetween(minPrice,maxPrice);
    }
}
