package in.manepata.security.usermanager.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.manepata.security.usermanager.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
