package com.pumbank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="hijo")

public class Hijx {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hid;
	
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String contraseña;
	
	@ManyToMany(mappedBy = "hijos")
	private List<Padre> padre;
	
	
	public Hijx() {}


	public Hijx(int hid, String nombre, String apellidos, Date fecha_nacimiento, Double saldo, String email,
			String contraseña, List<Padre> padre) {
		super();
		this.hid = hid;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.saldo = saldo;
		this.email = email;
		this.contraseña = contraseña;
		this.padre = padre;
	}


	public int getHid() {
		return hid;
	}


	public void setHid(int hid) {
		this.hid = hid;
	}


	public List<Padre> getPadre() {
		return padre;
	}


	public void setPadre(List<Padre> padre) {
		this.padre = padre;
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


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldoMas() {
		return saldo;
	}


	public void setSaldoMas(Double saldo) {
		this.saldo += saldo;
	}
	
	public Double getSaldoMenos() {
		return saldo;
	}


	public void setSaldoMenos(Double saldo) {
		this.saldo -= saldo;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
