package dev.ayush.EcomProductServiceDec23.Repository;

import dev.ayush.EcomProductServiceDec23.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
