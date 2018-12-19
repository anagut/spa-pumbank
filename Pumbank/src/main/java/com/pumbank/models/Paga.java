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
	private int frecuencia_dias;
	
	@Column(name="padre")
	private int pid;
	
	@Column(name="hijo")
	private int hid;
	
	public Paga() {}
	
	
	public Paga(int pgid, double cantidad, int frecuencia_dias, int pid, int hid) {
		super();
		this.pgid = pgid;
		this.cantidad = cantidad;
		this.frecuencia_dias = frecuencia_dias;
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


	public int getFrecuencia_dias() {
		return frecuencia_dias;
	}

	public void setFrecuencia_dias(int frecuencia_dias) {
		this.frecuencia_dias = frecuencia_dias;
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



	
}
