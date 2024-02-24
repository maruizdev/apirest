package bo.com.apirest.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.com.apirest.controllers.dto.ProductDto;
import bo.com.apirest.entities.Product;
import bo.com.apirest.services.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	private ProductService productService;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		log.info("==============pooo=======================");
		//List<Maker> makers = makerService.findAll();
		List<ProductDto> productsDto = productService.findAll()
				.stream()
				.map(product -> ProductDto.builder()
						.id(product.getId())
						.name(product.getName())
						.price(product.getPrice())
						.maker(product.getMaker())
						.build())
				.collect(Collectors.toList());
			return ResponseEntity.ok(productsDto);
		
	//	return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Optional<Product> productOptional = productService.findById(id);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			ProductDto productDto = ProductDto.builder()
					.id(product.getId())
					.name(product.getName())
					.price(product.getPrice())
					.maker(product.getMaker())
					.build();
			return ResponseEntity.ok(productDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ProductDto productDto) throws URISyntaxException{
		if(productDto.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		this.productService.save(Product.builder().name(productDto.getName())
				.price(productDto.getPrice())
				.maker(productDto.getMaker())
				.build());
		return ResponseEntity.created(new URI("/api/product/save")).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
		Optional<Product> productOptional = productService.findById(id);
		if(productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setMaker(productDto.getMaker());
	
			productService.save(product);
			return ResponseEntity.ok("REgistro actualzado");
		}
	
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id){
		if(id != null) {
			productService.deleteById(id);
			return ResponseEntity.ok("REgistro eliminado");
		}
		return ResponseEntity.badRequest().build();
	}
}
