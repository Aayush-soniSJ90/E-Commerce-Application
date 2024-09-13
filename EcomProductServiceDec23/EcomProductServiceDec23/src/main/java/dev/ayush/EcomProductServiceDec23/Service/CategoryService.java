package dev.ayush.EcomProductServiceDec23.Service;

import dev.ayush.EcomProductServiceDec23.Dto.CategoryResponseDTO;
import dev.ayush.EcomProductServiceDec23.Dto.CreateCategoryRequestDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponseDTO getCategory(UUID categoryId);
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO createCategory(CreateCategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(CreateCategoryRequestDTO categoryRequestDTO, UUID categoryId);
    boolean deleteCategory(UUID categoryId);
    double getTotalPriceForCategory(UUID categoryId);
}
