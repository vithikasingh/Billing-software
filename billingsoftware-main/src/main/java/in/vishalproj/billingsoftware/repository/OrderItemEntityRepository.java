package in.vishalproj.billingsoftware.repository;

import java.util.List;
import java.util.Optional;

// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishalproj.billingsoftware.entity.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long> {
    
     List<OrderItemEntity> findAllByItemId(String itemId);
     Optional<OrderItemEntity> findByItemId(String itemId);
    
}
