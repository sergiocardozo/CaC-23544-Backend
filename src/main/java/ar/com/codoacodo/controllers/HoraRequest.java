package ar.com.codoacodo.controllers;

public class HoraRequest {
	private Integer id_hora;
	private String nombre_hora;
	
	public HoraRequest() {}
	public HoraRequest(Integer id_hora, String nombre_hora) {
		super();
		this.id_hora = id_hora;
		this.nombre_hora = nombre_hora;
	}
	public Integer getId_hora() {
		return id_hora;
	}
	public void setId_hora(Integer id_hora) {
		this.id_hora = id_hora;
	}
	public String getNombre_hora() {
		return nombre_hora;
	}
	public void setNombre_hora(String nombre_hora) {
		this.nombre_hora = nombre_hora;
	}
	
	
}
