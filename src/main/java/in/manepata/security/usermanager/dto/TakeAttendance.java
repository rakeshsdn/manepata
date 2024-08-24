package in.manepata.security.usermanager.dto;

public class TakeAttendance {
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long centerId;

    private String status;

    public TakeAttendance() {

    }

    public TakeAttendance(Long studentId, String firstName, String lastName, Long centerId, String status) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.centerId = centerId;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
