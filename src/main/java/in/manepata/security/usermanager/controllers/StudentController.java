package in.manepata.security.usermanager.controllers;

import java.util.List;

import in.manepata.security.usermanager.dto.StudentDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.manepata.security.usermanager.entities.Student;
import in.manepata.security.usermanager.services.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/{centerId}")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto, @PathVariable Long centerId) {

        return studentService.createStudent(studentDto);
    }

    @PutMapping("/{id}/{centerId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/{id}/{centerId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {

        return studentService.deleteStudent(id);
    }

    @GetMapping("/center/{centerId}")
    public ResponseEntity<List<StudentDto>> studentListByCenter(@PathVariable Long centerId){
        return studentService.studentListByCenter(centerId);
    }

    @GetMapping("/{studentId}/{centerId}")
    public ResponseEntity<StudentDto> studentListByCenter(@PathVariable Long centerId, @PathVariable Long studentId ){
         return studentService.getStudentById(studentId);
    }
}
