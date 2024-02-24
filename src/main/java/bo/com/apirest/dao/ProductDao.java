package bo.com.apirest.dao;

import bo.com.apirest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void deleteById(Long id);

    List<Product> finByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
