package com.pumbank.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Congelar;
import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;


public class HijoManager {
	
	private static HijoManager instance = null;
	private static SessionFactory sf = null;

	public static HijoManager getInstance() throws Exception {
		if (instance == null)
			instance = new HijoManager();

		return instance;
	}
	
	private HijoManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public Hijx getHijo(int id) throws Exception {
		Session session = sf.openSession();

		Hijx recH = session.get(Hijx.class, id);

		session.close();

		return recH;
	}
	
	public List<Hijx> getHijoPorIdPadre(int idp) throws Exception {
		
		List<Hijx> hijos=null;
		
		Session session = sf.openSession();
		
		hijos = session.createQuery("FROM Hijx").list();
		
		session.close();
		return hijos;
		
	}
	
	public void updateHijo(Hijx unHijo) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.update(unHijo);

		t.commit();
		session.close();

		
	}
	
	public void updateCongelar(Congelar congelado) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.update(congelado);

		t.commit();
		session.close();

		
	}
	
	public Congelar getCongelar(int id) throws Exception {
		Session session = sf.openSession();

		Congelar congelado = session.get(Congelar.class, id);

		session.close();

		return congelado;
	}
	public int createCongelar(Congelar congelado) throws Exception {
		if(congelado==null) return 0;
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int id = ((Integer) session.save(congelado)).intValue();

		t.commit();
		session.close();

		return id;
	}
	
}
