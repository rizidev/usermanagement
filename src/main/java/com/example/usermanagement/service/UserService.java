// package com.example.usermanagement.service;

// import java.util.List;
// import com.example.usermanagement.dto.*;
// // import com.example.usermanagement.model.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.example.usermanagement.mapperclass.*;
// import com.example.usermanagement.model.User;
// import com.example.usermanagement.repository.UserRepository;

// @Service
// public class UserService {
//     @Autowired
    
//      private UserRepository userRepository;
//     private Usermapper usermapper;
//     public User createUser(User user) {
//         return userRepository.save(user);
//     }

//     public List<UserDTO> getAllUsers() {
//         List<User> users =userRepository.findAll();
//         return usermapper.toDTO(users);
//     }

//     public User getUserById(Long id) {
//         return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//     }

//     public User updateUser(Long id, User updatedUser) {
//         User user = getUserById(id);
//         user.setName(updatedUser.getName());
//         user.setEmail(updatedUser.getEmail());
//         return userRepository.save(user);
//     }

//     public boolean deleteUser(Long id) {
       
//         userRepository.deleteById(id);
//     return 0;
//     }
// }
package com.example.usermanagement.service;

import java.util.List;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.mapperclass.*;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    public UserDTO createUser(User user) {
        User createdUser = userRepository.save(user);
        return userMapper.toDTO(createdUser); // Convert to DTO before returning
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDTO(users); // Convert to DTOs
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user); // Convert to DTO
    }

    public UserDTO updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser); // Convert to DTO before returning
    }

    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true; // Return true to indicate success
    }
}
