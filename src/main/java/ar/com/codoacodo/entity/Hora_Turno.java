package ar.com.codoacodo.entity;

public class Hora_Turno {

	private Long id_hora;
	private String nombre_hora;
	public Hora_Turno(Long id_hora, String nombre_hora) {
		super();
		init(id_hora, nombre_hora);
	}
	
	public Hora_Turno(String nombre_hora) {
		super();
		this.nombre_hora = nombre_hora;
	}
	public void init(Long id_hora, String nombre_hora) {
		this.id_hora = id_hora;
		this.nombre_hora = nombre_hora;
	}

	@Override
	public String toString() {
		return "Hora_Turno [id_hora=" + id_hora + ", nombre_hora=" + nombre_hora + "]";
	}

	public Long getId_hora() {
		return id_hora;
	}

	public void setId_hora(Long id_hora) {
		this.id_hora = id_hora;
	}

	public String getNombre_hora() {
		return nombre_hora;
	}

	public void setNombre_hora(String nombre_hora) {
		this.nombre_hora = nombre_hora;
	}
	
	
	
}
