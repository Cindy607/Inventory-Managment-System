package al.sda.converter;

import al.sda.Dto.ProductDto;
import al.sda.Entity.Category;
import al.sda.Entity.Product;

public class ProductConverter {

    public static Product converDtoToEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(new Category(productDto.getCategoryId()));
        return product;
    };

    public static ProductDto converEntityToDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setQuantity(product.getQuantity());
        productDto.setPrice(product.getPrice());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;
    }

}
