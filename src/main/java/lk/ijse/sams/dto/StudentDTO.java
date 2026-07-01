/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author Sineth
 */
public class StudentDTO {
    private int studentId;
    private String studentName;
    private int telNo;
    private String email;
    private int courseId;

    public StudentDTO() {
    }

    public StudentDTO(int studentid, String studentname, int telNo, String email, int courseId) {
        this.studentId = studentid;
        this.studentName = studentname;
        this.telNo = telNo;
        this.email = email;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentid) {
        this.studentId = studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentname) {
        this.studentName = studentname;
    }

    public int getTelNo() {
        return telNo;
    }

    public void setTelNo(int telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "studentid=" + studentId + ", studentname=" + studentName + ", telNo=" + telNo + ", email=" + email + ", courseId=" + courseId + '}';
    }
    
    
}
