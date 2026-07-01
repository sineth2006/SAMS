/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.dto;

/**
 *
 * @author Sineth
 */
public class ClassShedulingDTO {
    private int shedulingId;
    private int courseId;
    private int subjectId;
    private int lecturerId;
    private String date;
    private String time;
    private String classNo;

    public ClassShedulingDTO() {
    }

    public ClassShedulingDTO(int shedulingId, int courseId, int subjectId, int lecturerId, String date, String time, String classNo) {
        this.shedulingId = shedulingId;
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.lecturerId = lecturerId;
        this.date = date;
        this.time = time;
        this.classNo = classNo;
    }

    public int getShedulingId() {
        return shedulingId;
    }

    public void setShedulingId(int shedulingId) {
        this.shedulingId = shedulingId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
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
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "ClassShedulingDTO{" + "shedulingId=" + shedulingId + ", courseId=" + courseId + ", subjectId=" + subjectId + ", lecturerId=" + lecturerId + ", date=" + date + ", time=" + time + ", classNo=" + classNo + '}';
    }
}
