package ar.com.codoacodo.repository;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {
	public static void main(String[] args) {
		IOradorRepository iRepository = new MysqlOradorRepository();
		
		Orador neworador = new Orador("juan", "sarase", "scards@gmail.com", "PHP");
		iRepository.save(neworador);
		//Orador orador = iRepository.getById(12L);
		
//		System.out.println(orador);

		System.out.println(neworador);
	}
}
