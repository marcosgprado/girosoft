/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uesb.giroscopio.util;



//import br.uesb.giroscopio.persistence.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateSessionFactory {
    private static final SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    static {
    try{
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    }catch(Throwable t){
        throw new ExceptionInInitializerError(t);
    }
}
public static Session getInstancia(){
    Session session = (Session) threadLocal.get();
    session = sessionFactory.openSession();
    threadLocal.set(session);
    return session;
}




}