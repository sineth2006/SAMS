/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class LecturerMngEntity {
    private int lecturer_id;
    private String lecturer_name;
    private String email;
    private String tel_no;
    private int user_id;
    private int subject_id;

    public LecturerMngEntity(int lecturer_id, String lecturer_name, String email, String tel_no, int user_id, int subject_id) {
        this.lecturer_id = lecturer_id;
        this.lecturer_name = lecturer_name;
        this.email = email;
        this.tel_no = tel_no;
        this.user_id = user_id;
        this.subject_id = subject_id;
    }

    public LecturerMngEntity() {
    }

    public int getLecturerId() {
        return lecturer_id;
    }

    public void setLecturerId(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getLecturerName() {
        return lecturer_name;
    }

    public void setLecturerName(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return tel_no;
    }

    public void setTelNo(String tel_no) {
        this.tel_no = tel_no;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
    }
        
}
