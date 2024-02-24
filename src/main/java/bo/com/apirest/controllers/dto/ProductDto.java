package bo.com.apirest.controllers.dto;

import java.math.BigDecimal;

import bo.com.apirest.entities.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
	private Long id;
	private String name;
	private BigDecimal price;
	private Maker maker;
}
