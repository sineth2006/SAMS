/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class AttendanceRtpEntity {
    private Integer student_id;
    private String student_name;
    private String subject;
    private String date;
    private String status;

    public AttendanceRtpEntity() {
    }

    public AttendanceRtpEntity(Integer studentId, String studentName, String subject, String date, String status) {
        this.student_id = studentId;
        this.student_name = studentName;
        this.subject = subject;
        this.date = date;
        this.status = status;
    }

    public Integer getStudentId() {
        return student_id;
    }

    public void setStudentId(Integer studentId) {
        this.student_id = studentId;
    }

    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String studentName) {
        this.student_name = studentName;
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
        return "AttendanceRtpEntity{" + "student_id=" + student_id + ", student_name=" + student_name + ", subject=" + subject + ", date=" + date + ", status=" + status + '}';
    }
    
    
}
