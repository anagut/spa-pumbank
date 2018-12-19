package com.pumbank.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Congelar;

public class CongelarManager {
	
	
	private static CongelarManager instance = null;
	private static SessionFactory sf = null;

	public static CongelarManager getInstance() throws Exception {
		if (instance == null)
			instance = new CongelarManager();

		return instance;
	}
	
	private CongelarManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
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
		if (congelado == null)
			return 0;

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int id = ((Integer) session.save(congelado)).intValue();

		t.commit();
		session.close();

		return id;
	}
}
