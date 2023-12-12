package ar.com.codoacodo.repository;

import java.util.List;

//import java.time.LocalDate;
import ar.com.codoacodo.entity.Turno;

public class MainOradorRepository {
	public static void main(String[] args) {
		ITurnoRepository iRepository = new MysqlTurnoRepository();
		
		//Orador neworador = new Orador("juan", "sarase", "scards@gmail.com", "PHP");
		//iRepository.save(neworador);
		Turno orador = iRepository.getById(8L);
		System.out.println(orador);
		//iRepository.delete(1L);
		
		/*Orador sergio = iRepository.getById(2L);
		sergio.setApellido("Cardoz");
		sergio.setTema("JAVA");
		sergio.setMail("scardo@gm.com");
		iRepository.update(sergio);
		List<Orador> lista = iRepository.findAll();
		System.out.println(lista); 
		*/
		//Turno turnonew = new Turno("Viviana", "Juarez", "viv@gmail.com", LocalDate.now(), 10, "Barba");
		//iRepository.save(turnonew);
		//Turno turno = iRepository.getById(6L);
		//List<Turno> turno = iRepository.findAll();
		//System.out.println(turno);
	}
}
