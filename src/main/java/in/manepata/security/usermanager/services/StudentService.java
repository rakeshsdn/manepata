package in.manepata.security.usermanager.services;

import java.util.*;

import in.manepata.security.usermanager.Mapper.StudentMapper;
import in.manepata.security.usermanager.dto.StudentDto;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;

import in.manepata.security.usermanager.entities.Student;
import in.manepata.security.usermanager.repository.interfaces.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CenterRepository centerRepository;
    
//    @Autowired
//   private Logger log;

    @Autowired
    public StudentService(StudentRepository studentRepository, CenterRepository centerRepository) {
        this.studentRepository = studentRepository;
        this.centerRepository = centerRepository;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos =  StudentMapper.mapToStudentDtoList(studentRepository.findAll());
        return studentDtos;
    }

    public ResponseEntity<StudentDto> getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            StudentDto studentDto = StudentMapper.mapToStudentDto(studentOptional.get());
            return ResponseEntity.ok(studentDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<StudentDto> createStudent(StudentDto StudentDto) {
        try {
            Center center = centerRepository.findById(StudentDto.getCenterId()).orElseThrow(() -> new RuntimeException("Center not found"));
            Student student = StudentMapper.mapToStudent(StudentDto,center);
            Student savedStudent = studentRepository.save(student);
            StudentDto savedStudentDto = StudentMapper.mapToStudentDto(savedStudent);
            return ResponseEntity.ok(savedStudentDto);
        } catch (Exception e) {
        	
        	BodyBuilder bld =  ResponseEntity.badRequest();
        	bld.body("Unable to create User.");
            return bld.build();
        }
    }

    public ResponseEntity<StudentDto> updateStudent(Long id, StudentDto studentDto) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setFirstName(studentDto.getFirstName());
            existingStudent.setLastName(studentDto.getLastName());
            // Update other fields as needed
            Student updatedStudent = studentRepository.save(existingStudent);
            StudentDto updatedStudentDto = StudentMapper.mapToStudentDto(updatedStudent);
            return ResponseEntity.ok(updatedStudentDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
