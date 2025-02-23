package al.sda.configure;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static final SessionFactory sessionFactory = build();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    private static SessionFactory build(){

        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (ExceptionInInitializerError eiie) {
            throw new RuntimeException(eiie);
        }
    }

}
