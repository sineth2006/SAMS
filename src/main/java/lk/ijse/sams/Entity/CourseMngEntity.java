/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class CourseMngEntity {
    private int course_id;
    private String course_name;
    private String duration;

    public CourseMngEntity() {
    }

    public CourseMngEntity(int course_id, String course_name, String duration) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.duration = duration;
    }

    public void setCourseId(int course_id) {
        this.course_id = course_id;
    }

    public void setCourseName(String course_name) {
        this.course_name = course_name;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getCourseId() {
        return course_id;
    }

    public String getCourseName() {
        return course_name;
    }

    public String getDuration() {
        return duration;
    }    
}
