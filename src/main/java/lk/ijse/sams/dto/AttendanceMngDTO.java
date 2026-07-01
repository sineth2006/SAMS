/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author Sineth
 */
public class AttendanceMngDTO {
    private int attendanceId;
    private int studentId;
    private String studentName;
    private boolean present;
    private boolean absent;

    public AttendanceMngDTO() {
    }

    public AttendanceMngDTO(int attendanceId, int studentId, String studentName, boolean present, boolean absent) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.present = present;
        this.absent = absent;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    @Override
    public String toString() {
        return "AttendanceMngDTO{" + "attendanceId=" + attendanceId + ", studentId=" + studentId + ", studentName=" + studentName + ", present=" + present + ", absent=" + absent + '}';
    }
    
    
}
