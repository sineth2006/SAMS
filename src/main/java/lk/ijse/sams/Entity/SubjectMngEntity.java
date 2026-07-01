/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

/**
 *
 * @author Sineth
 */
public class SubjectMngEntity {
    private int subject_id;
    private String subject_name;
    private int courser_id;

    public SubjectMngEntity() {
    }

    public SubjectMngEntity(int subject_id, String subject_name, int courser_id) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.courser_id = courser_id;
    }

    public int getSubjectId() {
        return subject_id;
    }

    public void setSubjectId(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubjectName() {
        return subject_name;
    }

    public void setSubjectName(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getCourseId() {
        return courser_id;
    }

    public void setCourseId(int courser_id) {
        this.courser_id = courser_id;
    }

    @Override
    public String toString() {
        return "SubjectMngEntity{" + "subject_id=" + subject_id + ", subject_name=" + subject_name + ", courser_id=" + courser_id + '}';
    }
    
    
       
    
}
