/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.Entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Sineth
 */
public class AttendanceMngEntity {
    private int attendance_id;
    private int student_id;
    private String student_name;
    private BooleanProperty present = new SimpleBooleanProperty(false);
    private BooleanProperty absent = new SimpleBooleanProperty(false);

    public AttendanceMngEntity() {
    }

    public AttendanceMngEntity(int attendance_id, int student_id, String student_name, boolean present, boolean absent) {
        this.attendance_id = attendance_id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.present.set(present);
        this.absent.set(absent);
    }

    public int getAttendanceId() {
        return attendance_id;
    }

    public void setAttendanceId(int attendance_id) {
        this.attendance_id = attendance_id;
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

    public BooleanProperty presentProperty() {
        return present;
    }

    public boolean isPresent() {
        return present.get();
    }

    public void setPresent(boolean value) {
        present.set(value);
    }

    public BooleanProperty absentProperty() {
        return absent;
    }

    public boolean isAbsent() {
        return absent.get();
    }

    public void setAbsent(boolean value) {
        absent.set(value);
    }

    @Override
    public String toString() {
        return "AttendanceMngEntity{" + "attendance_id=" + attendance_id + ", student_id=" + student_id + ", student_name=" + student_name + ", present=" + present + ", absent=" + absent + '}';
    }
    
    
}
