package bo.com.apirest.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.com.apirest.dao.ProductDao;
import bo.com.apirest.entities.Product;
import bo.com.apirest.services.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		return this.productDao.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return this.productDao.findById(id);
	}

	@Override
	public void save(Product product) {
		this.productDao.save(product);
	}

	@Override
	public void deleteById(Long id) {
		this.productDao.deleteById(id);

	}

	@Override
	public List<Product> finByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
		return this.productDao.finByPriceInRange(minPrice, maxPrice);
	}

}
