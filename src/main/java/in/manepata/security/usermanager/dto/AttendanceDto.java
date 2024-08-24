package in.manepata.security.usermanager.dto;

public class AttendanceDto {
    private Long studentId;
    private Long centerId;
    private String status;

    public AttendanceDto() {
    }

    public AttendanceDto(Long studentId, Long centerId, String status) {
        this.studentId = studentId;
        this.centerId = centerId;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
