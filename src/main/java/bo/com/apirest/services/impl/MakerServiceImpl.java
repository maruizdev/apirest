package bo.com.apirest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.com.apirest.dao.MakerDao;
import bo.com.apirest.entities.Maker;
import bo.com.apirest.services.MakerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MakerServiceImpl implements MakerService{

	private MakerDao makerDao;
	
	@Override
	public List<Maker> findAll() {
		return this.makerDao.findAll();
	}

	@Override
	public Optional<Maker> findById(Long id) {
		// TODO Auto-generated method stub
		return this.makerDao.findById(id);
	}

	@Override
	public void save(Maker maker) {
		this.makerDao.save(maker);
	}

	@Override
	public void deleteById(Long id) {
		this.makerDao.deleteById(id);
	}

}
