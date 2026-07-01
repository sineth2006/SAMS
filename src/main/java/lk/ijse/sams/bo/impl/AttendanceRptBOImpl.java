/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.AttendanceRtpEntity;
import lk.ijse.sams.Entity.dao.AttendanceRtpDAO;
import lk.ijse.sams.bo.AttendanceRptBO;
import lk.ijse.sams.dao.impl.AttendanceRtpDAOImpl;
import lk.ijse.sams.dto.AttendanceRtpDTO;

/**
 *
 * @author Sineth
 */
public class AttendanceRptBOImpl implements AttendanceRptBO{

    private AttendanceRtpDAO attendanceRptDAO = new AttendanceRtpDAOImpl();
    
    @Override
    public List<AttendanceRtpDTO> getAttendanceReport(int studentId, int subjectId, LocalDate from, LocalDate to) throws Exception {

    List<AttendanceRtpEntity> entityList = attendanceRptDAO.getAttendanceReport(studentId,subjectId,from,to);

    List<AttendanceRtpDTO> dtoList=new ArrayList<>();

    for(AttendanceRtpEntity e:entityList){

        dtoList.add(new AttendanceRtpDTO(

                e.getStudentId(),
                e.getStudentName(),
                e.getSubject(),
                e.getDate(),
                e.getStatus()
        ));
    }

    return dtoList;
    }

    @Override
    public List<Integer> getStudentIds() throws Exception {
        return attendanceRptDAO.getStudentIds();  
    }

    @Override
    public List<Integer> getSubjectIds() throws Exception {
        return attendanceRptDAO.getSubjectIds();
    }  
}
