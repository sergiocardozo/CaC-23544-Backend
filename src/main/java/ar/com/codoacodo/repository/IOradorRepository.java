package ar.com.codoacodo.repository;

import java.util.List;

import ar.com.codoacodo.entity.Orador;

public interface IOradorRepository {

	void save(Orador orador);
	Orador getById(Long id);
	void update(Orador orador);
	void delete(Long id);
	List<Orador> findAll();
	
}
