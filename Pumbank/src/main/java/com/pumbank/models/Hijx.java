package com.pumbank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Date fechanacimiento;
	
	@Column(name="saldo")
	private Double saldo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
//	@ManyToMany(mappedBy = "hijos", fetch=FetchType.EAGER)
//	private List<Padre> padre;
	
	
	public Hijx() {}


	public Hijx(int hid, String nombre, String apellidos, Date fechanacimiento, Double saldo, String email,
			String password, List<Padre> padre) {
		super();
		this.hid = hid;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.saldo = saldo;
		this.email = email;
		this.password = password;
//		this.padre = padre;
	}


	public int getHid() {
		return hid;
	}


	public void setHid(int hid) {
		this.hid = hid;
	}


//	public List<Padre> getPadre() {
//		return padre;
//	}
//
//
//	public void setPadre(List<Padre> padre) {
//		this.padre = padre;
//	}


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
		return fechanacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fechanacimiento = fecha_nacimiento;
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
		return password;
	}


	public void setContraseña(String contraseña) {
		this.password = contraseña;
	}


	public boolean validate() {
		boolean isValid=true;
		
		if(this.nombre==null || this.nombre.equals("")) isValid=false;
		if(this.apellidos==null || this.apellidos.equals("")) isValid=false;
		if(this.fechanacimiento==null || this.fechanacimiento.equals("")) isValid=false;
		if(this.email==null || this.email.equals("")) isValid=false;
		if(this.password==null || this.password.equals("")) isValid=false;
		
		return isValid;
	}
	
}
