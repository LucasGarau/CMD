package inicio;

import java.util.List;

import org.hibernate.Session;

import iniicio.idioma;
import iniicio.literal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String idiomaQuery;
		idiomaQuery = "es";
		Session _session = HibernateUtil.getSessionFactory().openSession();			
		List<idioma> result = (List<idioma>)_session.createQuery("from idioma where idi_cod = '" + idiomaQuery + "'").list();
		System.out.println(result.get(0).get_idioma());
		
		
		List<literal> result2 = (List<literal>)_session.createQuery("from literal where lit_id = '1' and idi_cod = '" + idiomaQuery + "'").list();
		System.out.println(idiomaQuery+result2.get(0).get_text());
		
		actualizar();
		
    }
    public static void actualizar() {
		String idiomaQuery2="PO";
		Session _session2 = HibernateUtil.getSessionFactory().openSession();			
		List<idioma> result2 = (List<idioma>)_session2.createQuery("from idioma where idi_cod = '" + idiomaQuery2 + "'").list();
		idioma auxIdi2 = result2.get(0);
		auxIdi2.setIdioma("MO");
		_session2.beginTransaction();
		_session2.update(auxIdi2);
		_session2.getTransaction().commit();
		_session2.close();
	}
    public void insertaridioma() {
    	Session _session3 = HibernateUtil.getSessionFactory().openSession();		
    	idioma auxIdi = new idioma();
		auxIdi.setIdioma("PO");
		_session3.beginTransaction();
		_session3.save(auxIdi);
		_session3.getTransaction().commit();
		_session3.close();
		
	}
    	 
}
