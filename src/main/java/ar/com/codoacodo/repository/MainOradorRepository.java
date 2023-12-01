package ar.com.codoacodo.repository;

import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {
	public static void main(String[] args) {
		IOradorRepository iRepository = new MysqlOradorRepository();
		
		//Orador neworador = new Orador("juan", "sarase", "scards@gmail.com", "PHP");
		//iRepository.save(neworador);
		//Orador orador = iRepository.getById(12L);
//		System.out.println(orador);
		//iRepository.delete(1L);
		
		Orador sergio = iRepository.getById(2L);
		sergio.setApellido("Cardoz");
		sergio.setTema("JAVA");
		sergio.setMail("scardo@gm.com");
		iRepository.update(sergio);
		List<Orador> lista = iRepository.findAll();
		System.out.println(lista);
	}
}
