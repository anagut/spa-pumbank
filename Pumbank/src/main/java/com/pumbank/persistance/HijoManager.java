package com.pumbank.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Congelar;
import com.pumbank.models.Hijx;
import com.pumbank.models.Padre;
import com.pumbank.models.Paga;


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
	
	public List<Hijx> getHijos() throws Exception {
		
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
	
	public int createHijo(Hijx unHijo) throws Exception {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int hid = ((Integer) session.save(unHijo)).intValue();

		t.commit();
		session.close();

		return hid;
	}
}
