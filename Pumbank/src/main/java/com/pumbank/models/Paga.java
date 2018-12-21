package com.pumbank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paga")

public class Paga {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pgid;

	@Column(name="cantidad")
	private double cantidad;
	
	@Column(name="frecuencia")
	private int frecuencia;
	
	@Column(name="padre")
	private int pid;
	
	@Column(name="hijo")
	private int hid;
	
	public Paga() {}
	
	
	public Paga(int pgid, double cantidad, int frecuencia, int pid, int hid) {
		super();
		this.pgid = pgid;
		this.cantidad = cantidad;
		this.frecuencia = frecuencia;
		this.pid = pid;
		this.hid = hid;
	}

	public int getPgid() {
		return pgid;
	}

	public void setPgid(int pgid) {
		this.pgid = pgid;
	}


	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public boolean validate() {
		boolean isValid=true;
		
		if(this.cantidad<0) isValid=false;
		if(this.frecuencia<=0) isValid=false;
		
		return isValid;
	}

	
}
