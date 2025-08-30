package in.vishalproj.billingsoftware.io;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    private String itemId;
     private String name;
    private  BigDecimal price;
    private String  categoryId;
    private String description;
    private String categoryName;
    private String imgUrl;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
    
}
