package com.pumbank.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name="congelarcuenta")

public class Congelar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	
	@Column(name="fecha_inicio")
	private Date fechainicio;
	
	@Column(name="fecha_fin")
	private Date fechafin;
		
	@Column(name="padre")
	private int pid;
	
	@Column(name="hijo")
	private int hid;



	public Congelar() {	}



	public Congelar(int cid, Date fechainicio, Date fechafin, int pid, int hid) {
		super();
		this.cid = cid;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.pid = pid;
		this.hid = hid;
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

	public int getCid() {
		return cid;
	}


	public void setConid(int cid) {
		this.cid = cid;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fecha_inicio) {
		this.fechainicio = fecha_inicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fecha_fin) {
		this.fechafin = fecha_fin;
	}

	public boolean validate() {
		boolean isValid=true;
		
		if(this.fechainicio==null) isValid=false;
		if(this.fechafin!=null) isValid=false;
		
		return isValid;
	}

	
}
