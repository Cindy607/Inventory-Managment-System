package al.sda.service;

import al.sda.Dto.ProductDto;
import al.sda.Entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto productDto);

    Product findOne(Long Id);

    List<Product> getAllProducts();


}
