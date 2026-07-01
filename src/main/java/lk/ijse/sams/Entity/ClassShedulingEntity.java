/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class ClassShedulingEntity {
    private int sheduling_id;
    private int course_id;
    private int subject_id;
    private int lecturer_id;
    private String date;
    private String time;
    private String class_No;

    public ClassShedulingEntity() {
    }

    public ClassShedulingEntity(int sheduling_id, int course_id, int subject_id, int lecturer_id, String date, String time, String class_No) {
        this.sheduling_id = sheduling_id;
        this.course_id = course_id;
        this.subject_id = subject_id;
        this.lecturer_id = lecturer_id;
        this.date = date;
        this.time = time;
        this.class_No = class_No;
    }

    public int getShedulingId() {
        return sheduling_id;
    }

    public void setShedulingId(int sheduling_id) {
        this.sheduling_id = sheduling_id;
    }

    public int getCourseId() {
        return course_id;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getLecturerId() {
        return lecturer_id;
    }

    public void setLecturerId(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassNo() {
        return class_No;
    }

    public void setClassNo(String class_No) {
        this.class_No = class_No;
    }

    @Override
    public String toString() {
        return "ClassShedulingEntity{" + "sheduling_id=" + sheduling_id + ", course_id=" + course_id + ", subject_id=" + subject_id + ", lecturer_id=" + lecturer_id + ", date=" + date + ", time=" + time + ", class_No=" + class_No + '}';
    }
    
    
    
}
