package bo.com.apirest.repository;

import org.springframework.data.repository.CrudRepository;

import bo.com.apirest.entities.Maker;

public interface MakerRepository extends CrudRepository<Maker, Long> {
}
