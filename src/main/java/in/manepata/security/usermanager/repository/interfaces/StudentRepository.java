package in.manepata.security.usermanager.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.manepata.security.usermanager.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
