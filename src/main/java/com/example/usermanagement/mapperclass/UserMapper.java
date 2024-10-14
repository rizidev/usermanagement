// package com.example.usermanagement.mapperclass;
// import java.util.stream.Collectors;
// import java.util.List;
// import com.example.usermanagement.dto.*;
// import com.example.usermanagement.model.*;
// public class Usermapper {
//     public UserDTO toDTO(User user) {
//         if (user == null) {
//             return null;
//         }
//         UserDTO dto = new UserDTO();
//         dto.setId(user.getId());
//         dto.setName(user.getName());
//         return dto;
//     }
//      public List<UserDTO> toDTO(List<User> users) {
//         return users.stream()
//                     .map(this::toDTO)  // Use the single conversion method
//                     .collect(Collectors.toList());
//     }

//     // Method to convert userDTO to user entity
//     public User toEntity(UserDTO dto, String Email) {
//         if (dto == null) {
//             return null;
//         }
//         User user = new User();
//         user.setId(dto.getId());
//         user.setName(dto.getName());
//         user.setEmail(Email);  // Handle the price separately
//         return user;
//     }
// }
package com.example.usermanagement.mapperclass;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.User;
@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName()); // Only name and id
        return dto;
    }

    public List<UserDTO> toDTO(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public User toEntity(UserDTO dto, String email) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(email); // Handle email separately
        return user;
    }
}
