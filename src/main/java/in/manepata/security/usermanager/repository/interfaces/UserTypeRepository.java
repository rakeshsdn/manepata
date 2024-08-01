package in.manepata.security.usermanager.repository.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manepata.security.usermanager.entities.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    // Find user type by name with case-insensitive search
//    Optional<UserType> findByNameIgnoreCase(String name);

    // Additional custom methods you might need:
    // - Find user types associated with specific privileges or permissions
    // - Support pagination and sorting for large datasets

}