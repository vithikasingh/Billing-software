package in.vishalproj.billingsoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishalproj.billingsoftware.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>  {
    Optional <CategoryEntity>findByCategoryId(String categoryId);
    
}
