package in.manepata.security.usermanager.repository.interfaces;

import in.manepata.security.usermanager.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByCenterId(Long centerId);

    List<Attendance> findByCenterIdAndStudentId(Long centerId, Long studentId);
}
