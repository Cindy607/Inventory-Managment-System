package al.sda.service;

import al.sda.Dto.ProductDto;
import al.sda.Entity.Product;
import al.sda.configure.HibernateConfig;
import al.sda.converter.ProductConverter;
import al.sda.dao.ProductDao;
import al.sda.dao.ProductDaoImpl;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private final ProductDao productDao = new ProductDaoImpl(sessionFactory);


    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = ProductConverter.converDtoToEntity(productDto);
        productDao.save(product);
        return product;
    }

    @Override
    public Product findOne(Long Id) {
        return productDao.findById(Id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
}
