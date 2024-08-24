package in.manepata.security.usermanager.Mapper;

import in.manepata.security.usermanager.dto.AttendanceDto;
import in.manepata.security.usermanager.entities.Attendance;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.entities.Student;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import in.manepata.security.usermanager.repository.interfaces.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceMapper {

    // Convert AttendanceDto to Attendance
    public static Attendance toEntity(AttendanceDto attendanceDto, Student student, Center center) {
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setCenter(center);
        attendance.setStatus(attendanceDto.getStatus());
        attendance.setDate(LocalDateTime.now()); // Set the date to the current time
        return attendance;
    }

    // Convert Attendance to AttendanceDto
    public static AttendanceDto toDto(Attendance attendance) {
        AttendanceDto attendanceDto = new AttendanceDto();
        attendanceDto.setStudentId(attendance.getStudent().getId());
        attendanceDto.setCenterId(attendance.getCenter().getId());
        attendanceDto.setStatus(attendance.getStatus());
        return attendanceDto;
    }

    // Convert a list of AttendanceDto to a list of Attendance
    public static List<Attendance> toEntityList(List<AttendanceDto> attendanceDtos, StudentRepository studentRepository, CenterRepository centerRepository) {
        return attendanceDtos.stream().map(dto -> {
            Student student = studentRepository.findById(dto.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            Center center = centerRepository.findById(dto.getCenterId())
                    .orElseThrow(() -> new RuntimeException("Center not found"));
            return toEntity(dto, student, center);
        }).collect(Collectors.toList());
    }

    // Convert a list of Attendance to a list of AttendanceDto
    public static List<AttendanceDto> toDtoList(List<Attendance> attendances) {
        return attendances.stream()
                .map(AttendanceMapper::toDto)
                .collect(Collectors.toList());
    }
}
