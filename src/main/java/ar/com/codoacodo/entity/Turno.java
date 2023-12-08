package ar.com.codoacodo.entity;


import java.time.LocalDate;
import java.util.Date;

public class Turno {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private LocalDate fecha_turno;
	private String hora_turno;
	private String tipo_corte;
	private Date fecha_alta;

	//alt+shift+s Genera constructores automaticamente
	public Turno(Long id, String nombre, String apellido, String mail, LocalDate fecha_turno, String hora_turno,
			String tipo_corte, Date fecha_alta) {
		super();
		init(nombre, apellido, mail, fecha_turno, hora_turno, tipo_corte);
		this.id = id;
		this.fecha_alta = fecha_alta;
	}
	public Turno(String nombre, String apellido, String mail, LocalDate fecha_turno, String hora_turno, String tipo_corte,
			Date fecha_alta) {
		super();
		init(nombre, apellido, mail, fecha_turno, hora_turno, tipo_corte);
		this.fecha_alta = fecha_alta;
	}
	public Turno(String nombre, String apellido, String mail, LocalDate fecha_turno, String hora_turno, String tipo_corte
			) {
		super();
		init(nombre, apellido, mail, fecha_turno, hora_turno, tipo_corte);
		this.fecha_turno = fecha_turno;
	}
	//alt+shift+m Genera la sobrecarga de constructores
	public void init(String nombre, String apellido, String mail, LocalDate fecha_turno, String hora_turno,
			String tipo_corte) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.fecha_turno = fecha_turno;
		this.hora_turno = hora_turno;
		this.tipo_corte = tipo_corte;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", fecha_turno="
				+ fecha_turno + ", hora_turno=" + hora_turno + ", tipo_corte=" + tipo_corte + "]";
	}
	
	//GETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	

	//alt+shift+s Genera sobreescritura ToString()
	
	

	
	
	
}
