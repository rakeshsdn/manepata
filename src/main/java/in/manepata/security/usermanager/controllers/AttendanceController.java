package in.manepata.security.usermanager.controllers;

import in.manepata.security.usermanager.dto.AttendanceDto;
import in.manepata.security.usermanager.dto.TakeAttendance;
import in.manepata.security.usermanager.entities.Attendance;
import in.manepata.security.usermanager.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    public List<AttendanceDto> takeAttendance(@RequestBody List<AttendanceDto> attendanceDtos) {
        return attendanceService.takeAttendance(attendanceDtos);
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

    @GetMapping("/list/center/{centerId}")
    public List<TakeAttendance> getAttendanceListByCenter(@PathVariable Long centerId){

        return attendanceService.getAttendanceListByCenter(centerId);
    }


}
