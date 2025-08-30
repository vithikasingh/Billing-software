package in.vishalproj.billingsoftware.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.vishalproj.billingsoftware.entity.CategoryEntity;
import in.vishalproj.billingsoftware.io.CategoryRequest;
import in.vishalproj.billingsoftware.io.CategoryResponse;
import in.vishalproj.billingsoftware.repository.CategoryRepository;
import in.vishalproj.billingsoftware.repository.ItemRepository;
import in.vishalproj.billingsoftware.service.CategoryService;
import in.vishalproj.billingsoftware.service.FileUploadService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;
    private final ItemRepository itemRepository;

    @Override
    public CategoryResponse add(CategoryRequest request,MultipartFile file) {
      String imgUrl=fileUploadService.uploadFile(file);
      CategoryEntity newCategory =convertToEntity(request);
      newCategory.setImgUrl(imgUrl);
      newCategory=categoryRepository.save(newCategory);
      return convertToResponse(newCategory);
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
      Integer itemCount = itemRepository.countByCategoryId(newCategory.getId());
       return CategoryResponse.builder()
               .categoryId(newCategory.getCategoryId())
               .name(newCategory.getName())
               .description(newCategory.getDescription())
               .bgColor(newCategory.getBgColor())
               .imgUrl(newCategory.getImgUrl())
               .createdAt(newCategory.getCreatedAt())
               .updatedAt(newCategory.getUpdatedAt())
                .items(itemCount)
               .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
      return CategoryEntity.builder()
               .categoryId(UUID.randomUUID().toString())
               .name(request.getName())
               .description(request.getDescription())
               .bgColor(request.getBgColor())
               .build();
    }

    @Override
    public List<CategoryResponse> read() {
       return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
      CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
              .orElseThrow(()-> new RuntimeException("Category not found: "+categoryId));
              fileUploadService.deleteFile(existingCategory.getImgUrl());
              categoryRepository.delete(existingCategory);
    }
    
}
