package com.pumbank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "padre")

public class Padre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fecha_nacimiento")
	private Date fechanacimiento;

	@Column(name = "tarjeta_credito")
	private String tarjetacredito;

	@Column(name = "cvv")
	private int cvv;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "mes_caducidad")
	private int expiremonth;

	@Column(name = "a_caducidad")
	private int expireyear;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch=FetchType.EAGER)
	@JoinTable(name = "padre_hijo_rel", joinColumns = { @JoinColumn(name = "padre") }, inverseJoinColumns = {
			@JoinColumn(name = "hijo") })
	private List<Hijx> hijos;

	public Padre() {
	}

//	public Padre(int pid, String nombre, String apellidos, Date fecha_nacimiento, String tarjeta_credito, int cvv,
//			String email, String contraseña, List<Hijx> hijos) {
//		super();
//		this.pid = pid;
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.fecha_nacimiento = fecha_nacimiento;
//		this.tarjeta_credito = tarjeta_credito;
//		this.cvv = cvv;
//		this.email = email;
//		this.contraseña = contraseña;
//		this.hijos = hijos;
//	}

	public List<Hijx> getHijos() {
		return hijos;
	}

<<<<<<< HEAD


	public Padre(int pid, String nombre, String apellidos, Date fechanacimiento, String tarjetacredito, int cvv,
		String email, String password, int expiremonth, int expireyear, List<Hijx> hijos) {
	super();
	this.pid = pid;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.fechanacimiento = fechanacimiento;
	this.tarjetacredito = tarjetacredito;
	this.cvv = cvv;
	this.email = email;
	this.password = password;
	this.expiremonth = expiremonth;
	this.expireyear = expireyear;
	this.hijos = hijos;
}
=======
	public Padre(int pid, String nombre, String apellidos, Date fechanacimiento, String tarjetacredito, int cvv,
			String email, String password, int expiremonth, int expireyear, List<Hijx> hijos) {
		super();
		this.pid = pid;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.tarjetacredito = tarjetacredito;
		this.cvv = cvv;
		this.email = email;
		this.password = password;
		this.expiremonth = expiremonth;
		this.expireyear = expireyear;
		this.hijos = hijos;
	}
>>>>>>> ff9f992c09e9858f7cfc5911ae9b452ea4e136c3

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getTarjetacredito() {
		return tarjetacredito;
	}

	public void setTarjetacredito(String tarjetacredito) {
		this.tarjetacredito = tarjetacredito;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
<<<<<<< HEAD
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getExpiremonth() {
		return expiremonth;
	}

	public void setExpiremonth(int expiremonth) {
		this.expiremonth = expiremonth;
	}

	public int getExpireyear() {
		return expireyear;
	}

	public void setExpireyear(int expireyear) {
		this.expireyear = expireyear;
	}

	public void setHijos(List<Hijx> hijos) {
		this.hijos = hijos;
	}
=======
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getExpiremonth() {
		return expiremonth;
	}

	public void setExpiremonth(int expiremonth) {
		this.expiremonth = expiremonth;
	}

	public int getExpireyear() {
		return expireyear;
	}

	public void setExpireyear(int expireyear) {
		this.expireyear = expireyear;
	}

	public void setHijos(List<Hijx> hijos) {
		this.hijos = hijos;
	}

	


>>>>>>> ff9f992c09e9858f7cfc5911ae9b452ea4e136c3

}
