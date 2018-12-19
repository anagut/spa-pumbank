package com.pumbank.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pumbank.models.Padre;


public class PadreManager {
	
	private static PadreManager instancia = null;
	private static SessionFactory sf = null;

	public static PadreManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new PadreManager();

		return instancia;
	}
	
	private PadreManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	public Padre getPadre(int pid) throws Exception {
		Session session = sf.openSession();

		Padre recP = session.get(Padre.class, pid);

		//session.close();

		return recP;
	}
	
//	public void updateCongelar(Congelar congelado) {
//		Session session = sf.openSession();
//		Transaction t = session.beginTransaction();
//
//		session.update(congelado);
//
//		t.commit();
//		session.close();
//
//		
//	}
//	
//	public Congelar getCongelar(int id) throws Exception {
//		Session session = sf.openSession();
//
//		Congelar congelado = session.get(Congelar.class, id);
//
//		session.close();
//
//		return congelado;
//	}
//	public int createCongelar(Congelar congelado) throws Exception {
//		if(congelado==null) return 0;
//		
//		Session session = sf.openSession();
//		Transaction t = session.beginTransaction();
//
//		int id = ((Integer) session.save(congelado)).intValue();
//
//		t.commit();
//		session.close();
//
//		return id;
//	}
	
//	public List<Hijx> dameTodosLosHijxs() throws Exception {
//		List<Hijx> hijxs=null;
//		
//		Session session = sf.openSession();
//		
//		hijxs = session.createQuery("FROM Hijxs WHERE pid=?").list();
//		
//		session.close();
//		return hijxs;
//	}

}
