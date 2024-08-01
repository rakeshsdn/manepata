package in.manepata.security.usermanager.services;

import in.manepata.security.usermanager.entities.Attendance;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.entities.Student;
import in.manepata.security.usermanager.repository.interfaces.AttendanceRepository;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import in.manepata.security.usermanager.repository.interfaces.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CenterRepository centerRepository;

    public Attendance takeAttendance(Attendance attendance) {
        Student student = studentRepository.findById(attendance.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Center center = centerRepository.findById(attendance.getCenter().getId())
                .orElseThrow(() -> new RuntimeException("Center not found"));

        attendance.setStudent(student);
        attendance.setCenter(center);

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByStudent(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

    public List<Attendance> getAttendanceByCenter(Long centerId) {
        return attendanceRepository.findByCenterId(centerId);
    }

    public List<Attendance> getAttendanceByCenterAndStudent(Long centerId, Long studentId) {
        return attendanceRepository.findByCenterIdAndStudentId(centerId, studentId);
    }
}
