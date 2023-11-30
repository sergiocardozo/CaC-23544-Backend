package ar.com.codoacodo.entity;
import java.time.LocalDate;
public class MainOrador {
	public static void main(String[] args ) {
		Orador o = new Orador("sergio", "Cardozo", "email@email.com", "JAVA", LocalDate.now());
		
		System.out.println(o);
	}
}
