package in.manepata.security.usermanager.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import in.manepata.security.usermanager.entities.*;
import in.manepata.security.usermanager.exceptions.UserNotFoundException;
import in.manepata.security.usermanager.repository.interfaces.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
    	return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        // Apply validation and security measures here (e.g., password hashing)
        return userRepository.save(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    // Apply validation and update logic here
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    // Assign roles to a user
    @PostMapping("/{userId}/roles")
    public void assignRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Set<Role> roles = (Set<Role>) roleRepository.findAllById(roleIds);
        user.setRoles(roles);
        userRepository.save(user);
    }

    // Assign user types to a user
    @PostMapping("/{userId}/userTypes")
    public void assignUserTypes(@PathVariable Long userId, @RequestBody List<Long> userTypeIds) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        List<UserType> userTypes = userTypeRepository.findAllById(userTypeIds);
        user.setUserTypes(userTypes);
        userRepository.save(user);
    }
}


