package dev.ayush.EcomProductServiceDec23.Mapper;



import dev.ayush.EcomProductServiceDec23.Dto.CategoryResponseDTO;
import dev.ayush.EcomProductServiceDec23.Dto.CreateCategoryRequestDTO;
import dev.ayush.EcomProductServiceDec23.Dto.ProductResponseDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Category;
import dev.ayush.EcomProductServiceDec23.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class CategoryEntityDTOMapper {
    public static CategoryResponseDTO convertCategoryToCategoryResponseDTO(Category category){
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setCategoryName(category.getName());
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
        if(!(category.getProducts() == null || category.getProducts().isEmpty())){
            for(Product product : category.getProducts()){
                productResponseDTOs.add(ProductEntityDTOMapper.convertProductEntitytoProductResponseDTO(product));
            }
        }
        categoryResponseDTO.setProducts(productResponseDTOs);
        return categoryResponseDTO;
    }

    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDTO createCategoryRequestDTO){
        Category category = new Category();
        category.setName(createCategoryRequestDTO.getCategoryName());
        return category;
    }
}
