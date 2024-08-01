package in.manepata.security.usermanager.Mapper;

import in.manepata.security.usermanager.dto.StudentDto;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.entities.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public static Student mapToStudent(StudentDto studentDto, Center center) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setAge(studentDto.getAge());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setMotherName(studentDto.getMotherName());
        student.setFatherName(studentDto.getFatherName());
        student.setMotherOccupation(studentDto.getMotherOccupation());
        student.setFatherOccupation(studentDto.getFatherOccupation());
        student.setGrade(studentDto.getGrade());
        student.setGender(studentDto.getGender());
        student.setDetails(studentDto.getDetails());
        student.setCenter(center);
        return student;
    }

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setAge(student.getAge());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setMotherName(student.getMotherName());
        studentDto.setFatherName(student.getFatherName());
        studentDto.setMotherOccupation(student.getMotherOccupation());
        studentDto.setFatherOccupation(student.getFatherOccupation());
        studentDto.setGrade(student.getGrade());
        studentDto.setGender(student.getGender());
        studentDto.setDetails(student.getDetails());
        if (student.getCenter() != null) {
            studentDto.setCenterId(student.getCenter().getId());
        }
        return studentDto;
    }

    public static List<StudentDto> mapToStudentDtoList(List<Student> students) {
        return students.stream()
                .map(StudentMapper::mapToStudentDto) // Convert each Student to StudentDto
                .collect(Collectors.toList());       // Collect the results into a List
    }
}
