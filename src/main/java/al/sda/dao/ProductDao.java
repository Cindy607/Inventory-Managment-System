package al.sda.dao;

import al.sda.Entity.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);
    void delete(Long Id);
    List<Product> findAll();
    Product findById(Long Id);

    List<Product> findAllById(List<Long> ids);
}
