package in.vishalproj.billingsoftware.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import in.vishalproj.billingsoftware.entity.CategoryEntity;
import in.vishalproj.billingsoftware.entity.ItemEntity;
import in.vishalproj.billingsoftware.io.ItemRequest;
import in.vishalproj.billingsoftware.io.ItemResponse;
import in.vishalproj.billingsoftware.repository.CategoryRepository;
import in.vishalproj.billingsoftware.repository.ItemRepository;
import in.vishalproj.billingsoftware.service.FileUploadService;
import in.vishalproj.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final FileUploadService fileUploadService;
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    @Override
    public ItemResponse add(ItemRequest request, MultipartFile file) {
       String imgUrl = fileUploadService.uploadFile(file);
       ItemEntity newItem =convertToEntity(request); 
      CategoryEntity existingCategory= categoryRepository.findByCategoryId(request.getCategoryId())
           .orElseThrow(()-> new RuntimeException("Category not found: " + request.getCategoryId()));
         newItem.setCategory(existingCategory);
         newItem.setImgUrl(imgUrl);
         newItem = itemRepository.save(newItem);
         return convertToResponse(newItem);
    }

    private ItemResponse convertToResponse(ItemEntity newItem) {
       
        return ItemResponse.builder()
                .itemId(newItem.getItemId())
                .name(newItem.getName())
                .description(newItem.getDescription())
                .price(newItem.getPrice())
                .imgUrl(newItem.getImgUrl())
                .categoryName(newItem.getCategory().getName())
                .categoryId(newItem.getCategory().getCategoryId())
                .createdAt(newItem.getCreatedAt())
                .updatedAt(newItem.getUpdatedAt())
                .build();
    }

    private ItemEntity convertToEntity(ItemRequest request) {
       return ItemEntity.builder()
                .itemId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    @Override
    public List<ItemResponse> fetchItems() {
       return itemRepository.findAll()
                .stream()
                .map(itemEntity -> convertToResponse(itemEntity))
                .collect(Collectors.toList());
         
    }

    @Override
    public void deleteItem(String itemId) {
       ItemEntity existingItem = itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found: " + itemId));
        boolean isFileDeleted = fileUploadService.deleteFile(existingItem.getImgUrl());
        if(isFileDeleted){
            itemRepository.delete(existingItem);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete the image.");
        }
    }

    
    
}
