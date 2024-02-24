package bo.com.apirest.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import bo.com.apirest.entities.Product;

public interface ProductService {
	
	List<Product> findAll();
	Optional<Product> findById(Long id);
	void save(Product product);
	void deleteById(Long id);
	List<Product> finByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
