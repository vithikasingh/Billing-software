package in.vishalproj.billingsoftware.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.vishalproj.billingsoftware.entity.UserEntity;
import in.vishalproj.billingsoftware.io.UserRequest;
import in.vishalproj.billingsoftware.io.UserResponse;
import in.vishalproj.billingsoftware.repository.UserRepository;
import in.vishalproj.billingsoftware.service.UserService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
     
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        UserEntity newUser =ConvertToEntity(request);
        newUser =userRepository.save(newUser);
        return convertToResponse(newUser);
    }

    private UserResponse convertToResponse(UserEntity newUser) {
       return UserResponse.builder()
                .name(newUser.getName())
                .email(newUser.getEmail())
                .userId(newUser.getUserId())
                .createdAt(newUser.getCreatedAt())
                .updatedAt(newUser.getUpdatedAt())
                .role(newUser.getRole())
                .build();
    }

    private UserEntity ConvertToEntity(UserRequest request) {
      return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole().toUpperCase())
                .name(request.getName())
                .build();
    }

    @Override
    public String getUserRole(String email) {
      UserEntity existingUser =userRepository.findByEmail(email)
                  .orElseThrow(()-> new UsernameNotFoundException("User not found for the email:"+email));
                  return existingUser.getRole();
    }

    @Override
    public List<UserResponse> readUsers() {
        return  userRepository.findAll()
                    .stream()
                    .map(user -> convertToResponse(user))
                    .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(String id) {
       UserEntity existingUser= userRepository.findByUserId(id)
            .orElseThrow(() ->new UsernameNotFoundException("User not found"));
            userRepository.delete(existingUser);

    }
    
}
