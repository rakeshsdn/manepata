package in.manepata.security.usermanager.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manepata.security.usermanager.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	List<Role> findByName(String name);

}
