package bo.com.apirest.repository;

import bo.com.apirest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("from Product p where p.price between :minPrice and :maxPrice")
    List<Product>findProductByPriceInRange(@Param("minPrice") BigDecimal minPrice,@Param("maxPrice")  BigDecimal maxPrice);

    List<Product>findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
