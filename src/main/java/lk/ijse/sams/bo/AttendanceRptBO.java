/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.bo;

import java.time.LocalDate;
import java.util.List;
import lk.ijse.sams.dto.AttendanceRtpDTO;

/**
 *
 * @author Sineth
 */
public interface AttendanceRptBO{
    List<AttendanceRtpDTO> getAttendanceReport(int studentId,int subjectId,LocalDate from,LocalDate to) throws Exception;
    List<Integer> getStudentIds() throws Exception;
    List<Integer> getSubjectIds() throws Exception;
}
