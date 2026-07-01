/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.sams.bo.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.sams.Entity.AttendanceMngEntity;
import lk.ijse.sams.Entity.dao.AttendanceMngDAO;
import lk.ijse.sams.bo.AttendanceMngBO;
import lk.ijse.sams.dao.impl.AttendanceDAOImpl;
import lk.ijse.sams.dto.AttendanceMngDTO;

/**
 *
 * @author Sineth
 */
public class AttendanceBOImpl implements AttendanceMngBO{

     private AttendanceMngDAO attendanceDAO = new AttendanceDAOImpl();
    
    @Override
    public boolean saveAttendance(int scheduleId, List<AttendanceMngDTO> list) throws Exception {

        List<AttendanceMngEntity> entityList = new ArrayList<>();

        for (AttendanceMngDTO dto : list) {

            entityList.add(new AttendanceMngEntity(
                    dto.getAttendanceId(),
                    dto.getStudentId(),
                    dto.getStudentName(),
                    dto.isPresent(),
                    dto.isAbsent()
            ));
        }

        return attendanceDAO.saveAttendance(scheduleId, entityList);

    }

    @Override
    public List<AttendanceMngDTO> getStudents(int scheduleId) throws Exception {
        List<AttendanceMngEntity> entityList = attendanceDAO.getStudents(scheduleId);

        List<AttendanceMngDTO> dtoList =
                new ArrayList<>();

        for (AttendanceMngEntity e : entityList) {

            dtoList.add(new AttendanceMngDTO(
                    e.getAttendanceId(),
                    e.getStudentId(),
                    e.getStudentName(),
                    e.isPresent(),
                    e.isAbsent()
            ));
        }

        return dtoList;

    }

    @Override
    public List<Integer> getScheduleIds() throws Exception {
    return attendanceDAO.getScheduleIds();
    }
    
}
