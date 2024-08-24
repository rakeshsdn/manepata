package in.manepata.security.usermanager.services;

import in.manepata.security.usermanager.Mapper.AttendanceMapper;
import in.manepata.security.usermanager.dto.AttendanceDto;
import in.manepata.security.usermanager.dto.TakeAttendance;
import in.manepata.security.usermanager.entities.Attendance;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.entities.Student;
import in.manepata.security.usermanager.repository.interfaces.AttendanceRepository;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import in.manepata.security.usermanager.repository.interfaces.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CenterRepository centerRepository;

    public List<AttendanceDto> takeAttendance(List<AttendanceDto> attendanceDtos) {
        List<AttendanceDto> savedAttendanceDtos = new ArrayList<>();

        for (AttendanceDto attendanceDto : attendanceDtos) {
            // Fetch the Student and Center based on the IDs in the DTO
            Student student = studentRepository.findById(attendanceDto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            Center center = centerRepository.findById(attendanceDto.getCenterId())
                    .orElseThrow(() -> new RuntimeException("Center not found"));

            // Convert AttendanceDto to Attendance entity
            Attendance attendance = AttendanceMapper.toEntity(attendanceDto, student, center);

            // Save the Attendance entity
            Attendance savedAttendance = attendanceRepository.save(attendance);

            // Convert the saved Attendance entity back to AttendanceDto
            AttendanceDto savedAttendanceDto = AttendanceMapper.toDto(savedAttendance);

            // Add the saved AttendanceDto to the list
            savedAttendanceDtos.add(savedAttendanceDto);
        }

        return savedAttendanceDtos;
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
    public List<TakeAttendance> getAttendanceListByCenter(Long centerId){
        List<Student> students  = studentRepository.findByCenterId(centerId);

        return students.stream()
                .map(student -> new TakeAttendance(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getCenter().getId(),
                        null
                ))
                .collect(Collectors.toList());
    }

}
