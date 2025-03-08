package al.sda.dao;

import al.sda.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (RuntimeException re){
            System.out.println(re.getLocalizedMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long Id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, Id);
            session.delete(product);
            transaction.commit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Product", Product.class).list();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findById(Long Id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, Id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findAllById(List<Long> ids){
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("from Product where id in (:ids)", Product.class);

            query.setParameter("ids", ids);
            return query.getResultList();
        }
    }
}
