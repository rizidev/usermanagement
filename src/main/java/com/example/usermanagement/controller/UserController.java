// package com.example.usermanagement.controller;

// import com.example.usermanagement.model.User;
// import com.example.usermanagement.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @Controller
// @RequestMapping("/users")
// public class UserController {
//     @Autowired
//     private UserService userService;

//     @GetMapping
//     public String listUsers(Model model) {
//         List<User> users = userService.getAllUsers();
//         model.addAttribute("users", users);
//         return "userList";  // Returns the view name for displaying the user list
//     }

//     @GetMapping("/new")
//     public String showCreateForm(Model model) {
//         model.addAttribute("user", new User());
//         return "userForm";  // Returns the view name for creating a new user
//     }

//     @PostMapping
//     public String createUser(@ModelAttribute User user) {
//         userService.createUser(user);
//         return "redirect:/users";  // Redirects to the user list after creation
//     }

//     @GetMapping("/{id}/edit")
//     public String showEditForm(@PathVariable Long id, Model model) {
//         User user = userService.getUserById(id);
//         model.addAttribute("user", user);
//         return "userForm";  // Returns the view name for editing a user
//     }

//     @PostMapping("/{id}")
//     public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
//         userService.updateUser(id, user);
//         return "redirect:/users";  // Redirects to the user list after update
//     }

//     @GetMapping("/{id}/delete")
//     public String deleteUser(@PathVariable Long id) {
//         userService.deleteUser(id);
//         return "redirect:/users";  // Redirects to the user list after deletion
//     }
// }
//linke of post man
// package com.example.usermanagement.controller;

// import com.example.usermanagement.model.User;
// import com.example.usermanagement.service.UserService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// import com.example.usermanagement.dto.UserDTO;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     // Get all users
//     @GetMapping
//     public ResponseEntity<List<UserDTO>> listUsers() {
//         List<UserDTO> users = userService.getAllUsers();
//         return new ResponseEntity<>(users, HttpStatus.OK);  // Returns the list of users as JSON
//     }

//     // Create a new user
//     @PostMapping
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User createdUser = userService.createUser(user);
//         return new ResponseEntity<>(createdUser, HttpStatus.CREATED);  // Returns the created user as JSON
//     }

//     // Get a user by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         User user = userService.getUserById(id);
//         if (user != null) {
//             return new ResponseEntity<>(user, HttpStatus.OK);  // Returns the found user as JSON
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Returns a 404 if the user is not found
//         }
//     }

//     // Update an existing user
//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//         User updatedUser = userService.updateUser(id, user);
//         if (updatedUser != null) {
//             return new ResponseEntity<>(updatedUser, HttpStatus.OK);  // Returns the updated user as JSON
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Returns a 404 if the user is not found
//         }
//     }

//     // Delete a user
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//         //userService.deleteUser(id);
        
//             return new ResponseEntity<>userService.deleteUser(id));// Returns a 204 if deletion is successful
//         // } else {
//         //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Returns a 404 if the user is not found
//         // }
//     }
// }
package com.example.usermanagement.controller;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;
import com.example.usermanagement.mapperclass.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK); // Returns the list of users as JSON
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED); // Returns the created user as JSON
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK); // Returns the found user as JSON
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User user) {
        UserDTO updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK); // Returns the updated user as JSON
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Returns a 204 if deletion is successful
    }
}

