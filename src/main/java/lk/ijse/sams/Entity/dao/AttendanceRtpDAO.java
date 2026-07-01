/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.time.LocalDate;
import java.util.List;
import lk.ijse.sams.Entity.AttendanceRtpEntity;

/**
 *
 * @author Sineth
 */
public interface AttendanceRtpDAO {
    List<AttendanceRtpEntity> getAttendanceReport(int studentId,int subjectId,LocalDate from,LocalDate to) throws Exception;
    List<Integer> getStudentIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
}
