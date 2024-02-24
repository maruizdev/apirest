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

import bo.com.apirest.controllers.dto.MakerDto;
import bo.com.apirest.entities.Maker;
import bo.com.apirest.services.MakerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/maker")
public class MakerController {
	
	private static final Logger log = LoggerFactory.getLogger(MakerController.class);
	
	private MakerService makerService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		log.info("==============pooo=======================");
		//List<Maker> makers = makerService.findAll();
		List<MakerDto> makersDto = makerService.findAll()
				.stream()
				.map(maker -> MakerDto.builder()
						.id(maker.getId())
						.name(maker.getName())
						.productList(maker.getProductList())
						.build())
				.collect(Collectors.toList());
			return ResponseEntity.ok(makersDto);
		
	//	return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Optional<Maker> makerOptional = makerService.findById(id);
		if(makerOptional.isPresent()) {
			Maker maker = makerOptional.get();
			MakerDto makerDto = MakerDto.builder()
					.id(maker.getId())
					.name(maker.getName())
					.productList(maker.getProductList())
					.build();
			return ResponseEntity.ok(makerDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody MakerDto makerDto) throws URISyntaxException{
		if(makerDto.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		
		makerService.save(Maker.builder().name(makerDto.getName()).build());
		return ResponseEntity.created(new URI("/api/maker/save")).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody MakerDto makerDto) {
		Optional<Maker> makerOptional = makerService.findById(id);
		if(makerOptional.isPresent()) {
			Maker maker = makerOptional.get();
			maker.setName(makerDto.getName());
			makerService.save(maker);
			return ResponseEntity.ok("REgistro actualzado");
		}
	
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id){
		if(id != null) {
			makerService.deleteById(id);
			return ResponseEntity.ok("REgistro eliminado");
		}
		return ResponseEntity.badRequest().build();
	}
}
