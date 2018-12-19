package com.pumbank.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Paga;

public class PagaManager {

	private static PagaManager instance = null;
	private static SessionFactory sf = null;

	public static PagaManager getInstance() throws Exception {
		if (instance == null)
			instance = new PagaManager();

		return instance;
	}
	
	private PagaManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
public Paga existePaga(int hid) throws Exception {
		
		Paga paga=null;
		List<Paga> pagas = null;
		
		Session session = sf.openSession();
		
		pagas = session.createQuery("FROM Paga").list();
		
		for (Paga unaPaga : pagas) {
			if (unaPaga.getHid()==hid) {paga = unaPaga;
			break;
			}
		}
		
//		session.close();
		return paga;
		
	}

public int createPaga(Paga unaPaga) throws Exception {
	
	Session session = sf.openSession();
	Transaction t = session.beginTransaction();

	int pgid = ((Integer) session.save(unaPaga)).intValue();

	t.commit();
	session.close();

	return pgid;
}

public void updatePaga(Paga unaPaga) {
	Session session = sf.openSession();
	Transaction t = session.beginTransaction();

	session.update(unaPaga);

	t.commit();
	session.close();

	
}

}
