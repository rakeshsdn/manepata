package in.manepata.security.usermanager.repository.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manepata.security.usermanager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	 // Find by username with case-insensitive search (for login purposes)
    Optional<User> findByUsernameIgnoreCase(String username);

    // Find by email with case-insensitive search
    Optional<User> findByEmailIgnoreCase(String email);

//    // Find users by role (assuming a relationship exists)
//    List<User> findByRoles_Name(String roleName);
//
//    // Find users by a list of roles
//    List<User> findByRoles_NameIn(List<String> roleNames);
//
//    // Find users by user type (assuming a relationship exists)
//    List<User> findByUserTypes_Type(String userTypeName);
//
//    // Find users by a list of user types
//    List<User> findByUserTypes_TypeIn(List<String> userTypes);
	
}
