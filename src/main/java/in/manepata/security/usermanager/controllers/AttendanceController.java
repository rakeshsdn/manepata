package in.manepata.security.usermanager.controllers;

import in.manepata.security.usermanager.entities.Attendance;
import in.manepata.security.usermanager.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public Attendance takeAttendance(@RequestBody Attendance attendance) {
        return attendanceService.takeAttendance(attendance);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudent(@PathVariable Long studentId) {
        return attendanceService.getAttendanceByStudent(studentId);
    }

    @GetMapping("/center/{centerId}")
    public List<Attendance> getAttendanceByCenter(@PathVariable Long centerId) {
        return attendanceService.getAttendanceByCenter(centerId);
    }

    @GetMapping("/center/{centerId}/student/{studentId}")
    public List<Attendance> getAttendanceByCenterAndStudent(@PathVariable Long centerId, @PathVariable Long studentId) {
        return attendanceService.getAttendanceByCenterAndStudent(centerId, studentId);
    }
}
