package dev.ayush.EcomProductServiceDec23.Service;

import dev.ayush.EcomProductServiceDec23.Dto.CreateProductRequestDTO;
import dev.ayush.EcomProductServiceDec23.Dto.ProductResponseDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Category;
import dev.ayush.EcomProductServiceDec23.Entity.Product;
import dev.ayush.EcomProductServiceDec23.Exception.CategoryNotFoundException;
import dev.ayush.EcomProductServiceDec23.Exception.ProductNotFoundException;
import dev.ayush.EcomProductServiceDec23.Mapper.ProductEntityDTOMapper;
import dev.ayush.EcomProductServiceDec23.Repository.CategoryRepository;
import dev.ayush.EcomProductServiceDec23.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> savedProducts =  productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        for(Product product : savedProducts){
            productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(product));
        }
        return productResponseDTOs;
    }

    @Override
    public ProductResponseDTO getProduct(UUID ProductId) throws ProductNotFoundException {
        Product product = productRepository.findById(ProductId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the id: " + ProductId)
        );
        return ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(CreateProductRequestDTO productRequestDTO) {
        Product product = ProductEntityDTOMapper.convertCreateProductRequestDTOToProduct(productRequestDTO);
        Category savedCategory = categoryRepository.findById(productRequestDTO.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException("Category not found for the id: " + productRequestDTO.getCategoryId())
        );

        product.setCategory(savedCategory);
        product = productRepository.save(product);

        return ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(product);

    }

    @Override
    public ProductResponseDTO updateProduct(CreateProductRequestDTO createProductRequestDTO, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Product not found for the id: " + productId));
        savedProduct.setTitle(createProductRequestDTO.getTitle());
        savedProduct.setPrice(createProductRequestDTO.getPrice());
        savedProduct.setDescription(createProductRequestDTO.getDescription());
        savedProduct.setImageURL(createProductRequestDTO.getImageURL());

        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDTO getProduct(String productName) {
        return ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(
                productRepository.findProductByTitle(productName)
        );
    }

    @Override
    public List<Product> getProducts(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
