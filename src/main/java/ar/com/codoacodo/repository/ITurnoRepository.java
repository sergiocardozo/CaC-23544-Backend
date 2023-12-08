package ar.com.codoacodo.repository;
import ar.com.codoacodo.entity.Turno;

import java.util.List;

public interface ITurnoRepository {

	void save(Turno orador);
	Turno getById(Long id);
	void update(Turno orador);
	void delete(Long id);
	List<Turno> findAll();
	
}
