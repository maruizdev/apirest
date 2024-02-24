package bo.com.apirest.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import bo.com.apirest.controllers.MakerController;
import bo.com.apirest.dao.MakerDao;
import bo.com.apirest.entities.Maker;
import bo.com.apirest.repository.MakerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MakerDaoImpl implements MakerDao {
	private static final Logger log = LoggerFactory.getLogger(MakerController.class);

    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) this.makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
    	log.info("==============unooo=======================");
        return this.makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerRepository.deleteById(id);
    }
}
