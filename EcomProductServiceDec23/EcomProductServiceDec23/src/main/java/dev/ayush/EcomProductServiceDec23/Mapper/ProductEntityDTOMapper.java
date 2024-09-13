package dev.ayush.EcomProductServiceDec23.Mapper;

import dev.ayush.EcomProductServiceDec23.Dto.CreateProductRequestDTO;
import dev.ayush.EcomProductServiceDec23.Dto.ProductResponseDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntitytoProductResponseDTO(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setTitle(product.getTitle());
        responseDTO.setRating(product.getRating());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setCategory(product.getCategory().getName());
        responseDTO.setImageURL(product.getImageURL());

        return responseDTO;

    }

    public static Product convertCreateProductRequestDTOToProduct(CreateProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setTitle(productRequestDTO.getTitle());
        product.setRating(0);
        product.setDescription(productRequestDTO.getDescription());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageURL(productRequestDTO.getImageURL());
        return product;
    }
}
