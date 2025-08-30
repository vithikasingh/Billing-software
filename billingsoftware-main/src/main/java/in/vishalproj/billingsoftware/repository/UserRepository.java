package in.vishalproj.billingsoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishalproj.billingsoftware.entity.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity , Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional <UserEntity> findByUserId(String userId);
    
    
}
