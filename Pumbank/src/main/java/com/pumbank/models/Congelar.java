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
	private Date fecha_inicio;
	
	@Column(name="fecha_fin")
	private Date fecha_fin;
		
	@Column(name="padre")
	private int pid;
	
	@Column(name="hijo")
	private int hid;



	public Congelar() {	}



	public Congelar(int cid, Date fecha_inicio, Date fecha_fin, int pid, int hid) {
		super();
		this.cid = cid;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
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

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public boolean validate() {
		boolean isValid=true;
		
		if(this.fecha_inicio==null) isValid=false;
		if(this.fecha_fin!=null) isValid=false;
		
		return isValid;
	}

	
}
