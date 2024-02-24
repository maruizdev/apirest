package bo.com.apirest.dao;

import bo.com.apirest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface MakerDao {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteById(Long id);
}
