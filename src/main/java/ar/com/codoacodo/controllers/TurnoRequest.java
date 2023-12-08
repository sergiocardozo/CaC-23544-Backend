package ar.com.codoacodo.controllers;

import java.time.LocalDate;


public class TurnoRequest {
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fecha_turno;
	private String hora_turno;
	private String tipo_corte;
	
	public TurnoRequest() {}

	public TurnoRequest(String nombre, String apellido, String mail, LocalDate fecha_turno, String hora_turno,
			String tipo_corte) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.fecha_turno = fecha_turno;
		this.hora_turno = hora_turno;
		this.tipo_corte = tipo_corte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public LocalDate getFecha_turno() {
		return fecha_turno;
	}

	public void setFecha_turno(LocalDate fecha_turno) {
		this.fecha_turno = fecha_turno;
	}

	public String getHora_turno() {
		return hora_turno;
	}

	public void setHora_turno(String hora_turno) {
		this.hora_turno = hora_turno;
	}

	public String getTipo_corte() {
		return tipo_corte;
	}

	public void setTipo_corte(String tipo_corte) {
		this.tipo_corte = tipo_corte;
	}
	
	
	
	
}
