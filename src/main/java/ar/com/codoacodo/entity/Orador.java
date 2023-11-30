package ar.com.codoacodo.entity;

import java.time.LocalDate;
import java.util.Date;

public class Orador {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String tema;
	private Date fechaAlta;

	//alt+shift+s Genera constructores automaticamente
	public Orador(String nombre, String apellido, String mail, String tema) {
		super();
		init(nombre, apellido, mail, tema);
	}
	public Orador(String nombre, String apellido, String mail, String tema, Date fechaAlta) {
		super();
		init(nombre, apellido, mail, tema);
	}

	public Orador(Long id, String nombre, String apellido, String mail, String tema, Date fechaAlta) {
		super();
		this.id = id;
		this.fechaAlta = fechaAlta;
		init(nombre, apellido, mail, tema);
	}
	//alt+shift+m Genera la sobrecarga de constructores
	public void init(String nombre, String apellido, String mail, String tema) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		
	}

	//alt+shift+s Genera sobreescritura ToString()
	@Override
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}

	public Long getId() {
		return this.id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		if(nombre != null)
			this.nombre = nombre;
		else 
			this.nombre = "N/D";
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
	
	
}
