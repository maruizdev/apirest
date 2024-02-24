package bo.com.apirest.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import bo.com.apirest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MakerDto {
	private Long id;
	private String name;
	private List<Product> productList = new ArrayList<Product>();
}