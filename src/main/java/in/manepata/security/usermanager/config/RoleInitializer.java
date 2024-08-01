package in.manepata.security.usermanager.config;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import in.manepata.security.usermanager.entities.Role;
import in.manepata.security.usermanager.repository.interfaces.RoleRepository;
import jakarta.annotation.PostConstruct;


public class RoleInitializer {

//    @Autowired
//    private RoleRepository roleRepository;
//
//    private String rolesConfig;
//
//    @PostConstruct
//    public void createRoles() {
//        // Parse roles from config string
//        List<String> roleNames = Arrays.asList(rolesConfig.split(","));
//
////        @Configuration
//        
//        // Check if any existing roles exist
//        List<String> existingNames = roleRepository.findAll().stream()
//                .map(Role::getName).collect(Collectors.toList());
//
//        // Create and save missing roles
//        for (String roleName : roleNames) {
//            if (!existingNames.contains(roleName)) {
//                Role role = new Role(roleName);
//                roleRepository.save(role);
//            }
//        }
//    }
}

