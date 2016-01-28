package co.com.bnpparibas.cardif.example;

import co.com.bnpparibas.cardif.model.BogotaRow;
import co.com.bnpparibas.cardif.reader.ReaderFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppTest extends TestCase {



	public void testApp() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<BogotaRow> rows = new ArrayList<BogotaRow>();

		try {
			ReaderFile.readXLSXFile(rows);
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (BogotaRow r : rows) {
			session.save(r);

		}
		
		session.getTransaction().commit();
		session.close();

	}

	
}
