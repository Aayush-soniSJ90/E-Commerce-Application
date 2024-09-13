package dev.ayush.EcomProductServiceDec23.Repository;

import dev.ayush.EcomProductServiceDec23.Entity.Category;
import dev.ayush.EcomProductServiceDec23.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByTitle(String title);
    Product findFirstProductByTitle(String title);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query(value = "SELECT * FROM ECOM_PRODUCT p WHERE p.price >=: minPrice AND p.price <=:maxPrice AND categoryId = :categoryId",
    nativeQuery = true)
    List<Product> findByPriceBetweenAndCategory(double minPrice, double maxPrice, UUID categoryId);




}
