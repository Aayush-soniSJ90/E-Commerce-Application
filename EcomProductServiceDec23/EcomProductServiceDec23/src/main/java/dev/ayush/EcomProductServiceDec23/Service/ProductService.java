package dev.ayush.EcomProductServiceDec23.Service;

import dev.ayush.EcomProductServiceDec23.Dto.CreateProductRequestDTO;
import dev.ayush.EcomProductServiceDec23.Dto.ProductResponseDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Product;
import dev.ayush.EcomProductServiceDec23.Exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(UUID ProductId) throws ProductNotFoundException;
    ProductResponseDTO createProduct(CreateProductRequestDTO product);
    ProductResponseDTO updateProduct(CreateProductRequestDTO productRequestDTO, UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDTO getProduct(String productName);
    List<Product> getProducts(double minPrice, double maxPrice);
}
