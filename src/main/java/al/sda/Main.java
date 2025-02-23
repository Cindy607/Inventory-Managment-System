package al.sda;

import al.sda.configure.HibernateConfig;

public class Main {
    public static void main(String[] args) {

        HibernateConfig.getSessionFactory();
        System.out.println("Hello world!");
    }
}