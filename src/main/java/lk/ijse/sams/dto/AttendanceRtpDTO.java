/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author Sineth
 */
public class AttendanceRtpDTO {
    private int studentId;
    private String studentName;
    private String subject;
    private String date;
    private String status;

    public AttendanceRtpDTO() {
    }

    public AttendanceRtpDTO(int studentId, String studentName, String subject, String date, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.subject = subject;
        this.date = date;
        this.status = status;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AttendanceRtpDTO{" + "studentId=" + studentId + ", studentName=" + studentName + ", subject=" + subject + ", date=" + date + ", status=" + status + '}';
    }
    
     
}
