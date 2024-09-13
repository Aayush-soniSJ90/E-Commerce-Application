package dev.ayush.EcomProductServiceDec23.Service;

import dev.ayush.EcomProductServiceDec23.Entity.Category;
import dev.ayush.EcomProductServiceDec23.Entity.Product;
import dev.ayush.EcomProductServiceDec23.Exception.CategoryNotFoundException;
import dev.ayush.EcomProductServiceDec23.Repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {


    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPriceForMultipleProducts(){
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double expectedCost = 300.00;
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);
        Assertions.assertEquals(actualTotalCost, expectedCost);
    }

    @Test
    public void testGetTotalPriceForZeroProducts(){
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptionalMockData = getCategoryMockDataWithZeroProduct();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptionalMockData);
        double actualTotalCost = categoryService.getTotalPriceForCategory(categoryId);
        double expectedTotalcost = 0.0;
        Assertions.assertEquals(actualTotalCost, expectedTotalcost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testCategoryNotFoundExceptionThrown(){
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getTotalPriceForCategory(categoryId));
        
    }


    private Optional<Category> getCategoryMockDataWithZeroProduct(){
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("categoryName");

        List<Product> products = new ArrayList<>();

        category.setProducts(products);
        return Optional.of(category);
    }

    public Optional<Category> getCategoryMockData(){
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("categoryName");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.00);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(200.00);
        product2.setCategory(category);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        category.setProducts(products);
        return Optional.of(category);

    }



}
