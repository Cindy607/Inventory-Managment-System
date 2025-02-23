package al.sda.converter;

import al.sda.Dto.ProductDto;
import al.sda.Entity.Category;
import al.sda.Entity.Product;

public class ProductConverter {

    public static Product convertDtoToEntity(ProductDto productDto) {
        Product product = new Product();

        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Category(productDto.getCategoryId()));

        return product;

    }
}
