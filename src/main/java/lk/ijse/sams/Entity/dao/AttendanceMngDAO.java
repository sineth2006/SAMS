/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.sams.Entity.dao;

import java.util.List;
import lk.ijse.sams.Entity.AttendanceMngEntity;

/**
 *
 * @author Sineth
 */
public interface AttendanceMngDAO {
    boolean saveAttendance(int scheduleId, List<AttendanceMngEntity> list) throws Exception;
    List<AttendanceMngEntity> getStudents(int scheduleId) throws Exception;
    List<Integer> getScheduleIds() throws Exception;
}
