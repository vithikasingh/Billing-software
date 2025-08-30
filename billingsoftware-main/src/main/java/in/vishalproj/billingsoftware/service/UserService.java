package in.vishalproj.billingsoftware.service;

import java.util.List;

import in.vishalproj.billingsoftware.io.UserRequest;
import in.vishalproj.billingsoftware.io.UserResponse;

public interface UserService {
    
   UserResponse createUser(UserRequest request);

   String getUserRole(String email);
   List<UserResponse> readUsers();
   void deleteUser(String id);

}
