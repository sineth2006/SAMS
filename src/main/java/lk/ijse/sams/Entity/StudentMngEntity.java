/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class StudentMngEntity {
    private int student_id;
    private String student_name;
    private int tel_no;
    private String email;
    private int course_id;

    public StudentMngEntity(int student_id, String student_name, int tel_no, String email, int course_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.tel_no = tel_no;
        this.email = email;
        this.course_id = course_id;
    }

    public StudentMngEntity() {
    }

    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }

    public String getStudentName() {
        return student_name;
    }

    public void setStudentName(String student_name) {
        this.student_name = student_name;
    }

    public int getTelNo() {
        return tel_no;
    }

    public void setTelNo(int tel_no) {
        this.tel_no = tel_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

}
