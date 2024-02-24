package bo.com.apirest.services;

import java.util.List;
import java.util.Optional;

import bo.com.apirest.entities.Maker;

public interface MakerService {
	  List<Maker> findAll();
	    Optional<Maker> findById(Long id);
	    void save(Maker maker);
	    void deleteById(Long id);
}
